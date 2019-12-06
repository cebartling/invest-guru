// import {all, call, put, takeEvery} from 'redux-saga/effects';
// import {LOAD_TODO_LIST, RENDER_TODO_LIST} from '../actions';
// import {createSetTokenAction, createSetUserAction, SIGN_IN} from "../actions";

// export function* fetchToDoList() {
//     const endpoint = 'https://gist.githubusercontent.com/brunokrebs/f1cacbacd53be83940e1e85860b6c65b/raw/to-do-items.json';
//     const response = yield call(fetch, endpoint);
//     const data = yield response.json();
//     yield put({type: RENDER_TODO_LIST, toDoList: data});
// }
//
// export function* loadToDoList() {
//     yield takeEvery(LOAD_TODO_LIST, fetchToDoList);
// }
//
// const delay = (ms) => new Promise(res => setTimeout(res, ms));
//
// // ...
//
// // Our worker Saga: will perform the async increment task
// export function* incrementAsync() {
//     yield delay(1000);
//     yield put({type: 'INCREMENT'});
// }
//
// // Our watcher Saga: spawn a new incrementAsync task on each INCREMENT_ASYNC
// export function* watchIncrementAsync() {
//     yield takeEvery('INCREMENT_ASYNC', incrementAsync);
// }
//
//
// export function* helloSaga() {
//     console.log('Hello Sagas!')
// }


// export function* signIn() {
//     yield put(createSetUserAction(user));
//     yield put(createSetTokenAction(token));
// }
//
// export function* watchSignInAsync() {
//     yield takeEvery(SIGN_IN, signIn);
// }


// export default function* rootSaga() {
//     yield all([
//         helloSaga(),
//         loadToDoList(),
//         watchIncrementAsync()
        // watchSignInAsync()
    // ]);
// }