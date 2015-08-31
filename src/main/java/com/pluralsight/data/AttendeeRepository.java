package com.pluralsight.data;

import com.pluralsight.model.Attendee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Attendee repository.
 */
public interface AttendeeRepository extends PagingAndSortingRepository<Attendee, String>{

}
