package com.pintailconsultingllc.investguru.graphql.datafetchers;

import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.graphql.inputs.UserInput;
import com.pintailconsultingllc.investguru.repositories.UserRepository;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Map;

@Component
@Slf4j
public class UserDataFetchers {

    private final UserRepository userRepository;

    @Autowired
    public UserDataFetchers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DataFetcher getUserByEmailDataFetcher() {
        return environment -> {
            final var arguments = environment.getArguments();
            final String email = arguments.get("email").toString();
            User user = userRepository.findByEmail(email);
            return user;
        };
    }

    public DataFetcher getCreateUserDataFetcher() {
        return environment -> {
            final var arguments = environment.getArguments();
            final var inputMap = (Map<String, Object>) arguments.get("userInput");
            final var userInput = UserInput.fromMap(inputMap);
            log.info(String.format("====> userInput: %s", userInput));

            final var user = userRepository.findByEmail(userInput.getEmail());
            if (user == null) {
                final var unpersisted = new User();
                unpersisted.setEmail(userInput.getEmail());
                unpersisted.setFamilyName(userInput.getFamilyName());
                unpersisted.setGivenName(userInput.getGivenName());
                unpersisted.setLocale(userInput.getLocale());
                unpersisted.setCreatedAt(OffsetDateTime.now());
                unpersisted.setUpdatedAt(OffsetDateTime.now());
                return this.userRepository.save(unpersisted);
            } else {
                return user;
            }
        };
    }

    public DataFetcher getStocksDataFetcher() {
        return environment -> {
            final var user = (User) environment.getSource();
            return user.getStocks();
        };
    }
}
