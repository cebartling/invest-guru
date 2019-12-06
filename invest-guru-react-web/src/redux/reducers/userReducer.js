// import {SET_TOKEN, SET_USER} from "../actions";


const initialState = {
    email: 'maxwell.johnson@example.com'
};

const user = (state = initialState, action) => {
    switch (action.type) {
//         case SET_USER:
//             const {user} = action.payload;
//             return Object.assign({}, state, {
//                 user: Object.assign({}, user)
//             });
//         case SET_TOKEN:
//             const {token} = action.payload;
//             return Object.assign({}, state, {token});
//         // case TOGGLE_TODO:
//         //     return Object.assign({}, state, {
//         //         todos: state.todos.map((todo, index) => {
//         //             if (index === action.index) {
//         //                 return Object.assign({}, todo, {
//         //                     completed: !todo.completed
//         //                 })
//         //             }
//         //             return todo
//         //         })
//         //     })
        default:
            return state
    }
};

export default user;
