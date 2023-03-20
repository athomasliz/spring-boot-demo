package org.irushu.demo.web.controller;

import org.irushu.demo.service.CoupleService;
import org.irushu.demo.service.messaging.kafka.DemoProducerService;
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
    private CoupleService coupleService;

    @Autowired
    private DemoProducerService demoProducerService;

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "/copycat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "A copycat function that returns the input value.", description = "The value in outputParam1 copies the value in inputParam1.")
    public DemoResponse copycat(@RequestBody DemoRequest demoRequest)
    {
        logger.info("[copycat Request] {}" , demoRequest.toString());

        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setOutputParam1(demoRequest.getInputParam1());

        logger.info("[copycat Response] {}" , demoResponse.toString());
        return demoResponse;
    }

    @RequestMapping(value = "/findYourWife", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Input your name. Find your wife.", description = "")
    public DemoResponse findYourWife(@RequestBody DemoRequest demoRequest)
    {
        logger.info("[findYourWife Request] {}" , demoRequest.toString());
        String wifeName = coupleService.findYourWife(demoRequest.getInputParam1());
        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setOutputParam1(wifeName);

        logger.info("[findYourWife Response] {}" , demoResponse.toString());
        return demoResponse;
    }

    @RequestMapping(value = "/kafkaProducer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Input message.", description = "")
    public DemoResponse kafkaProducer(@RequestBody DemoRequest demoRequest)
    {
        logger.info("[kafkaProducer Request] {}" , demoRequest.toString());

        demoProducerService.send(demoRequest);

        DemoResponse demoResponse = new DemoResponse();
        demoResponse.setOutputParam1("Message successfully sent to Kafka Topic");

        logger.info("[kafkaProducer Response] {}" , demoResponse.toString());
        return demoResponse;
    }

}
