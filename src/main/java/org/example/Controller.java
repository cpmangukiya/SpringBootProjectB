package org.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(path = "/hello")
    public String hello() {
        return "Hello World";
    }

}
