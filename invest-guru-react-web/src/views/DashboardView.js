import React from 'react';
import {useQuery} from "@apollo/client";
import UserByEmailQuery from "../graphql/queries/UserByEmailQuery";

const DashboardView = () => {
    const {loading, error, data} = useQuery(UserByEmailQuery, {
        variables: { email: 'maxwell.johnson@example.com' }
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
