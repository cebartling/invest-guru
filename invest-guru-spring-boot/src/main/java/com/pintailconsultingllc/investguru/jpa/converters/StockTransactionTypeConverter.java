package com.pintailconsultingllc.investguru.jpa.converters;

import com.pintailconsultingllc.investguru.entities.StockTransactionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;


@Converter(autoApply = true)
public class StockTransactionTypeConverter implements AttributeConverter<StockTransactionType, String> {

    @Override
    public String convertToDatabaseColumn(StockTransactionType stockTransactionType) {
        if (stockTransactionType == null) {
            return null;
        }
        return stockTransactionType.getCode();
    }

    @Override
    public StockTransactionType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(StockTransactionType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}