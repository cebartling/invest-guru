import React from "react";
import {useAuth0} from "../react-auth0-spa";
import {Link} from "react-router-dom";

const NavBar = () => {
    const {isAuthenticated, loginWithRedirect, logout} = useAuth0();

    return (
        <ul className="">
            {!isAuthenticated && (
                <li className="">
                    <a className="" onClick={() => loginWithRedirect({})}>Log in</a>
                </li>
            )}
            {isAuthenticated && (
                <>
                    <li className="">
                        <Link to="/" className="">Home</Link>
                    </li>
                    <li className="">
                        <Link to="/dashboard" className="">Dashboard</Link>
                    </li>
                    <li className="">
                        <Link to="/profile" className="">Profile</Link>
                    </li>
                    <li className="">
                        <a onClick={() => logout()} className="">Log out</a>
                    </li>
                </>
            )}
        </ul>
    );
};

export default NavBar;