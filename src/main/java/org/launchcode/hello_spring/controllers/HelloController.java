package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
       // String html =
//                "<html>" +
//                        "<body>" +
//                        "<form method='get' action='/hello'>" +
//                        "<input type='text' name='name' />" +
//                        "<input type='submit' value='Greet Me!' />" +
//                        "</form>" +
//                        "</body>" +
//                        "</html>";
        return "form";
    }
}
