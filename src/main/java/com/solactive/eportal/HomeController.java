package com.solactive.eportal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solactive.eportal.dao.EventReplyRepository;
import com.solactive.eportal.dao.EventRepository;
import com.solactive.eportal.model.Event;
import com.solactive.eportal.model.EventReply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/eportal")
public class HomeController
{

   @Autowired
   private EventRepository eventRepository;

   @Autowired
   private EventReplyRepository eventReplyRepository;

   @Value("${spring.application.name}")
   String appName;

   List<Event> list = new ArrayList<>();

   @GetMapping("/list")
   public List<String> getList()
   {
      List<String> list = new ArrayList<>();
      list.add("event 1");
      list.add("event 2");
      list.add("event 3");
      list.add("event 4");
      list.add("event 5");
      return list;

   }

   @GetMapping("/home")
   public ModelAndView homePage(Model model)
   {
      model.addAttribute("appName", appName);

      ModelAndView mav = new ModelAndView("home");
      mav.addObject("appName", appName);
      mav.addObject("events", (List<Event>) eventRepository.findAll());

      return mav;
   }

   @GetMapping("/index")
   public ModelAndView index(Model model)
   {
      model.addAttribute("appName", appName);

      System.out.println("App name: " + appName);
      //set events
      ModelAndView mav = new ModelAndView("index");
      mav.addObject("appName", appName);

      return mav;
   }

   // list
   @GetMapping("/events")
   public ModelAndView getEvents()
   {
      ModelAndView mav = new ModelAndView("events");
      mav.addObject("appName", appName);
      mav.addObject("events", eventRepository.findAll());
      return mav;
   }

   @GetMapping("/events/{id}")
   public ModelAndView getEvent(@PathVariable("id") String id)
   {
      Optional<Event> eventOptional = eventRepository.findById(Long.valueOf(id));
      ModelAndView mav = new ModelAndView("description");
      Event event = null;

      if (eventOptional.isPresent())
      {
         event = eventOptional.get();
      }

      mav.addObject("event", event);
      return mav;
   }

   @PostMapping("/events/add")
   @ResponseStatus(HttpStatus.CREATED)
   public ModelAndView create(@RequestBody Event event)
   {
      ModelAndView mav = new ModelAndView("events");
      mav.addObject("appName", appName);
      Event eventCreated = eventRepository.save(event);
      mav.addObject("event", eventCreated);
      return mav;
   }

   @PostMapping("/events/{eventId}/add")
   @ResponseStatus(HttpStatus.CREATED)
   public ModelAndView create(@RequestBody EventReply eventReply, @PathVariable("eventId") String eventId)
   {
      ModelAndView mav = new ModelAndView("events");
      mav.addObject("appName", appName);
      Optional<Event> eventOptional = eventRepository.findById(Long.valueOf(eventId));
      if (eventOptional.isPresent())
      {
         eventReply.setEvent(eventOptional.get());
      }

      EventReply eventReplyCreated = eventReplyRepository.save(eventReply);
      mav.addObject("eventReply", eventReplyCreated);
      return mav;
   }
}
