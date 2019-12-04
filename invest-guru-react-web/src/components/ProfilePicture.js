import React from "react";
import {useAuth0} from "../react-auth0-spa";
import './ProfilePicture.scss';

const ProfilePicture = () => {

    const { loading, user } = useAuth0();

    if (loading || !user) {
        return null;
    }

    return (
        <img className="profile-picture" src={user.picture} alt="Profile" />
    );
};

export default ProfilePicture;
