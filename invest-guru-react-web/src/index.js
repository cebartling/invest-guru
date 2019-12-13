import React from 'react';
import ReactDOM from 'react-dom';
import './custom.scss';
import './animations.scss';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {Auth0Provider} from "./react-auth0-spa";
import history from "./utils/history";
import {Provider} from 'react-redux';
import {ApolloProvider} from '@apollo/client';
import store from "./redux/store";
import client from "./graphql/apolloClient";


// A function that routes the user to the right place after login
const onRedirectCallback = appState => {
    history.push(
        appState && appState.targetUrl
            ? appState.targetUrl
            : window.location.pathname
    );
};

const WrappedApp = () => (
    <Auth0Provider
        domain={process.env.REACT_APP_AUTH0_DOMAIN}
        client_id={process.env.REACT_APP_AUTH0_CLIENT_ID}
        redirect_uri={window.location.origin}
        onRedirectCallback={onRedirectCallback}>
        <ApolloProvider client={client}>
            <Provider store={store}>
                <App/>
            </Provider>
        </ApolloProvider>
    </Auth0Provider>
);

ReactDOM.render(<WrappedApp/>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
