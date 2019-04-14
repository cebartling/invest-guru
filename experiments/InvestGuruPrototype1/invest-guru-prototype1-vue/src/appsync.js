import Vue from "vue";
import AWSAppSyncClient from "aws-appsync";
import VueApollo from "vue-apollo";

const config = {
  url: process.env.VUE_APP_AWS_APPSYNC_ENDPOINT,
  region: process.env.VUE_APP_AWS_APPSYNC_REGION,
  auth: {
    type: process.env.VUE_APP_AWS_APPSYNC_AUTH_TYPE,
    jwtToken: async () => {
      const currentSession = await Vue.prototype.$Amplify.Auth.currentSession();
      return currentSession.getAccessToken().getJwtToken();
    }
  }
};
const options = {
  defaultOptions: {
    watchQuery: {
      fetchPolicy: "cache-and-network"
    }
  }
};

const defaultClient = new AWSAppSyncClient(config, options);

const apolloProvider = new VueApollo({ defaultClient });

Vue.use(VueApollo);

export default apolloProvider;
