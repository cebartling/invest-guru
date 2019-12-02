package com.pintailconsultingllc.investguru.bootstrap;

import com.opencsv.CSVReaderHeaderAware;
import com.pintailconsultingllc.investguru.entities.Stock;
import com.pintailconsultingllc.investguru.entities.StockTransactionType;
import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.entities.UserStockTransaction;
import com.pintailconsultingllc.investguru.repositories.StockRepository;
import com.pintailconsultingllc.investguru.repositories.UserRepository;
import com.pintailconsultingllc.investguru.repositories.UserStockRepository;
import com.pintailconsultingllc.investguru.repositories.UserStockTransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class UserStockTransactionsDataSeed implements DataSeed {

    @Value("classpath:data/userStockTransactions.csv")
    Resource dataCsv;

    private final UserStockTransactionRepository userStockTransactionRepository;
    private final UserStockRepository userStockRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;
    private final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS[xxx][xx][X]";
    private final DateTimeFormatter formatter;

    @Autowired
    public UserStockTransactionsDataSeed(
            final UserStockTransactionRepository userStockTransactionRepository,
            final UserStockRepository userStockRepository,
            final UserRepository userRepository,
            final StockRepository stockRepository) {
        this.userStockTransactionRepository = userStockTransactionRepository;
        this.userStockRepository = userStockRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
        formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public void seed(DataSeedContext context) {
        log.info("====> START: User/stock transactions data seeding");
        try {
            CSVReaderHeaderAware csvReaderHeaderAware = new CSVReaderHeaderAware(new FileReader(dataCsv.getFile()));
            var values = csvReaderHeaderAware.readMap();
            while (values != null) {
                final String email = values.get("email");
                final String tickerSymbol = values.get("tickerSymbol");
                final User user = userRepository.findByEmail(email);
                final Stock stock = stockRepository.findByTickerSymbol(tickerSymbol);
                final var userStock = userStockRepository.findByUserAndStock(user, stock);
                if (userStock != null) {
                    final var transactionTimestamp = OffsetDateTime.parse(values.get("transactionDateTime"), formatter);
                    final var transactions = userStockTransactionRepository.findByUserStockAndTransactionDateTime(
                            userStock, transactionTimestamp);
                    if (transactions.size() == 0) {
                        UserStockTransaction transaction = new UserStockTransaction();
                        transaction.setUserStock(userStock);
                        transaction.setPerSharePriceInCents(Integer.parseInt(values.get("perSharePriceInCents")));
                        transaction.setSharesInvolvedInTransaction(Integer.parseInt(values.get("sharesInvolvedInTransaction")));
                        transaction.setTransactionDateTime(transactionTimestamp);
                        final var stockTransactionType = StockTransactionType.valueOf(values.get("stockTransactionType"));
                        transaction.setStockTransactionType(stockTransactionType);
                        transaction.setCreatedAt(OffsetDateTime.now());
                        transaction.setUpdatedAt(OffsetDateTime.now());
                        userStockTransactionRepository.save(transaction);
                    }
                }
                values = csvReaderHeaderAware.readMap();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("====> END: User/stock transactions data seeding");
    }
}
