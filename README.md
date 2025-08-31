# Spring Boot Employee Management Application

A CRUD web application for managing employees, built with Spring Boot 3.5.5, Java 17, Spring Data JPA, Thymeleaf, and MySQL. Includes login authentication and a Bootstrap-styled UI.

## Features
- Employee CRUD: Add, update, delete, and list employees
- Login page with hardcoded credentials (admin/password)
- Confirmation dialog for employee deletion
- Responsive UI with Bootstrap
- REST API endpoints for employee operations

## Technologies Used
- Spring Boot 3.5.5
- Java 17
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap 5

## Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL database

### Setup
1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   ```
2. Configure your MySQL database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```
3. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access the app at [http://localhost:8080/login](http://localhost:8080/login)

### Login Credentials
- **Username:** admin
- **Password:** password

## Project Structure
```
src/
  main/
    java/com/sks/springboot/
      controller/         # MVC controllers
      dao/                # Spring Data JPA repository
      entity/             # Employee entity
      rest/               # REST API controller
      service/            # Service layer
    resources/
      templates/          # Thymeleaf HTML templates
      static/             # Static resources (CSS, JS)
      application.properties
```

## API Endpoints
- `/employees/list` - List all employees
- `/employees/showFormForAdd` - Add employee form
- `/employees/showFormForUpdate/{id}` - Update employee form
- `/employees/confirmDelete/{id}` - Delete confirmation
- `/employees/delete/{id}` - Delete employee (POST)
- `/api/employees` - REST API for employees

## License
This project is licensed under the MIT License.
