package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JustHelloController {

    Logger logger = (Logger) LoggerFactory.getLogger(JustHelloController.class);

    @RequestMapping(path = "/hello")
    public String hello() {
        logger.info("Hello called up");
        return "Hello World";
    }

}
