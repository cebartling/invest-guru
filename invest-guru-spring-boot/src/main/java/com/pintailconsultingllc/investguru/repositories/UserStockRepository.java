package com.pintailconsultingllc.investguru.repositories;

import com.pintailconsultingllc.investguru.entities.Stock;
import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.entities.UserStock;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserStockRepository extends CrudRepository<UserStock, UUID> {

    UserStock findByUserAndStock(User user, Stock stock);
}
