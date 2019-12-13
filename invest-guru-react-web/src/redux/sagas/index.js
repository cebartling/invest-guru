import {all} from 'redux-saga/effects';
import {watchSignInAsync} from "./auth/signInSaga";
import {watchSignOutAsync} from "./auth/signOutSaga";
import {watchCreateUserAsync} from "./user/createUserSaga";

export default function* rootSaga() {
    yield all([
        watchSignInAsync(),
        watchSignOutAsync(),
        watchCreateUserAsync(),
    ]);
}
