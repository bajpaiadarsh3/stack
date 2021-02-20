import React from 'react';
import {ENDPOINT} from './enpoints';
import {BackComponent} from './back';
import { NotificationType } from './notificationType';
import {NotificationContainer} from 'react-notifications';
import NotificationCenter from './notification';




export class PopComponent extends NotificationCenter {

  state = {
    data:undefined
  };


  getDataFromStack = async () => {
    const requestOptions = {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
    };
    const response = await fetch(ENDPOINT.POP,requestOptions);
    const body = await response.json();
    if(body.successFull){
        this.setState({data: body.data});
    }else{
        this.setState({data: undefined});
        this.createNotification(NotificationType.ERROR,body.errorMessage);
    }
  }



  render() {
    return (
      <div>
        <BackComponent></BackComponent>
        <NotificationContainer/>
        <button onClick={this.getDataFromStack}>Get Data</button>
        {(this.state.data || this.state.data == 0) ? <div>Pop Returned : {this.state.data}</div>:''}
        
      </div>
    );
  }
}

