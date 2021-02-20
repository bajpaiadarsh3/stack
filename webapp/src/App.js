import logo from './logo.svg';
import 'react-notifications/lib/notifications.css';

import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import {GetComponent} from './components/getComponent';
import {Home} from './components/home';
import {PushComponent} from './components/pushComponent';
import {PopComponent} from './components/popComponent';

function App() {
  return (
    <div className="App">
      <Router>
        <div class="main">
        <Switch>
          <Route exact={true} path="/"><Home></Home></Route>
          <Route exact={true} path="/get">
            <GetComponent />
          </Route>
          <Route exact={true} path="/push">
            <PushComponent />
          </Route>
          <Route exact={true} path="/pop">
            <PopComponent />
          </Route>
        </Switch>
        </div>
      </Router>
      
    </div>
  );
}

export default App;
