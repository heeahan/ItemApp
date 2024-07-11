[[한국어] 아이템 관리 프로젝트 feat. SpringBoot](https://github.com/heeahan/ItemApp/edit/master/README.md#%ED%95%9C%EA%B5%AD%EC%96%B4-%EC%95%84%EC%9D%B4%ED%85%9C-%EA%B4%80%EB%A6%AC-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-feat-springboot)

[[ENG] ITEM-OPERATING Project feat. SpringBoot](https://github.com/heeahan/ItemApp/edit/master/README.md#eng-item-operating-project-feat-springboot)

[[中文] 物品管理项目 feat. SpringBoot](https://github.com/heeahan/ItemApp/edit/master/README.md#%E4%B8%AD%E6%96%87-%E7%89%A9%E5%93%81%E7%AE%A1%E7%90%86%E9%A1%B9%E7%9B%AE-feat-springboot)

# [한국어] 아이템 관리 프로젝트 feat. SpringBoot

**🤡연습용 프로젝트입니다🤡**

이 프로젝트는 SpringBoot 프레임워크를 사용하여 개발된 Java 기반의 애플리케이션으로, **CRUD** 작업을 통해 인벤토리에서 아이템을 생성, 조회, 수정, 삭제할 수 있는 기능을 제공합니다. 애플리케이션은 컨트롤러, 서비스, 레포지토리, 도메인 엔티티로 구성된 계층 구조를 따르고 있습니다.

## 1. 전체 프로젝트 구조

1. 컨트롤러: 들어오는 HTTP 요청을 처리하고 서비스를 통해 처리 작업을 진행

> ItemController: 아이템 관련 엔드포인트를 관리합니다.

2. 도메인: 데이터 모델을 나타내는 엔티티 클래스를 포함

> Item: 아이템을 나타냅니다.

3. 레포지토리: 데이터베이스와 인터페이스를 제공하며 CRUD 작업을 처리

> ItemRepository: JpaRepository를 확장하여 Item 엔티티를 관리합니다.

4. 서비스: 비즈니스 로직을 캡슐화하고 레포지토리와 상호작용

> ItemService: 아이템 관련 작업을 정의하는 인터페이스입니다.

> ItemServiceImpl: ItemService 인터페이스를 구현합니다.

## 2. 데이터베이스 파트

### 2.1 테이블 생성

아래는 테이블 생성 코드입니다.
```
CREATE TABLE items(
id BIGINT NOT NULL AUTO_INCREMENT,
Title VARCHAR(100) NOT NULL,
Description VARCHAR(2000),
Quantity BIGINT NOT NULL,
CONSTRAINT tutorials_PK PRIMARY KEY(id)
);
```
컬럼 4개로 정했습니다.

1. id: 아이템의 id, AUTO_INCREMENT 임
2. Title: 아이템의 이름
3. Description: 아이템에 대한 설명
4. Quantity: 아이템의 수량

| id | Title | Description | Quantity |
| --- | --- | --- | --- |
| 1 | sample1 | this is sample 1 | 0 |
| 2 | sample2 | yummy | 26 |

<sup>tmi</sup> 기본 기능 구현 완성 후 GPT한테 추가할 기능 있는지 물어봤는데 (현재 시점에)의미 있는 부분이 딱히 없어서 function도, 컬럼도 그대로 유지했습니다.

## 3. API 파트

### 3.1 개발 환경

- 언어: JAVA 21
- 프레임워크: Spring Boot 3.3.1
- 프로젝트 빌드도구: Gradle - Groovy
- IDE: IntelliJ IDEA
- 데이터베이스: MySQL
- REST API Documentation 툴: Swagger UI
- OS: Windows

### 3.2 실행 방법

*웹 URL로 레포지토리 클론*
```
git clone https://github.com/Project_web_URL
```

*프로젝트 디렉토리로 이동*
```
cd ItemApp
```

*프로젝트 빌드 및 실행*

- *Windows:*
```
gradlew.bat build
gradlew.bat bootRun
```

* *Linux/MacOS:*
```
./gradlew build
./gradlew bootRun
```

*Swagger UI 접속*
```
localhost:8080/swagger-ui/index.html
```

## 4. 프로젝트를 마치며..☕

1. Spring Boot의 다양한 설정 옵션과 의존성 관리를 이해하는 데 시간이 필요합니다. (전설의 Annotation)
2. ***application.properties*** 파일을 통해 환경 설정을 관리하며, 프로파일을 사용하여 개발, 테스트, 프로덕션 환경을 구분하는 것이 좋습니다.
3. RESTful API를 설계하고 구현하는 과정에서 엔드포인트 디자인과 HTTP 메서드 사용에 대한 고민이 필요했습니다.
4. 예외 처리!
   - 모든 레이어에서 발생할 수 있는 예외를 적절히 처리해야 합니다. 특히, 데이터베이스와의 상호작용에서 발생할 수 있는 예외를 잘 관리하는 것이 중요합니다.
   - Spring의 @ControllerAdvice와 @ExceptionHandler를 사용하여 전역 예외 처리를 구현할 수 있습니다.

## 5. 진짜 마지막  
ItemApp 프로젝트는 Spring Boot와 Java를 사용한 인벤토리 관리 시스템의 좋은 예제입니다.

(멘토님, 샘플 코드/구글링/ChatGPT의 도움을 많이 받았습니다.)

이 프로젝트를 통해 **Spring Boot의 기본적인 구조와 CRUD 기능 구현**, **데이터베이스 통합**, **RESTful API 설계** 등의 기술을 습득할 수 있습니다. 개발 과정에서 직면한 어려움과 주의사항을 바탕으로, 더욱 견고하고 확장 가능한 애플리케이션을 개발할 수 있을 것입니다.


# [ENG] ITEM-OPERATING Project feat. SpringBoot

**🤡This project is just for practice🤡**

This project is a Java-based inventory management application built using the Spring Boot framework.
It provides functionalities to manage items, including creating, reading, updating, and deleting items. **[basic CRUD thing]**

## 1. Project Structure

1. Controllers: Handle HTTP requests (e.g., ItemController.java).
2. Domain: Define the entities/models (e.g., Item.java).
3. Repository: Handle data access (e.g., ItemRepository.java).
4. Service: Contain business logic (e.g., ItemService.java and ItemServiceImpl.java).
5. Application Properties: Configuration settings (application.properties).

## 2. Databse Part

### 2.1 Table initialization

Here is the code for table initialization.
```
CREATE TABLE items(
id BIGINT NOT NULL AUTO_INCREMENT,
Title VARCHAR(100) NOT NULL,
Description VARCHAR(2000),
Quantity BIGINT NOT NULL,
CONSTRAINT tutorials_PK PRIMARY KEY(id)
);
```
There are 4 columns.

1. id: Id of the item, but it is AUTO_INCREMENT.
2. Title: Name of the item.
3. Description: Some more details about the item.
4. Quantity: Obviously the quantity of the item.

| id | Title | Description | Quantity |
| --- | --- | --- | --- |
| 1 | sample1 | this is sample 1 | 0 |
| 2 | sample2 | yummy | 26 |

<sup>tmi</sup> I asked GPT if there are mroe/better things to add after finishing the basic functions of the project, but most of the advice was meaningless(for me right now). So I did no change to the functions or columns.

## 3. API Part

### 3.1 Environment

- Language: JAVA 21
- Framework: Spring Boot 3.3.1
- Project build tool: Gradle - Groovy
- IDE: IntelliJ IDEA
- Database: MySQL
- REST API Documentation Tool: Swagger UI
- OS: Windows

### 3.2 How To Run

*Clone the repository from web URL*
```
git clone https://github.com/Project_web_URL
```

*Go to the project dir*
```
cd ItemApp
```

*Build and Run the Project*

- *Windows:*
```
gradlew.bat build
gradlew.bat bootRun
```

* *Linux/MacOS:*
```
./gradlew build
./gradlew bootRun
```

*Test on Swagger UI*
```
localhost:8080/swagger-ui/index.html
```

## 4. End of the Project☕

1. It takes time to understand the various configuration options and dependency management in Spring Boot. (The legendary Annotations)
2. It is advisable to manage environment settings through the ***application.properties*** file and use profiles to distinguish between development, test, and production environments.
3. During the process of designing and implementing the RESTful API, careful consideration was needed for endpoint design and the use of HTTP methods.
4. Exception handling!
   - It is crucial to appropriately handle exceptions that may occur at all layers, especially managing exceptions that arise from interactions with the database.
   - Implement global exception handling using Spring's @ControllerAdvice and @ExceptionHandler.

## 5. The very last

The ItemApp project is a good example of an inventory management system using Spring Boot and Java.

(I received a lot of help from my mentor, sample code, Google searches, and ChatGPT.)

Through this project, I have learned various technologies such as the basic structure of **Spring Boot and implementation of CRUD functionalities**, **database integration**, and **RESTful API design**. Based on the challenges and precautions encountered during the development process, I will be able to develop more robust and scalable applications. (maybe)

# [中文] 物品管理项目 feat. SpringBoot

**🤡本项目仅用于练习🤡**

## 1. 项目整体结构

1. 用于接受请求
