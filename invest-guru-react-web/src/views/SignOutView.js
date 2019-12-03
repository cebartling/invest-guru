import {useEffect} from "react";
import {useAuth0} from "../react-auth0-spa";
import {useHistory} from "react-router-dom";

const SignOutView = () => {
    const {logout} = useAuth0();
    const history = useHistory();


    useEffect(() => {
        console.info('Logging out');
        logout();
        history.push("/");
    });

    return null;
};

export default SignOutView;
