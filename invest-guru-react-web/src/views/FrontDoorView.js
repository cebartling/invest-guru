import React from 'react';
import {useAuth0} from "../react-auth0-spa";

const FrontDoorView = () => {
    const {loginWithRedirect} = useAuth0();

    return (
        <div>
            <button onClick={() => loginWithRedirect({})} className="btn btn-lg btn-primary">Sign in</button>
        </div>
    );
};

export default FrontDoorView;
