import React from "react";
import {useAuth0} from "../react-auth0-spa";
import {Link} from "react-router-dom";

const NavBar = () => {
    const {isAuthenticated} = useAuth0();

    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <Link to="/" className="navbar-brand">Invest Guru</Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"/>
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    {isAuthenticated && (
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <Link to="/dashboard" className="nav-link">Dashboard</Link>
                            </li>
                            <li className="nav-item">
                                <Link to="/profile" className="nav-link">Profile</Link>
                            </li>
                            <li className="nav-item">
                                <Link to="/signOut" className="nav-link">Sign out</Link>
                            </li>
                        </ul>
                    )}
                    {/*{!isAuthenticated && (*/}
                    {/*    <ul className="navbar-nav mr-auto">*/}
                    {/*        <li className="nav-item">*/}
                    {/*            <Link to="/signOut" className="nav-link">Sign out</Link>*/}
                    {/*        </li>*/}
                    {/*    </ul>*/}
                    {/*)}*/}
                </div>
            </nav>
        </header>
    );
};

export default NavBar;
