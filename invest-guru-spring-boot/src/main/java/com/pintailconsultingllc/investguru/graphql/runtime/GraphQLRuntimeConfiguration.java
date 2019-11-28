package com.pintailconsultingllc.investguru.graphql.runtime;

import com.pintailconsultingllc.investguru.graphql.datafetchers.UserDataFetchers;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class GraphQLRuntimeConfiguration {

    private final UserDataFetchers userDataFetchers;

    @Autowired
    public GraphQLRuntimeConfiguration(UserDataFetchers userDataFetchers) {
        this.userDataFetchers = userDataFetchers;
    }

    @Bean
    public RuntimeWiring.Builder runtimeWiringBuilder() {
        final var builder = RuntimeWiring.newRuntimeWiring();
        builder.type(buildQueryTypeWiring());
        builder.type(buildMutationTypeWiring());
//        builder.type(buildUserAccountTypeWiring());
        return builder;
    }

    private TypeRuntimeWiring.Builder buildMutationTypeWiring() {
        final var builder = newTypeWiring("Mutation");
        builder.dataFetcher("createUser", userDataFetchers.getCreateUserDataFetcher());
        return builder;
    }

    private TypeRuntimeWiring.Builder buildQueryTypeWiring() {
        final var builder = newTypeWiring("Query");
        builder.dataFetcher("userByEmail", userDataFetchers.getUserByEmailDataFetcher());
        return builder;
    }

//    private TypeRuntimeWiring.Builder buildUserAccountTypeWiring() {
//        final var typeWiring = newTypeWiring("UserAccount");
//        typeWiring.dataFetcher("permissions", userAccountDataFetchers.getPermissionsDataFetcher());
//        newTypeWiring("Book")
//                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher())
//        return typeWiring;
//    }
}
