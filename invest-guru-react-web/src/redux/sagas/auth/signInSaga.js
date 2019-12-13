import {put, takeEvery} from 'redux-saga/effects';
import {createActionSetAuthenticated, createActionSetToken, createActionSetUser, SIGN_IN} from "../../actions";
import {getAuth0Client} from "../../../react-auth0-spa";

function* signInAsync(action) {
    const auth0Client = yield getAuth0Client();
    yield auth0Client.loginWithPopup({display: 'page'});
    yield put(createActionSetAuthenticated(yield auth0Client.isAuthenticated()));
    yield put(createActionSetUser(yield auth0Client.getUser()));
    yield put(createActionSetToken(yield auth0Client.getTokenSilently({})));
    // TODO: Create the user in the backend.
}

export function* watchSignInAsync() {
    yield takeEvery(SIGN_IN, signInAsync);
}
