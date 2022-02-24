
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import FlickBait from './FlickBait';
import InfoContainer from './containers/InfoContainer';



const insertionPoint = document.createElement("div");
insertionPoint.id = "insertion-point";
document.body.parentNode.insertBefore(insertionPoint, document.body);


ReactDOM.render(
  <React.StrictMode>
    <FlickBait/>
    <InfoContainer/>
  </React.StrictMode>,
  insertionPoint
);


