import React from 'react';
import {useQuery} from "@apollo/client";
import UserByEmailQuery from "../graphql/queries/UserByEmailQuery";
import {useSelector} from "react-redux";
import {userEmailSelector} from "../redux/selectors";

const DashboardView = () => {
    const email = useSelector(userEmailSelector);
    const {loading, error, data} = useQuery(UserByEmailQuery, {
        variables: { email }
    });

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error :(</p>;

    return (
        <div>
            <h1>Dashboard</h1>
            <code>{JSON.stringify(data, null, 2)}</code>
        </div>
    );
};

export default DashboardView;
