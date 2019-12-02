import React from "react";
import {useAuth0} from "../react-auth0-spa";
import {Link} from "react-router-dom";

const NavBar = () => {
    const {isAuthenticated, loginWithRedirect, logout} = useAuth0();

    return (
        <ul>
            {!isAuthenticated && (
                <li>
                    <button onClick={() => loginWithRedirect({})}>Log in</button>
                </li>
            )}
            {isAuthenticated && (
                <>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/dashboard">Dashboard</Link>
                    </li>
                    <li>
                        <Link to="/profile">Profile</Link>
                    </li>
                    <li>
                        <button onClick={() => logout()}>Log out</button>
                    </li>
                </>
            )}
        </ul>
    );
};

export default NavBar;