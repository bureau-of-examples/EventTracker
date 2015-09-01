package com.pluralsight.data;

import com.pluralsight.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Event repository.
 */
public interface EventRepository extends JpaRepository<Event, Long> {

}
