// const tf = require("@tensorflow/tfjs-node");
// require("dotenv").config();

// const loadModel = async () => {
//   const modelUrl = process.env.MODEL_URL;

//   if (!modelUrl) {
//     throw new Error('MODEL_URL environment variable must be set.');
//   }

//   const model = await tf.loadLayersModel(modelUrl);

//   model.predict = async (data) => {
//     const inputTensor = tf.tensor(data);
//     const predictions = model.predict(inputTensor).dataSync();
//     return Array.from(predictions);
//   };

//   return model;
// };

// module.exports = loadModel;
