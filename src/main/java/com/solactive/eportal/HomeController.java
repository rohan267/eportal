package com.solactive.eportal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.solactive.eportal.model.Event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eportal")
public class HomeController
{

   private static List<Event> events = new ArrayList<>();

   static
   {
      events.add(new Event(1, "Event 1"));
      events.add(new Event(2, "Event 2"));
      events.add(new Event(3, "Event 3"));
      events.add(new Event(4, "Event 4"));

   }

   @Value("${spring.application.name}")
   String appName;

    @GetMapping("/list")
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("event 1");
        list.add("event 2");
        list.add("event 3");
       list.add("event 4");
       list.add("event 5");
        return list;

   }

   @GetMapping("/home")
   public String homePage(Model model)
   {
      model.addAttribute("appName", appName);
      return "home";
   }
   // list
   @GetMapping("/events")
   public List<Event> getEvents() {
      return events;
   }

   @GetMapping("/events/{id}")
   public Event getEvents(@PathVariable("id") Integer id) {
      List<Event> list = events.stream().filter(event -> event.getId().equals(id)).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(list))
      {
         return  null;
      }
      return list.get(0);
   }

   @PostMapping("/events/add")
   @ResponseStatus(HttpStatus.CREATED)
   public Event getEvents(@RequestBody Event event) {
      events.add(event);
      return event;
   }


}
