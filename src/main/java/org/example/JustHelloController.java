package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@RestController
@Transactional(isolation = Isolation.READ_COMMITTED)
public class JustHelloController {

    Logger logger = (Logger) LoggerFactory.getLogger(JustHelloController.class);

    @RequestMapping(path = "/hello")
    public String hello() {
        logger.info("Hello called up");
        return "Hello World";
    }

    @Null
    private String name;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }
}
