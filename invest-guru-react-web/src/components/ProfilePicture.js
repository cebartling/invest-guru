import React from "react";
import {CSSTransitionGroup} from "react-transition-group";
import './ProfilePicture.scss';
import {useSelector} from "react-redux";
import {isAuthenticatedSelector, userSelector} from "../redux/selectors";

const ProfilePicture = () => {
    const isAuthenticated = useSelector(isAuthenticatedSelector);
    const user = useSelector(userSelector);

    if (!isAuthenticated) {
        return null;
    }

    return (
        <CSSTransitionGroup
            transitionName="view"
            transitionAppear={true}
            transitionAppearTimeout={1250}
            transitionEnter={true}
            transitionEnterTimeout={0}
            transitionLeave={false}
            transitionLeaveTimeout={0}>
            <img className="profile-picture" src={user.picture} alt="Profile"/>
        </CSSTransitionGroup>
    );
};

export default ProfilePicture;
