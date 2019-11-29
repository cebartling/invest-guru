package com.pintailconsultingllc.investguru.repositories;

import com.pintailconsultingllc.investguru.entities.UserStockTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserStockTransactionRepository extends CrudRepository<UserStockTransaction, UUID>  {
}
