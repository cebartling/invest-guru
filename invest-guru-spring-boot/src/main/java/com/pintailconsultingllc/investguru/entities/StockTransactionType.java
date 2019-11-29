package com.pintailconsultingllc.investguru.entities;

public enum StockTransactionType {
    PURCHASE("PURCHASE"),
    SALE("SALE"),
    DIVIDEND("DIVIDEND");


    private final String code;

    private StockTransactionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
