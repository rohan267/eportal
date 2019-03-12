package com.solactive.eportal.dao;

import com.solactive.eportal.model.Event;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long>
{
}
