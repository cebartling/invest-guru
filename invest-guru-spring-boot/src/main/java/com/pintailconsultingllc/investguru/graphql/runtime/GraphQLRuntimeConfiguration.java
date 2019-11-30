package com.pintailconsultingllc.investguru.graphql.runtime;

import com.pintailconsultingllc.investguru.graphql.datafetchers.UserDataFetchers;
import graphql.scalars.ExtendedScalars;
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
        registerScalars(builder);
        registerTypes(builder);
        return builder;
    }

    private void registerTypes(RuntimeWiring.Builder builder) {
        builder.type(buildQueryTypeWiring());
        builder.type(buildMutationTypeWiring());
        builder.type(buildUserTypeWiring());
    }

    private void registerScalars(RuntimeWiring.Builder builder) {
        builder.scalar(ExtendedScalars.DateTime);
        builder.scalar(ExtendedScalars.PositiveInt);
        builder.scalar(ExtendedScalars.Locale);
        builder.scalar(ExtendedScalars.Url);
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

    private TypeRuntimeWiring.Builder buildUserTypeWiring() {
        final var typeWiring = newTypeWiring("User");
        typeWiring.dataFetcher("stocks", userDataFetchers.getStocksDataFetcher());
        return typeWiring;
    }
}
