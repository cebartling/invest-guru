package com.pintailconsultingllc.investguru.repositories;

import com.pintailconsultingllc.investguru.entities.UserStock;
import com.pintailconsultingllc.investguru.entities.UserStockTransaction;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface UserStockTransactionRepository extends CrudRepository<UserStockTransaction, UUID>  {

    List<UserStockTransaction> findByUserStockAndTransactionDateTime(UserStock userStock, LocalDateTime transactionTimestamp);
}
