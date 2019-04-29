const fs = require('fs');

const slsinfo = fs.readFileSync('./.sls-info', 'utf8');

function getOutput(output) {
  return slsinfo.match(new RegExp('('+output+': )((.?)+)(\\n)'))[2];
}

const content = `
VUE_APP_AWS_REGION='${getOutput('AwsRegion')}'
VUE_APP_AWS_APPSYNC_REGION='${getOutput('AwsRegion')}'
VUE_APP_AWS_APPSYNC_AUTH_TYPE='AMAZON_COGNITO_USER_POOLS'
VUE_APP_AWS_APPSYNC_ENDPOINT='${getOutput('GraphQLApiEndpoint')}'
VUE_APP_USER_POOL_ID='${getOutput('UserPoolId')}'
VUE_APP_USER_POOL_CLIENT_ID='${getOutput('UserPoolClientId')}'
`;

fs.writeFileSync('./invest-guru-prototype1-vue/.env.production.local', content);
