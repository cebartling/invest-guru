package com.pintailconsultingllc.investguru.bootstrap;

import com.opencsv.CSVReaderHeaderAware;
import com.pintailconsultingllc.investguru.entities.Stock;
import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.entities.UserStock;
import com.pintailconsultingllc.investguru.repositories.StockRepository;
import com.pintailconsultingllc.investguru.repositories.UserRepository;
import com.pintailconsultingllc.investguru.repositories.UserStockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.time.OffsetDateTime;

@Component
@Slf4j
public class UserStocksDataSeed implements DataSeed {

    @Value("classpath:data/userStocks.csv")
    Resource dataCsv;

    private final UserStockRepository userStockRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;

    @Autowired
    public UserStocksDataSeed(
            UserStockRepository userStockRepository,
            UserRepository userRepository,
            StockRepository stockRepository
    ) {
        this.userStockRepository = userStockRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void seed(DataSeedContext context) {
        log.info("====> START: User/stocks association data seeding");
        try {
            CSVReaderHeaderAware csvReaderHeaderAware = new CSVReaderHeaderAware(new FileReader(dataCsv.getFile()));
            var values = csvReaderHeaderAware.readMap();
            while (values != null) {
                final String email = values.get("email");
                final String tickerSymbol = values.get("tickerSymbol");
                final User user = userRepository.findByEmail(email);
                final Stock stock = stockRepository.findByTickerSymbol(tickerSymbol);
                final var found = userStockRepository.findByUserAndStock(user, stock);
                if (found == null) {
                    final UserStock userStock = new UserStock();
                    userStock.setUser(user);
                    userStock.setStock(stock);
                    userStock.setCreatedAt(OffsetDateTime.now());
                    userStock.setUpdatedAt(OffsetDateTime.now());
                    userStockRepository.save(userStock);
                }
                values = csvReaderHeaderAware.readMap();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("====> END: User/stocks data seeding");
    }
}
