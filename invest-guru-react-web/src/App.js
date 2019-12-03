import React from 'react';
import './App.scss';
import {BrowserRouter as Router} from "react-router-dom";
import AppRouter from "./AppRouter";
import NavBar from "./components/NavBar";
import {useAuth0} from "./react-auth0-spa";
import Footer from "./components/Footer";

function App() {
    const {loading} = useAuth0();

    if (loading) {
        return <div>Loading...</div>;
    }

    return (
        <Router>
            <NavBar/>
            <main role="main" className="container-fluid top-margin">
                <AppRouter/>
            </main>
            <Footer/>
        </Router>
    );
}

export default App;
