import {SET_TOKEN, createActionSetToken} from "./auth/setToken";
import {SET_USER, createActionSetUser} from "./auth/setUser";
import {SIGN_IN, createActionSignIn} from "./auth/signIn";
import {SIGN_OUT, createActionSignOut} from "./auth/signOut";
import {SET_AUTHENTICATED, createActionSetAuthenticated} from "./auth/setAuthenticated";
import {CREATE_USER, createActionCreateUser} from "./user/createUser";

export {
    SET_AUTHENTICATED,
    SET_TOKEN,
    SET_USER,
    SIGN_IN,
    SIGN_OUT,
    CREATE_USER,
};

export {
    createActionSetAuthenticated,
    createActionSetToken,
    createActionSetUser,
    createActionSignIn,
    createActionSignOut,
    createActionCreateUser,
};
