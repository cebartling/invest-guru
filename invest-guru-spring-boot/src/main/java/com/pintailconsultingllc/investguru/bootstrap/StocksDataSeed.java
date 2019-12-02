package com.pintailconsultingllc.investguru.bootstrap;

import com.opencsv.CSVReaderHeaderAware;
import com.pintailconsultingllc.investguru.entities.Stock;
import com.pintailconsultingllc.investguru.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.time.OffsetDateTime;

@Component
@Slf4j
public class StocksDataSeed implements DataSeed {

    @Value("classpath:data/stocks.csv")
    Resource stocksCsv;

    private final StockRepository stockRepository;

    @Autowired
    public StocksDataSeed(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void seed(DataSeedContext context) {
        log.info("====> START: Stocks data seeding");
        try {
            CSVReaderHeaderAware csvReaderHeaderAware = new CSVReaderHeaderAware(new FileReader(stocksCsv.getFile()));
            var values = csvReaderHeaderAware.readMap();
            while (values != null) {
                final var found = stockRepository.findByTickerSymbol(values.get("tickerSymbol"));
                if (found == null) {
                    final var stock = new Stock();
                    stock.setTickerSymbol(values.get("tickerSymbol"));
                    stock.setCompanyName(values.get("companyName"));
                    stock.setCreatedAt(OffsetDateTime.now());
                    stock.setUpdatedAt(OffsetDateTime.now());
                    stockRepository.save(stock);
                    log.info(String.format("Inserted stock: %s", stock));
                }
                values = csvReaderHeaderAware.readMap();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("====> END: Stocks data seeding");
    }
}
