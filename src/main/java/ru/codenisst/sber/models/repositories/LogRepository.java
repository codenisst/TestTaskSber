package ru.codenisst.sber.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.codenisst.sber.models.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

}
