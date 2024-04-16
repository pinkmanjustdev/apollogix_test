package com.apollogix.exam.configuration.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "initialization")
@Configuration
@Data
public class InitializationProperties {
    @JsonProperty("email")
    private String email = "teacher@example.com";

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name = "Admin";

}
