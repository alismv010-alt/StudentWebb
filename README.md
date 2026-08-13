# Student Management System

A full-stack web application designed to manage student records efficiently. The system provides complete CRUD (Create, Read, Update, Delete) functionality with dynamic filtering and database persistence.

---

##  Features

* **Student Management:** Create, view, update, and delete student entries.
* **Dynamic Search/Filtering:** Filter students in real-time by Name, Surname, Age, Email, or University.
* **Relational Mapping:** Maps student entities to their respective universities.
* **RESTful API:** Clean separation between backend architecture and frontend components.

---

## Tech Stack

### **Backend**
* **Language:** Java
* **Framework:** Spring Boot (Spring Web, Spring Data JPA)
* **Database:** MySQL
* **Build Tool:** Gradle

### **Frontend**
* **Core:** HTML5, JavaScript (AJAX / `XMLHttpRequest`)
* **Styling & UI Components:** Bootstrap 4
* *(Note: Assisted/generated starting templates were utilized for frontend structure and styling layout).*

---

## 🔧 Environment Setup & Configuration

To secure sensitive database credentials, environmental variables are used.

1. **Configure Environment Variables:**
   Set the following environment variables in your IDE (e.g., IntelliJ IDEA) or operating system:
   * `DB_USERNAME`: Your MySQL username 
   * `DB_PASSWORD`: Your MySQL password

2. **Application Properties:**
   Ensure your `application.properties` references these variables:
   ```properties
   spring.application.name=education
   spring.datasource.url=jdbc:mysql://localhost:3306/new_schema
   server.port=9090
   server.servlet.context-path=/education

   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.show-sql=true
   logging.level.org.hibernate.SQL=DEBUG
