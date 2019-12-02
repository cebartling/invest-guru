package com.pintailconsultingllc.investguru.bootstrap;

import com.opencsv.CSVReaderHeaderAware;
import com.pintailconsultingllc.investguru.entities.User;
import com.pintailconsultingllc.investguru.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.time.OffsetDateTime;

@Component
@Slf4j
public class UsersDataSeed implements DataSeed {

    @Value("classpath:data/users.csv")
    Resource usersCsv;

    private final UserRepository userRepository;

    @Autowired
    public UsersDataSeed(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void seed(DataSeedContext context) {
        log.info("====> START: Users data seeding");
        try {
            CSVReaderHeaderAware csvReaderHeaderAware = new CSVReaderHeaderAware(new FileReader(usersCsv.getFile()));
            var values = csvReaderHeaderAware.readMap();
            while (values != null) {
                final var found = userRepository.findByEmail(values.get("email"));
                if (found == null) {
                    final var user = new User();
                    user.setEmail(values.get("email"));
                    user.setFamilyName(values.get("familyName"));
                    user.setGivenName(values.get("givenName"));
                    user.setLocale(values.get("locale"));
                    user.setCreatedAt(OffsetDateTime.now());
                    user.setUpdatedAt(OffsetDateTime.now());
                    userRepository.save(user);
                    log.info(String.format("Inserted user: %s", user));
                }
                values = csvReaderHeaderAware.readMap();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("====> END: Users data seeding");
    }
}
