# Bitech-Ecommerce Technical Test

## Description
This project is a technical test developed using Spring Boot, Java, RESTful API, and follows good practices of clean code and SOLID principles. It also includes a connection to a MySQL database.

## Download and Clone
To download or clone the project, follow these steps:

1. Open the following link: [Bitech-Ecommerce](https://github.com/Nirom-m/Bitech-Ecommerce.git)
2. Click on the "Code" button.
3. Copy the repository URL.
4. Open your terminal or command prompt.
5. Navigate to the directory where you want to clone the project.
6. Run the following command: git clone https://github.com/Nirom-m/Bitech-Ecommerce.git
7. The project will be cloned to your local machine.

## Database Connection
To connect to the MySQL database, configure the following properties in your project:

This is located in the properties of the controller module:
```yaml
spring:
datasource:
 url: jdbc:mysql://localhost:3306/bitech-ecommerce
 username: root
 password: 1234
jpa:
 hibernate:
   ddl-auto: update
server:
  port: 8090 yaml
```
And this s located in the properties of the model module:

```yaml
spring:
datasource:
 url: jdbc:mysql://localhost:3306/bitech-ecommerce
 username: root
 password: 1234
jpa:
 hibernate:
   ddl-auto: update
```
