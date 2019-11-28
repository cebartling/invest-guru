package com.pintailconsultingllc.investguru.repositories;

import com.pintailconsultingllc.investguru.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    /**
     * Retrieve a list of user accounts tied to an email address.
     *
     * @param email A String representing the email filter to use.
     * @return A List of User objects, all of which match the email filter passed in.
     */
    List<User> findByEmail(String email);
}
