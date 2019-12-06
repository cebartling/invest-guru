// export const ADD_TODO = 'ADD_TODO';
export const SIGN_IN = 'SIGN_IN';
export const SET_USER = 'SET_USER';
export const SET_TOKEN = 'SET_TOKEN';

// export function addToDo(title) {
//     return {
//         type: ADD_TODO,
//         toDoItem: {
//             _id: (new Date().getTime()).toString(),
//             title
//         }
//     };
// };

export const createSignInAction = () => {
    return {
        type: SIGN_IN
    };
}

export const createSetUserAction = (user) => {
    return {
        type: SET_USER,
        payload: user
    };
}

export const createSetTokenAction = (token) => {
    return {
        type: SET_TOKEN,
        payload: token
    };
}
