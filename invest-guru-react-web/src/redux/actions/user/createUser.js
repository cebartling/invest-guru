export const CREATE_USER = 'CREATE_USER';

export const createActionCreateUser = (user) => {
    return {
        type: CREATE_USER,
        payload: {user}
    };
};

