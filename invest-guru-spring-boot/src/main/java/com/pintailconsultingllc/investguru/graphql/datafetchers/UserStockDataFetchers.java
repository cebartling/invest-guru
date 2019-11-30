package com.pintailconsultingllc.investguru.graphql.datafetchers;

import com.pintailconsultingllc.investguru.entities.UserStock;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserStockDataFetchers {

    public DataFetcher getTransactionsDataFetcher() {
        return environment -> {
            final var userStock = (UserStock) environment.getSource();
            return userStock.getTransactions();
        };
    }
}
