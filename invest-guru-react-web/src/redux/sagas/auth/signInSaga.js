import {put, takeEvery} from 'redux-saga/effects';
import {createActionSetAuthenticated, createActionSetToken, createActionSetUser, SIGN_IN} from "../../actions";
import {getAuth0Client} from "../../../react-auth0-spa";

function* signInAsync() {
    console.info("Running signInAsync!");
    const auth0Client = yield getAuth0Client();
    yield auth0Client.loginWithPopup({});
    const user = yield auth0Client.getUser();
    const token = yield auth0Client.getTokenSilently({});
    const isAuthenticated = yield auth0Client.isAuthenticated();

    yield put(createActionSetAuthenticated(isAuthenticated));
    yield put(createActionSetUser(user));
    yield put(createActionSetToken(token));
}

export function* watchSignInAsync() {
    yield takeEvery(SIGN_IN, signInAsync);
}
