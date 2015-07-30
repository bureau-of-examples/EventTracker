package com.pluralsight.test;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

import java.util.Random;

@Configuration
public class TestSpringConfiguration {

    @Bean
    public Random testRandom() {
        Random random = new Random(1199);
        return random;
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("errors");
        return messageSource;
    }

    @Bean(name = "validator")
    public OptionalValidatorFactoryBean validator(){
        OptionalValidatorFactoryBean validatorFactoryBean = new OptionalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource());
        return validatorFactoryBean;
    }
}
