import React from "react";
import {useAuth0} from "../react-auth0-spa";
import {CSSTransitionGroup} from "react-transition-group";
import './ProfilePicture.scss';

const ProfilePicture = () => {

    const {loading, user} = useAuth0();

    if (loading || !user) {
        return null;
    }

    return (
        <CSSTransitionGroup
            transitionName="view"
            transitionAppear={true}
            transitionAppearTimeout={1250}>
            <img className="profile-picture" src={user.picture} alt="Profile"/>
        </CSSTransitionGroup>
    );
};

export default ProfilePicture;
