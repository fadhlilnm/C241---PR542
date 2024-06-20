require('dotenv').config();
const express = require('express');
const router = express.Router();
const path = require('path');
const csv = require('csvtojson');

const getCsvFilePath = (area) => {
  const areaMap = {
    'utara': 'new_data_north_jakarta_city.csv',
    'timur': 'new_data_east_jakarta_city.csv',
    'barat': 'new_data_west_jakarta_city.csv',
    'selatan': 'new_data_south_jakarta_city.csv',
    'pusat': 'new_data_central_jakarta_city.csv'
  };

  return `${process.env.PATH_TO_CSV_FILES}/${areaMap[area]}`
};

router.get('/:area', async (req, res) => {
  const { area } = req.params;
  const csvFilePath = getCsvFilePath(area);

  if (!csvFilePath) {
    return res.status(400).send({ error: 'Invalid area specified' });
  }

  console.log(`Loading data for area: ${area} from file: ${csvFilePath}`);
  
  try {
    const jsonObj = await csv().fromFile(csvFilePath);

    const formatDataWarkop = jsonObj.map((data, i) => ({
      id: i,
      name: data.name,
      place_type: data.place_type,
      address: data.address,
      rating: data.rating,
      rating_count:data.rating_count,
      hours: data.new_column_1,
      parking:data.new_column_2,
      ac:data.new_column_3,
      wifi:data.wifnew_column_4,
      toilet:data.new_column_5

    }));

    console.log(jsonObj)
    const responseData = formatDataWarkop;

    res.json(responseData);
  } catch (error) {
    console.error(`Error processing CSV data file for area ${area}:`, error);
    res.status(500).send({ error: 'Failed to load CSV file' });
  }
});

module.exports = router;
