package com.solactive.eportal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solactive.eportal.dao.EventRepository;
import com.solactive.eportal.model.Event;

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

   private List<Event> prepareList() {
      Event event2 = new Event();
      event2.setTitle("Want to sell my phone. Anyone interested?");
      list.add(event2);

      Event event3 = new Event();
      event3.setTitle("Poker evening on coming Friday");
      list.add(event3);

      return list;
   }

   @GetMapping("/home")
   public ModelAndView homePage(Model model)
   {
      model.addAttribute("appName", appName);

      ModelAndView mav = new ModelAndView("home");
      mav.addObject("appName", appName);
      mav.addObject("events", prepareList());

      return mav;
   }

   // list
   @GetMapping("/events")
   public List<Event> getEvents()
   {
      return (List<Event>) eventRepository.findAll();
   }

   @GetMapping("/events/{id}")
   public Event getEvents(@PathVariable("id") Long id)
   {
      Optional<Event> eventOptional = eventRepository.findById(id);
      if (eventOptional.isPresent())
      {
         eventOptional.get();
      }
      return null;
   }

   @PostMapping("/events/add")
   @ResponseStatus(HttpStatus.CREATED)
   public Event getEvents(@RequestBody Event event)
   {
      return eventRepository.save(event);
   }
}
