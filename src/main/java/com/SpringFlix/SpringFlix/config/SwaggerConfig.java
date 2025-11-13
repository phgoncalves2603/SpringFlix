package com.SpringFlix.SpringFlix.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI(){
        Contact contact = new Contact();
        contact.name("Pedro");


        Info info = new Info();
        info.title("SpringFlix");
        info.version("V1");
        info.description("App to manage movie catalog");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
