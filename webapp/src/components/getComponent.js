import React, { Component } from 'react';
import {ENDPOINT} from './enpoints';
import {BackComponent} from './back';
import NotificationCenter from './notification';
import { NotificationType } from './notificationType';
import {NotificationContainer} from 'react-notifications';





export class GetComponent extends NotificationCenter {

  state = {
      index: -1,
      data: undefined
  };


  getDataFromStack = async () => {
    if(this.state.index < 0){
        this.createNotification(NotificationType.ERROR,"Index cannoot be less than 0.");
        return;
    }
    const requestOptions = {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },
    };
    const response = await fetch(ENDPOINT.GET+"?index="+this.state.index,requestOptions);
    const body = await response.json();
    if(body.successFull){
        this.setState({data: body.data});
    }else{
      this.setState({data:undefined});
        this.createNotification(NotificationType.ERROR,body.errorMessage);
    }
   
  }

  handleInputChange = (e) => {
      this.setState({index : e.target.value,data:undefined});
  }


  render() {

    return (

      <div>
        <BackComponent></BackComponent>
        <NotificationContainer/>
        <div>
            <input type="number" value={this.state.index} className="get-inp" onChange={this.handleInputChange}></input>
            <button className="get-btn" onClick={ this.getDataFromStack}>Get</button>
            {
              (this.state.index > -1 && this.state.data) ?
              <div>
                Element at index {this.state.index} : {this.state.data}
              </div>:''
            }
        </div>
      </div>
    );
  }
}

