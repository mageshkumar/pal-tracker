package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.dao.InMemoryTimeEntryRepository;
import io.pivotal.pal.tracker.dao.TimeEntryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean(name = "timeEntryRepository")
    public TimeEntryRepository timeEntryRepository() {
        TimeEntryRepository timeEntryRepository = new InMemoryTimeEntryRepository();
        return timeEntryRepository;
    }
}