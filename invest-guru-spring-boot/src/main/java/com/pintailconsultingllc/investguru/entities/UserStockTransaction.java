package com.pintailconsultingllc.investguru.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_stock_transactions")
public class UserStockTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_stock_id")
    @NotNull
    private UserStock userStock;

    @NotNull
    private Integer sharesInvolvedInTransaction;

    @NotNull
    private LocalDateTime transactionDateTime;

    @NotNull
    private Integer perSharePriceInCents;

    @NotNull
    private StockTransactionType stockTransactionType;
}
