# ITEM-OPERATING Project feat. SpringBoot

(Still working on this file...)

**🤡This project is just for practice🤡**

This project is a Java-based inventory management application built using the Spring Boot framework.
It provides functionalities to manage items, including creating, reading, updating, and deleting items. **[basic CRUD thing]**
With several main components:

1. Controllers: Handle HTTP requests (e.g., ItemController.java).
2. Domain: Define the entities/models (e.g., Item.java).
3. Repository: Handle data access (e.g., ItemRepository.java).
4. Service: Contain business logic (e.g., ItemService.java and ItemServiceImpl.java).
5. Application Properties: Configuration settings (application.properties).


Table initialization
```
CREATE TABLE items(
id BIGINT NOT NULL AUTO_INCREMENT,
Title VARCHAR(100) NOT NULL,
Description VARCHAR(2000),
Quantity BIGINT NOT NULL,
CONSTRAINT tutorials_PK PRIMARY KEY(id)
);
```
