import React, { Component } from 'react';
import {ENDPOINT} from './enpoints';
import {BackComponent} from './back';
import NotificationCenter from './notification';
import { NotificationType } from './notificationType';
import {NotificationContainer} from 'react-notifications';





export class PushComponent extends NotificationCenter {

  state = {
      data: 0
  };


  pushDataToStack = async () => {
    if(this.state.data != 0 && !this.state.data){
        return;
    }
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
    };
    const response = await fetch(ENDPOINT.PUSH+"?data="+this.state.data,requestOptions);
    const body = await response.json();
    if(body.successFull){
        this.setState({data: 0});
        this.createNotification(NotificationType.SUCCESS,"SuccessFully pushed the element");
    }else{
        this.createNotification(NotificationType.ERROR,body.errorMessage);
    }
   
  }

  handleInputChange = (e) => {
      this.setState({data : e.target.value});
  }


  render() {
    return (
      <div>
        <BackComponent></BackComponent>
        <NotificationContainer/>
        <div>
            <input type="number" value={this.state.data} className="push-inp" onChange={this.handleInputChange}></input>
            <button className="push-btn" onClick={ this.pushDataToStack}>Push Data</button>
        </div>
      </div>
    );
  }
}

