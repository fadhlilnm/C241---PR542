const express = require('express');
const router = express.Router();
const csv = require('csvtojson');
const path = require('path');

router.get('/test', (req, res) => {
  const csvFilePath = path.join(__dirname, 'recipe', 'data-timur.csv');
  console.log(`Testing file path: ${csvFilePath}`);
  res.send({ filePath: csvFilePath });
});


// get router area timur
router.get('/timur', (req, res) => {
  const csvFilePath = path.join(__dirname, 'data-timur.csv');

  csv().fromFile(csvFilePath)
    .then((jsonObj) => {
      const csvFilePath = jsonObj.map((data, i) => {
        return {
          id: i,
          name: data.name,
          place_type: data.place_type,
          address: data.address,
          rating: data.rating,
          latitude: data.latitude,
          longitude: data.longitude,
          hours: data.hours
        };
      });
      res.send(csvFilePath);
    })
    .catch((error) => {
      res.status(500).send({ error: 'Failed to load and process CSV file' });
    });
    console.log(`Testing file path: ${csvFilePath}`);
});

module.exports = router;