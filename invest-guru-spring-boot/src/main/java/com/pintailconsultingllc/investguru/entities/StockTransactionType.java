package com.pintailconsultingllc.investguru.entities;

public enum StockTransactionType {
    PURCHASE("purchase"),
    SALE("sale"),
    DIVIDEND("dividend");


    private final String code;

    private StockTransactionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
