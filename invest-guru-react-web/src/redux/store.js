import createSagaMiddleware from "redux-saga";
import {applyMiddleware, compose, createStore} from "redux";
import rootReducer from "./reducers";
import rootSaga from "./sagas";

const sagaMiddleware = createSagaMiddleware();
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const store = createStore(
    rootReducer,
    composeEnhancers(applyMiddleware(sagaMiddleware))
);
sagaMiddleware.run(rootSaga);

// TODO: Kick off any Redux actions that need to run before the web application is loaded.
//store.dispatch(loadToDoList());

export default store;
