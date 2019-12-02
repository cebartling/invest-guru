import React from 'react';
import './App.css';
import {BrowserRouter as Router} from "react-router-dom";
import AppRouter from "./AppRouter";
import NavBar from "./components/NavBar";
import { useAuth0 } from "./react-auth0-spa";

function App() {
  const { loading } = useAuth0();

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
      <Router>
        <div className="flex flex-col w-3/4 mx-auto my-12 items-center">
          <nav>
            <header>
              <NavBar />
            </header>
          </nav>

          <AppRouter/>
        </div>
      </Router>
  );
}

export default App;
