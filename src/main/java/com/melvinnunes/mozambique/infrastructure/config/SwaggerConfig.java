package com.melvinnunes.mozambique.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
                .title("Mozambique Regional Info API Documentation")
                .description("API Documentation for Mozambique Regional Information")
                .version("1.0.0"))
                .addServersItem(new Server().url("http://localhost:8080").description("Local Development Server")) // this needs refactor to .env
                .addServersItem(new Server().url("https://moz-api-945722244201.africa-south1.run.app").description("Production Server"));
    }

    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("http")
                .pathsToMatch("/**")
                .build();
    }
}
