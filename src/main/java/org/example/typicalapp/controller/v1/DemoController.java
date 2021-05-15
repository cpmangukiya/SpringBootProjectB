package org.example.typicalapp.controller.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.example.typicalapp.dto.ResponseDto;
import org.example.typicalapp.exception.InvalidValueException;
import org.example.typicalapp.exception.NonUniqueNameException;
import org.example.typicalapp.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Transactional(isolation = Isolation.READ_COMMITTED)
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    @RequestMapping(path = "/hello")
    @ApiOperation(value = "Hello Service",
            notes = "This is a sample endpoint",
            response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "This is success case"),
            @ApiResponse(code = 404, message = "Resource ABC Not Found"),
            @ApiResponse(code = 501, message = "Internal application server. Please report to helpdesk.")})
    public String hello() {
        logger.info("Hello called up");
        return "Hello World";
    }
    @GetMapping(value = "/to-lower-case/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> toLowerCase(@PathVariable String value) throws InvalidValueException,
            NonUniqueNameException {
        log.debug("DemoController > Convert to lower case > Started ...");
        log.info("DemoController > Convert to lower case > Value to process " + value);
        String responseValue = demoService.toLowerCase(value);
        log.debug("DemoController > Convert to lower case > Response value" + responseValue);
        return ResponseEntity.ok(new ResponseDto(true, responseValue));
    }
}
