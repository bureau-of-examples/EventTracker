package com.pluralsight.conversion;

import com.pluralsight.model.Attendee;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;

/**
 * Convert from string to attendee.
 */
public class AttendeeFormatter implements Formatter<Attendee> {


    @Override
    public Attendee parse(String text, Locale locale) throws ParseException {
        if(text == null)
            return null;

        Attendee attendee = new Attendee();
        String[] values = text.split(",");
        if(values.length > 0)
            attendee.setName(filterEmptyValue(values[0]));
        if(values.length > 1) {
            String val = filterEmptyValue(values[1]);
            attendee.setGender(StringUtils.isEmpty(val) ? null : val.charAt(0));
        }
        if(values.length > 2)
            attendee.setEmail(filterEmptyValue(values[2]));
        if(values.length > 3)
            attendee.setPhone(filterEmptyValue(values[3]));

        return attendee;
    }

    @Override
    public String print(Attendee object, Locale locale) {

        StringBuilder stringBuilder = new StringBuilder();
        if(object.getName() != null){
            stringBuilder.append(object.getName());
        }
        stringBuilder.append(",");
        if(object.getGender() != null){
            stringBuilder.append(object.getGender());
        }
        stringBuilder.append(",");
        if(object.getEmail() != null){
            stringBuilder.append(object.getEmail());
        }
        stringBuilder.append(",");
        if(object.getPhone() != null){
            stringBuilder.append(object.getPhone());
        }

        return stringBuilder.toString();
    }

    private static String filterEmptyValue(String val){
        if(StringUtils.isEmpty(val))
            return null;

        return val;
    }
}
