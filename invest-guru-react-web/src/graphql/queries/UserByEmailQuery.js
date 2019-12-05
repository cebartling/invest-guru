import {gql} from '@apollo/client';

const UserByEmailQuery = gql`
    query UserByEmail($email: String!) {
        userByEmail(email: $email) {
            id
            givenName
            familyName
            createdAt
            updatedAt
            locale
            email
            stocks {
                id
                stock {
                    id
                    tickerSymbol
                    companyName
                }
                transactions {
                    id
                    sharesInvolvedInTransaction
                    transactionDateTime
                    perSharePriceInCents
                    stockTransactionType
                }
            }
        }
    }
`;

export default UserByEmailQuery;
