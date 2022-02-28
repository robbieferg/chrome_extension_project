
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import InfoContainer from './containers/InfoContainer';
import Popup from './components/popup';


const popupRoot = document.getElementById("popup-root");

const insertionPoint = document.createElement("div");
insertionPoint.id = "insertion-point";
document.body.parentNode.insertBefore(insertionPoint, document.body);

!popupRoot &&
  ReactDOM.render(
    <React.StrictMode>
      <InfoContainer/>
    </React.StrictMode>,
    insertionPoint
  );

popupRoot &&
    ReactDOM.render(
      <React.StrictMode>
        <Popup/>
      </React.StrictMode>,
      popupRoot
    );


