import gql from "graphql-tag";

const simpleMovingAverageAnalyticQuery = gql`
  query SimpleMovingAverageAnalyticQuery($symbol: String!) {
    simpleMovingAverageAnalytic(symbol: $symbol) {
      company {
        name
        symbol
      }
      averages50 {
        date
        value
      }
      averages300 {
        date
        value
      }
    }
  }
`;

export default simpleMovingAverageAnalyticQuery;
