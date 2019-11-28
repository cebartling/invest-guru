package com.pintailconsultingllc.investguru.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataSeedApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final UsersDataSeed usersDataSeed;
    private final StocksDataSeed stocksDataSeed;
    private final UserStocksDataSeed userStocksDataSeed;


    @Autowired
    public DataSeedApplicationListener(UsersDataSeed usersDataSeed, StocksDataSeed stocksDataSeed, UserStocksDataSeed userStocksDataSeed) {
        this.usersDataSeed = usersDataSeed;
        this.stocksDataSeed = stocksDataSeed;
        this.userStocksDataSeed = userStocksDataSeed;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("===> START: Data seeding");
        final var context = new DataSeedContext();
        usersDataSeed.seed(context);
        stocksDataSeed.seed(context);
        userStocksDataSeed.seed(context);
        log.info("===> END: Data seeding");
    }
}
