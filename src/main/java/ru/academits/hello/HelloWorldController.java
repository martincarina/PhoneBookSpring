package ru.academits.hello;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello/api/v1")
public class HelloWorldController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam(required = false) String name) {
        return "hello, " + name;
    }

}


