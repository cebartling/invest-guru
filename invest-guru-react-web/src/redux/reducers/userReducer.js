import {SET_AUTHENTICATED, SET_TOKEN, SET_USER} from "../actions";


const initialState = {
    email: 'maxwell.johnson@example.com',
    token: null,
    isAuthenticated: false
};

const user = (state = initialState, action) => {
    switch (action.type) {
        case SET_USER:
            const {user} = action.payload;
            return Object.assign({}, state, {...user});
        case SET_TOKEN:
            const {token} = action.payload;
            return Object.assign({}, state, {token});
        case SET_AUTHENTICATED:
            const {isAuthenticated} = action.payload;
            return Object.assign({}, state, {isAuthenticated});
        default:
            return state;
    }
};

export default user;
