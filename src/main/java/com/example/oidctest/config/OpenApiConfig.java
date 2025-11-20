package com.example.oidctest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI oidcTestOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OIDC Test Client API")
                        .description("Simple OIDC client application for testing authentication flows")
                        .version("0.0.1")
                        .contact(new Contact()
                                .name("API Support")
                                .email("support@example.com")))
                .servers(List.of(
                        new Server().url("https://localhost:8082").description("Direct HTTPS Server"),
                        new Server().url("https://localhost/oidc-test").description("Via HAProxy")));
    }
}
