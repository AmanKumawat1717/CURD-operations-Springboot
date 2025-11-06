# CURD-operations-Springboot
A Spring Boot–based Generic CRUD API with integrated Swagger 3.0 documentation and basic security configuration using Spring Security.
# Tech Stack
Java 17+ |
Spring Boot 3+ |
Spring Data JPA (Hibernate) |
Spring Security (Basic Auth) |
MySQL Database |
Swagger / OpenAPI 3
# How to Run
1. Clone the Repository
git clone https://github.com/AmanKumawat1717/CURD-operations-Springboot.
cd CURD-operations-Springboot
2. Configure Database
  spring.datasource.url=jdbc:mysql://localhost:3306/productdbcreateDatabaseIfNotExist=true
  spring.datasource.username=root
   | spring.datasource.password=Password
4. Build the Project
  mvn clean package
4.1. Run the Application
  java -jar target/generic-crud-api-0.0.1-SNAPSHOT.jar
# Default Credentials
Username -> admin
Password  -> admin
# Swagger API Docs
Once the app is running, open: http://localhost:8080/swagger-ui/index.html
# Sample API Endpoints
| Method | Endpoint             | Description            |
| ------ | -------------------- | ---------------------- |
| GET    | `/api/products`      | Get all products       |
| GET    | `/api/products/{id}` | Get product by ID      |
| POST   | `/api/products`      | Create a new product   |
| PUT    | `/api/products/{id}` | Update product details |
| DELETE | `/api/products/{id}` | Delete a product       |
