const { Firestore } = require("@google-cloud/firestore");
const db = new Firestore ();

const storeData = async ( data ) => {
  const collection = db.collection ('predictions');
  const doc = collection.doc (data.id);

  await doc.set (data);
};

module.exports = storeData;
