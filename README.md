# SG-EmpPortal-Backend
Societe Generale - Employee Portal backend source code using Java, Spring Boot, REST princicples, REST APIs, Swagger (for documentation and testing REST APIs

1) Download the backend source code from remote respository
https://github.com/saravanavel-blr2018/SG-EmpPortal-Backend.git
This source repository contains backend REST APIs with CRUD operation to connect to H2 in memory database to manage employee information

2) Maven build (go to the folder where pom.xml exists)
mvn clean install

3) run jar file
java -jar <jar-file-name>
  
4)This Spring Boot application by default creates H2 in memory database and Swagger documentation along with UI for testing

5) To access H2 in memory database
http:localhost:8080/h2-console

5) To access swagger UI to test REST APIs
http://localhost:8080/swagger-ui.html

6) Install front end components and test the employee portal using following
http://localhost:4200/employees (View Employees)
http://localhost:4200/addemployee (Register Employees)


