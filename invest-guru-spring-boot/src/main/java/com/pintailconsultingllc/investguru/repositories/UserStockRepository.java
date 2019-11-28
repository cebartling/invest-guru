package com.pintailconsultingllc.investguru.repositories;

import com.pintailconsultingllc.investguru.entities.Stock;
import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.entities.UserStock;
import org.springframework.data.repository.CrudRepository;

public interface UserStockRepository extends CrudRepository<UserStock, String> {

    UserStock findByUserAndStock(User user, Stock stock);
}
