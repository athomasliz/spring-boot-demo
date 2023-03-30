package org.irushu.demo.web.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.irushu.demo.service.MysqlService;
import org.irushu.demo.service.KafkaProducerService;
import org.irushu.demo.web.model.DemoRequest;
import org.irushu.demo.web.model.DemoResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/")

public class DemoController {

    @Autowired
    private MysqlService mysqlService;

    @Autowired
    private KafkaProducerService demoProducerService;

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "/echo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "An echo function that returns the input value.", description = "The value in output is the same as the value in input.", security = @SecurityRequirement(name = "bearerAuth"))
    public DemoResponse echo(@RequestBody DemoRequest demoRequest)
    {
        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setOutput(demoRequest.getInput());
        return demoResponse;
    }

    @RequestMapping(value = "/findInMysql", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find in Mysql", description = "", security = @SecurityRequirement(name = "bearerAuth"))
    public DemoResponse findInMysql(@RequestBody DemoRequest demoRequest)
    {
        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setOutput(mysqlService.findByInput(demoRequest.getInput()));
        return demoResponse;
    }

    @RequestMapping(value = "/kafkaProducer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Input message.", description = "", security = @SecurityRequirement(name = "bearerAuth"))
    public DemoResponse kafkaProducer(@RequestBody DemoRequest demoRequest)
    {
        demoProducerService.send(demoRequest);
        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setOutput("Message successfully sent to Kafka Topic");
        return demoResponse;
    }

}
