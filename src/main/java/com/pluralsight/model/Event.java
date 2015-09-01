package com.pluralsight.model;

import com.pluralsight.validation.EventDuration;
import com.pluralsight.validation.ObjectName;
import com.pluralsight.validation.ValidEvent;
import com.pluralsight.validation.ValidUrl;
import com.pluralsight.validation.group.BusinessLogicGroup;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@ValidEvent(groups = {BusinessLogicGroup.class})
public class Event {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    @ObjectName
    private String name;

    @NotNull
    private Date date;

    private String location;

    @Min(1)
    @EventDuration
    private Integer duration; //duration in minutes

    @ValidUrl.List({
            @ValidUrl(protocol = "http"),
            @ValidUrl(host = "baidu.com")
    })
    private String url;


    @ManyToMany()
    @Cascade(CascadeType.ALL)
    @BatchSize(size = 10)
    private List<Attendee> attendees = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
