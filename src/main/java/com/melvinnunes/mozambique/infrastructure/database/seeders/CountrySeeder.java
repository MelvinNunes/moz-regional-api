package com.melvinnunes.mozambique.infrastructure.database.seeders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class CountrySeeder implements CommandLineRunner  {
    private final JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(CountrySeeder.class);

    public CountrySeeder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void run(String... args) {
        try {
            logger.info("Seeding country data info!");

            // Load SQL file from resources
            ClassPathResource resource = new ClassPathResource("static/country_data.sql");
            String sqlScript = FileCopyUtils.copyToString(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)
            );

            // Split the SQL script into individual statements
            String[] statements = sqlScript.split(";");

            // Execute each statement
            for (String statement : statements) {
                if (!statement.trim().isEmpty()) {
                    jdbcTemplate.execute(statement);
                }
            }

            logger.info("Country data seeded successfully!");

        } catch (Exception e) {
            logger.error("Error seeding country data: {}", e.getMessage());
        }
    }
}
