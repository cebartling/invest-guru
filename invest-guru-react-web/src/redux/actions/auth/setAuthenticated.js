export const SET_AUTHENTICATED = 'SET_AUTHENTICATED';

export const createActionSetAuthenticated = (isAuthenticated) => {
    return {
        type: SET_AUTHENTICATED,
        payload: {isAuthenticated}
    };
};
