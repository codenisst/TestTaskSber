package ru.codenisst.sber.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.codenisst.sber.models.Log;
import ru.codenisst.sber.services.RequestService;

@RestController
public class Controller {

    private final RequestService requestService;
    private final Logger logger = LoggerFactory.getLogger(Controller.class);
    private final ObjectMapper objectMapper;

    @Autowired
    public Controller(RequestService requestService, ObjectMapper objectMapper) {
        this.requestService = requestService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public void takeLog(@RequestBody String requestBody){
        try {
            Log log = objectMapper.readValue(requestBody, Log.class);
            requestService.save(log);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @ExceptionHandler
    private void handleException(RuntimeException e) {
        logger.error(e.getMessage());
    }
}