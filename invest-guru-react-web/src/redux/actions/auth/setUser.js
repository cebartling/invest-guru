export const SET_USER = 'SET_USER';

export const createActionSetUser = (user) => {
    return {
        type: SET_USER,
        payload: {user}
    };
};
