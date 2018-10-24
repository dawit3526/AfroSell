package com.eri.afrosell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/*
 * This is the main Spring Boot application class. It configures Spring Boot, JPA, Swagger
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class )  // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.eri.afrosell")
@EnableSwagger2
public class AfrosellPortal extends SpringBootServletInitializer {

    private static final Class<AfrosellPortal> APPLICATION_NAME = AfrosellPortal.class;
    private final Logger logger = LoggerFactory.getLogger(APPLICATION_NAME);

    public static void main(String[] args) {
        SpringApplication.run(APPLICATION_NAME, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(APPLICATION_NAME);
    }


    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.eri.afrosell.controller"))
                .paths(regex("/afrosell.*"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("AfroroSell Platform REST API Documents")
                .description("Documents with Swagger 2")
                .contact("")
                .license("")
                .licenseUrl("")
                .version("2.0")
                .build();
    }
}
