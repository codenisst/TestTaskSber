package ru.codenisst.sber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.codenisst.sber.services.RequestManager;

@RestController
public class Controller {

    private final RequestManager manager;

    @Autowired
    public Controller(RequestManager manager) {
        this.manager = manager;
    }

    @PostMapping(produces = "application/json")
    public void takeLog(@RequestBody String requestBody) {
        manager.save(requestBody);
    }

    @ExceptionHandler
    private void handleException(RuntimeException e) {
        manager.handle(e);
    }
}