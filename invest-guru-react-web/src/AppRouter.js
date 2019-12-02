import React from 'react';
import {Route, Switch} from "react-router-dom";
import FrontDoorView from "./views/FrontDoorView";
import DashboardView from "./views/DashboardView";
import {CSSTransitionGroup} from "react-transition-group";
import {useLocation} from "react-router";
import ProfileView from "./views/ProfileView";

const AppRouter = () => {
    const location = useLocation();

    return (
        <CSSTransitionGroup
            transitionName="view"
            transitionAppear={false}
            transitionEnter={true}
            transitionLeave={false}
            transitionAppearTimeout={500}
            transitionEnterTimeout={500}
            transitionLeaveTimeout={300}
        >
            <Switch key={location.key} location={location}>
                <Route path="/dashboard">
                    <DashboardView/>
                </Route>
                <Route path="/profile">
                    <ProfileView/>
                </Route>
                <Route path="/">
                    <FrontDoorView/>
                </Route>
            </Switch>
        </CSSTransitionGroup>
    );
};

export default AppRouter;
