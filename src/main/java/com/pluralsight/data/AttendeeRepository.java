package com.pluralsight.data;

import com.pluralsight.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Attendee repository.
 */
public interface AttendeeRepository extends JpaRepository<Attendee, String> {

}
