
import React, { Component } from 'react';

import {
    BrowserRouter as Router,
    Link
  } from "react-router-dom";


export class Home extends Component {


  render() {
    return (
      <div>
           <h1>Stack Operations</h1>
          <ul class="cards">
            <li class="cards_item">
              <div class="card">
                <div class="card_content">
                  <h2 class="card_title">Push An Item To Stack</h2>
                  <p class="card_text">Pushing an item will store the item on the top to the stack.</p>
                  <Link  to="/push" class="btn card_btn">Push Item</Link>
                </div>
              </div>
            </li>
            <li class="cards_item">
              <div class="card">
                <div class="card_content">
                  <h2 class="card_title">Pop An Item From Stack</h2>
                  <p class="card_text">Pop Item will remove the top most element from the stack and display.</p>
                  <Link to="/pop" class="btn card_btn">Pop Item</Link>
                </div>
              </div>
            </li>
            <li class="cards_item">
              <div class="card">
                <div class="card_content">
                  <h2 class="card_title">Get An Item From Stack</h2>
                  <p class="card_text">Get item will display item present at the given index.</p>
                  <Link to="/get" class="btn card_btn">Get Item</Link>
                </div>
              </div>
            </li>
          </ul>
      </div>
    );
  }
}

