package ru.codenisst.sber.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.codenisst.sber.models.Log;
import ru.codenisst.sber.models.repositories.LogRepository;

@Service
public class RequestService {

    private final LogRepository repo;
    private final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    public RequestService(LogRepository repo) {
        this.repo = repo;
    }

    public void save(Log log) {
            repo.save(log);
            logger.info("Saved in the database: " + log.getMessage());
    }
}
