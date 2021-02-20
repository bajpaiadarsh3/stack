
import React, { Component } from 'react';
import {
    BrowserRouter as Router,
    Link
  } from "react-router-dom";



export class BackComponent extends Component {

  render() {
    return (
        <div className="backButton">
          <Link to="/">Back To Home</Link>
        </div>
    );
  }
}

