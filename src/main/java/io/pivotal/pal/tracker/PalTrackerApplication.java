package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.dao.TimeEntryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean(name = "timeEntryRepository")
    public TimeEntryRepository timeEntryRepository(DataSource dataSource) {
        TimeEntryRepository timeEntryRepository = new io.pivotal.pal.tracker.JdbcTimeEntryRepository(dataSource);
        return timeEntryRepository;
    }

}