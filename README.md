# Documentation API - api-employee-invex

this project is an API REST of employee that was built with **Spring Boot**.
## Table of content
1. [Requirements]
2. [Installation]
3. [API Content]

## Requirements
- Java 17+
- Maven 3.4+
- DataBase PostgreSQL

## Installation

### Option 1 - GitHub
```bash
git clone https://github.com/r0g3r92/api-employee-invex.git
cd api-employee-invex
./mvnw clean install -U
./mvnw spring-boot:run

validate: http://localhost:8082/swagger-ui.html
```

### Option 2 - ZipFile

- like a first step download the zip file and then unzip that.
``` bash
cd api-employee-invex
./mvnw clean install -U
./mvnw spring-boot:run

validate: http://localhost:8082/swagger-ui.html
```

## API Content

### Employee  
#### URI: /employee/api/v1

#### Endpoints
- Create Employee
    - Url: /create
    - Method: Post
    - Description: This api creates new employee

- Delete Employee
    - Url: /delete/{id}
    - Method: Delete
    - Description: This api deletes employees

- Get All Employees
    - Url: /search-all
    - Method: Get
    - Description: This api gets all employees

- Update Employee 
    - Url: /update
    - Method: Put
    - Description: This api updates employees
