package ru.codenisst.sber.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.codenisst.sber.models.Log;
import ru.codenisst.sber.models.repositories.LogRepository;
import ru.codenisst.sber.util.LogException;

@Service
public class RequestManager {

    private final LogRepository repo;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RequestManager(LogRepository repo, ObjectMapper objectMapper) {
        this.repo = repo;
        this.objectMapper = objectMapper;
    }

    public void save(String stringJson) {
        try {
            Log log = objectMapper.readValue(stringJson, Log.class);
            repo.save(log);
            logger.info("Saved in the database: " + log.getMessage());
        } catch (JsonProcessingException e) {
            throw new LogException("Log is not properly compiled.");
        }
    }

    public void handle(RuntimeException e) {
        logger.error(e.getMessage());
    }
}
