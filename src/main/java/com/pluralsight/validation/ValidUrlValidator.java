package com.pluralsight.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public class ValidUrlValidator implements ConstraintValidator<ValidUrl, String> {

    private String protocol;
    private String host;
    private int port;

    @Override
    public void initialize(ValidUrl constraintAnnotation) {
        this.protocol = constraintAnnotation.protocol();
        this.host = constraintAnnotation.host();
        this.port = constraintAnnotation.port();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(value))
            return true;

        try {
            URL url = new URL(value);
            if(!StringUtils.isEmpty(this.protocol) && !Objects.equals(this.protocol, url.getProtocol()))
                return false;
            if(!StringUtils.isEmpty(this.host) && !Objects.equals(this.host,url.getHost()))
                return false;

            if(this.port != -1 && this.port != url.getPort())
                return false;

            return true;
        }catch (MalformedURLException ex){
            return false;
        }
    }
}
