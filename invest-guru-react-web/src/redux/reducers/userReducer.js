import {SET_TOKEN, SET_USER} from "../actions";


const initialState = {
    email: 'maxwell.johnson@example.com',
    token: null
};

const user = (state = initialState, action) => {
    switch (action.type) {
        case SET_USER:
            const {user} = action.payload;
            return Object.assign({}, state, {
                user: {...user}
            });
        case SET_TOKEN:
            const {token} = action.payload;
            return Object.assign({}, state, {token});
        default:
            return state
    }
};

export default user;
