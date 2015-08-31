package com.pluralsight.data;

import com.pluralsight.model.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Event repository.
 */
public interface EventRepository extends PagingAndSortingRepository<Event, Long>{

}
