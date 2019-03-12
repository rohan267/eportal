package com.solactive.eportal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/eportal")
public class HomeController
{

   @Value("${spring.application.name}")
   String appName;

   @GetMapping("/list")
   public List<String> getList()
   {
      List<String> list = new ArrayList<>();
      list.add("event 1");
      list.add("event 2");
      list.add("event 3");
      list.add("event 4");
      list.add("event 4");
      return list;

   }

   @GetMapping("/home")
   public String homePage(Model model)
   {
      model.addAttribute("appName", appName);
      return "home";
   }
   // list

   // detail page


   // create event
}
