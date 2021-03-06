package com.pintailconsultingllc.investguru.repositories;

import com.pintailconsultingllc.investguru.entities.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StockRepository extends CrudRepository<Stock, UUID> {

    /**
     * Retrieve a list of user accounts tied to an email address.
     *
     * @param tickerSymbol A String representing the ticker symbol filter to use.
     * @return A Stock object which matches the ticker symbol filter passed in.
     */
    Stock findByTickerSymbol(String tickerSymbol);
}
