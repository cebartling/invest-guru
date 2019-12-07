export const SET_TOKEN = 'SET_TOKEN';

export const createActionSetToken = (token) => {
    return {
        type: SET_TOKEN,
        payload: {token}
    };
};
