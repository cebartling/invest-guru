package com.pintailconsultingllc.investguru.graphql.datafetchers;

import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.graphql.inputs.UserInput;
import com.pintailconsultingllc.investguru.repositories.UserRepository;
import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            User user = null;
            final var usersByEmail = userRepository.findByEmail(email);
            if (usersByEmail.size() != 0) {
                user = usersByEmail.get(0);
            }
            return user;
        };
    }

    public DataFetcher getCreateUserDataFetcher() {
        return environment -> {
            final var arguments = environment.getArguments();
            final var inputMap = (Map<String, Object>) arguments.get("userInput");
            final var userInput = UserInput.fromMap(inputMap);

            final var usersByEmail = userRepository.findByEmail(userInput.getEmail());
            if (usersByEmail.size() == 0) {
                final var unpersisted = new User();
                unpersisted.setEmail(userInput.getEmail());
                unpersisted.setFamilyName(userInput.getFamilyName());
                unpersisted.setGivenName(userInput.getGivenName());
                unpersisted.setLocale(userInput.getLocale());
                return this.userRepository.save(unpersisted);
            } else {
                return usersByEmail.get(0);
            }
        };
    }
}
