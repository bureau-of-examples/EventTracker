package com.pluralsight;


import com.pluralsight.model.Attendee;
import com.pluralsight.test.AttendeeValidator;
import com.pluralsight.test.TestSpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Random;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TestSpringConfiguration.class})
public class ValidationTest {

    @Autowired
    private Random random;

    @Test
    public void validatorTest(){
        Attendee attendee = new Attendee("Michael", "m" + random.nextInt() + "@gmail.com");
        AttendeeValidator validator = new AttendeeValidator();
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(attendee, "attendee");
        DefaultMessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();
        result.setMessageCodesResolver(messageCodesResolver);
        ValidationUtils.invokeValidator(validator, attendee, result);
        assertEquals(1, result.getErrorCount());
        ObjectError error = result.getAllErrors().get(0);
        assertEquals("MichaelIsNotAllowed", error.getCode());
        assertEquals(null, error.getDefaultMessage());
    }

    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    @Test
    public void beanValidationTest(){
        Attendee attendee = new Attendee();
        attendee.setEmail("a");
        attendee.setName("B");
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(attendee, "attendee");
        localValidatorFactoryBean.validate(attendee, result);
        assertEquals(3, result.getErrorCount());
        for(ObjectError error : result.getAllErrors()){
            System.out.println(error.getCode());
            System.out.println(error.getDefaultMessage());

            System.out.println();

        }

    }

    @Test
    public void beanWrapperTest(){
        BeanWrapper bean = new BeanWrapperImpl(new Attendee());
        bean.setPropertyValue(new PropertyValue("email", "mytest@email.com"));
        Attendee attendee = (Attendee)bean.getWrappedInstance();
        assertEquals("mytest@email.com", attendee.getEmail());
    }








}
