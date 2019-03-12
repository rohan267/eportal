package com.solactive.eportal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/list")
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("event 1");
        list.add("event 2");
        list.add("event 3");
        return list;

    }

    // list

   // detail page

   // create event
}
