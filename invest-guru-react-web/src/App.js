import React from 'react';
import './App.css';
import {BrowserRouter as Router, Link} from "react-router-dom";
import AppRouter from "./AppRouter";

function App() {
  return (
      <Router>
        <div>
          <nav>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/dashboard">Dashboard</Link>
              </li>
            </ul>
          </nav>

          <AppRouter/>
        </div>
      </Router>
  );
}

export default App;
