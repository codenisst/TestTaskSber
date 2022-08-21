package ru.codenisst.sber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.codenisst.sber.services.RequestBodyManager;

@RestController
public class Controller {

    private final RequestBodyManager manager;

    @Autowired
    public Controller(RequestBodyManager manager) {
        this.manager = manager;
    }

    @PostMapping(produces = "application/json")
    public void test(@RequestBody String requestBody) {
        manager.save(requestBody);
    }
}