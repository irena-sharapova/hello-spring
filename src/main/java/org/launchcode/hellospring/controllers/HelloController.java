package org.launchcode.hellospring.controllers;

//import ch.qos.logback.core.model.Model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    //@ResponseBody
    public String helloWithQueryParam(@RequestParam String name, Model model ) {
        String greeting = "Hello," + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }


    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
   // @ResponseBody
    public String helloWithPathParam(@PathVariable String name, Model model) {
        //String greeting = "Hello," + name + "!";
        model.addAttribute("greeting", "Hello," + name + "!");
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

}
