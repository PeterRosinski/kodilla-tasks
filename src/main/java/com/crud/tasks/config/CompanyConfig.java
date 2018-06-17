package com.crud.tasks.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {

    @Value("${info.app.name}")
    private String companyName;

    @Value("${info.app.description}")
    private String companyDescription;

}
