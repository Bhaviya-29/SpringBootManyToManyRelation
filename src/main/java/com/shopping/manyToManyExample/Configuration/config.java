package com.shopping.manyToManyExample.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class config {
    //instead of looking at everything(default),swagger looks at this docket bean to know what it needs to do
    @Bean
    public Docket api(){ // set properties in it
        // .select creates a builder, obj of class  ApiSelectorBuilder --
        // it has methods that customize how we want swagger to behave
        //build() method creates a docket
        return new Docket(DocumentationType.SWAGGER_2)
                .select()// get builder object
                .paths(regex("/api.*")) //configuring paths -- only select paths with pattern api/*
                // /error paths are not included
                .apis(RequestHandlerSelectors.basePackage("com.shopping.manyToMany")) //only looks at this package
                .build()
                .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "e - Commerce API ",
                "sample api for many to many relation",
                "1.0",
                "free to use",
                new Contact("Bhaviya Kamdar","abc.com","a@b"),
                "license",
                "abc.com",
                Collections.emptyList()
        );
    }
}
