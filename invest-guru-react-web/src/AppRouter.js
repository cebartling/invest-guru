import React from 'react';
import {Route, Switch} from "react-router-dom";
import FrontDoorView from "./views/FrontDoorView";
import DashboardView from "./views/DashboardView";

const AppRouter = () => {
    return (
        <Switch>
            <Route path="/dashboard">
                <DashboardView/>
            </Route>
            <Route path="/">
                <FrontDoorView/>
            </Route>
        </Switch>
    );
};

export default AppRouter;
