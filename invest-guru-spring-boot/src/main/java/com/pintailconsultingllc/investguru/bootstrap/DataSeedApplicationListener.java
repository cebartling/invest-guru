package com.pintailconsultingllc.investguru.bootstrap;

import com.pintailconsultingllc.investguru.entities.Stock;
import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.entities.UserStock;
import com.pintailconsultingllc.investguru.repositories.StockRepository;
import com.pintailconsultingllc.investguru.repositories.UserRepository;
import com.pintailconsultingllc.investguru.repositories.UserStockRepository;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
class DataSeedApplicationListenerContext {
    private final List<User> newUsers = new ArrayList<>();
    private final List<Stock> newStocks = new ArrayList<>();
    private final List<UserStock> newUserStocks = new ArrayList<>();
}

@Component
@Slf4j
public class DataSeedApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final StockRepository stockRepository;
    private final UserStockRepository userStockRepository;

    public DataSeedApplicationListener(final UserRepository userRepository,
                                       final StockRepository stockRepository,
                                       final UserStockRepository userStockRepository) {
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
        this.userStockRepository = userStockRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("===> START: Data seeding");
        final var context = DataSeedApplicationListenerContext.builder().build();
        createUsers(context);
        createStocks(context);
        createUserStocks(context);
        log.info("===> END: Data seeding");
    }

    private void createUserStocks(DataSeedApplicationListenerContext context) {

    }

    private void createStocks(DataSeedApplicationListenerContext context) {

    }

    private void createUsers(DataSeedApplicationListenerContext context) {
        final var email = "joe.shmoe@example.com";
        final var found = userRepository.findByEmail(email);
        if (found.size() == 0) {
            final var user = new User();
            user.setEmail(email);
            user.setFamilyName("Shmoe");
            user.setGivenName("Joe");
            user.setLocale("us-en");
            context.getNewUsers().add(userRepository.save(user));
        }
    }
}
