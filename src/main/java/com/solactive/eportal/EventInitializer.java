package com.solactive.eportal;

import com.solactive.eportal.dao.EventRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventInitializer implements InitializingBean
{
   @Autowired
   private EventRepository eventRepository;

   @Override public void afterPropertiesSet() throws Exception
   {

      //eventRepository.saveAll(null);

   }
}
