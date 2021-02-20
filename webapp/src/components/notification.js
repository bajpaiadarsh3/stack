import React from 'react';
import {NotificationContainer, NotificationManager} from 'react-notifications';
import {NotificationType} from './notificationType';
 
class NotificationCenter extends React.Component {

  createNotification = (type, msg) => {
      const TIME = 1000;
      switch (type) {
        case NotificationType.INFO:
          NotificationManager.info(msg,"Info!",TIME);
          break;
        case NotificationType.SUCCESS:
          NotificationManager.success(msg,"Success!",TIME);
          break;
        case NotificationType.WARNING:
          NotificationManager.warning(msg,"Warning!",TIME);
          break;
        case NotificationType.ERROR:
          NotificationManager.error(msg,"Error!",TIME);
          break;
      }
  };
}
 
export default NotificationCenter;