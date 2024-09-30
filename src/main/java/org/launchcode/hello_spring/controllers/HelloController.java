package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class HelloController {

    //display form
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method='post' action='/hello'>" +
                        "<input type='text' name='name' placeholder='Enter your name' />" +
                        "<select name='language'>" +
                        "<option value='english'>English</option>" +
                        "<option value='french'>French</option>" +
                        "<option value='italian'>Italian</option>" +
                        "<option value='spanish'>Spanish</option>" +
                        "<option value='german'>German</option>" +
                        "</select>" +
                        "<input type='submit' value='Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    // Handles the form submission via POST
    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    @GetMapping
    public static String createMessage(String name, String language) {
        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello";
        }
        else if (language.equals("french")) {
            greeting = "Bonjour";
        }
        else if (language.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (language.equals("spanish")) {
            greeting = "Hola";
        }
        else if (language.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + name;
    }
}



