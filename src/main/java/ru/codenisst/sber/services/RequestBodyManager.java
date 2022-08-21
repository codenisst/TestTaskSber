package ru.codenisst.sber.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.codenisst.sber.models.Log;
import ru.codenisst.sber.models.repositories.LogRepository;

@Service
public class RequestBodyManager {

    private final LogRepository repo;
    private final ObjectMapper objectMapper;
    //логгер

    @Autowired
    public RequestBodyManager(LogRepository repo, ObjectMapper objectMapper) {
        this.repo = repo;
        this.objectMapper = objectMapper;
    }

    public void save(String stringJson) {
        try {
            Log log = objectMapper.readValue(stringJson, Log.class);

            repo.save(log);
            //логгер пишет в лог об успехе
        } catch (JsonProcessingException e) {
            //логгер пишет в лог о провале
            System.out.println("Пишется ошибка в лог о некорректном jsone");
        }
    }
}
