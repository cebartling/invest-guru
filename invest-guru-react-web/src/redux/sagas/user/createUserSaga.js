import {put, takeEvery} from 'redux-saga/effects';
import {CREATE_USER} from "../../actions";

function* createUserAsync(action) {
    console.log(JSON.stringify(action));
}

export function* watchCreateUserAsync() {
    yield takeEvery(CREATE_USER, createUserAsync);
}
