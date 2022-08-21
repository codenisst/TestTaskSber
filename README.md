# What is this?

This is API Server (JSON HTTP API).
- Development tools: Java
- Framework: Spring Boot (Web, JPA, Actuator)
- context-path: /core-api
- Database: SQLite
- Protocol: HTTP, port 8080

- Functionality (queries):
    - Adding log from "frontend"
        - Request body - JSON with attributes:
            - message - text
            - type - text
            - level - text
            - time - timestamp
    - The message is written to the database in the same format, as well as to the log file (Logback)
    - Server response - 200 OK

Spring Actuator - */actuator/health*

### How to start it up?
For Windows:
1) Make sure you have JRE installed - https://www.java.com/ru/download/
2) Open a command line: ***Win+R -> cmd***
3) Navigate to the directory with the executable .jar file using the ***cd*** operator.
4) Type ***java -jar TestTaskSber.jar***

________________________
# Что это?

Это API-сервер (JSON HTTP API).
- Средства разработки: Java
- Framework: Spring Boot (Web, JPA, Actuator)
- context-path: /core-api
- База данных: SQLite
- Протокол: HTTP, порт 8080
- Функционал (запросы):
    - Добавление лога с "фронта"
        - Тело запроса - JSON с атрибутами:
            - message - text
            - type - text
            - level - text
            - time - timestamp
        - Сообщение записывается в БД в том же формате, а так же в файл лога (Logback)
        - Ответ сервера - 200 ОК
      
Spring Actuator - */actuator/health*

### Как запустить?

Для Windows:
1) Убедитесь, что у вас установлена JRE - https://www.java.com/ru/download/
2) Откройте командную строку: ***Win+R -> cmd***
3) Перейдите в дирректорию с исполняемым .jar файлом, используя оператор ***cd***
4) Введите ***java -jar TestTaskSber.jar***