import {all} from 'redux-saga/effects';
import {watchSignInAsync} from "./auth/signInSaga";
import {watchSignOutAsync} from "./auth/signOutSaga";

export default function* rootSaga() {
    yield all([
        watchSignInAsync(),
        watchSignOutAsync()
    ]);
}
