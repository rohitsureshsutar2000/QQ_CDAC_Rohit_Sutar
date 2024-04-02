// // Import the functions you need from the SDKs you need
// import { initializeApp } from "firebase/app";
// // TODO: Add SDKs for Firebase products that you want to use
// // https://firebase.google.com/docs/web/setup#available-libraries
// import { getAuth } from "firebase/auth";
// import { getFirestore } from "firebase/firestore";

// // Your web app's Firebase configuration
// // For Firebase JS SDK v7.20.0 and later, measurementId is optional
// const firebaseConfig = {
//   apiKey: process.env.REACT_APP_API_KEY,
//   authDomain: process.env.REACT_APP_AUTH_DOMAIN,
//   projectId: process.env.REACT_APP_PROJECT_ID,
//   storageBucket: process.env.REACT_APP_STORAGE_BUCKET,
//   messagingSenderId: process.env.REACT_APP_MESSAGING_SENDER_ID,
//   appId: process.env.REACT_APP_APP_ID,
//   measurementId: process.env.REACT_APP_MEASUREMENT_ID,
// };

// // Initialize Firebase
// const app = initializeApp(firebaseConfig);

// // Initialize Firebase Authentication and get a reference to the service
// export const auth = getAuth(app);
// export const db = getFirestore(app);
// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
// const firebaseConfig = {
//   apiKey: REACT_APP_API_KEY_GOES_HERE,
//   authDomain: REACT_APP_AUTH_DOMAIN_GOES_HERE,
//   projectId: REACT_APP_PROJECT_ID_GOES_HERE,
//   storageBucket: REACT_APP_STORAGE_BUCKET_GOES_HERE,
//   messagingSenderId: REACT_APP_MESSSAGING_SENDER_ID_GOES_HERE,
//   appId: REACT_APP_APP_ID_GOES_HERE,
// };

const firebaseConfig = {
  // apiKey: "AIzaSyAMvtAIRfLsYaax7th8u5ABCIEdBZhZmnc",
  // authDomain: "react-chat-4e1ab.firebaseapp.com",
  // projectId: "react-chat-4e1ab",
  // storageBucket: "react-chat-4e1ab.appspot.com",
  // messagingSenderId: "43534692024",
  // appId: "1:43534692024:web:067f3fb06bfbd100b9ce4d",
  // measurementId: "G-NFBNVJCNDX"

  apiKey: "AIzaSyB5zKmh-eh2k4BH_GrZfAqJntgvuBJgk6U",
  authDomain: "chatbot-fbaf5.firebaseapp.com",
  projectId: "chatbot-fbaf5",
  storageBucket: "chatbot-fbaf5.appspot.com",
  messagingSenderId: "432184047001",
  appId: "1:432184047001:web:d1c8ecb8484bd4f45acf08",
  measurementId: "G-Y6C70X1W9S"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
export const db = getFirestore(app);