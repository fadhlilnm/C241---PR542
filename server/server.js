require('dotenv').config();
const express = require('express');
const bodyParser = require('body-parser');
const csv = require('csvtojson');
// const loadModel = require('../services/loadModel');
const routes = require('./routes');
const app = express();

app.use(bodyParser.json());
app.use('/', routes);

const startServer = async () => {
  try {
    // const model = await loadModel();
    // app.locals.model = model; 

    const port = process.env.PORT || 5000;
    app.listen(port, () => {
      console.log(`Server is running on port ${port}`);
    });
  } catch (error) {
    console.error('Failed to load model:', error);
    process.exit(1);
  }
};

startServer();
