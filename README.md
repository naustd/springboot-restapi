# 📘 Spring Boot REST API – Student Placement Records

This project is a complete RESTful web service built using **Spring Boot** and **PostgreSQL** to manage student placement records. It supports full CRUD (Create, Read, Update, Delete) operations and integrates Swagger UI for API documentation.

---

## 🛠️ Technologies Used

| Technology       | Purpose                                |
|------------------|----------------------------------------|
| Spring Boot      | REST API Framework                     |
| Spring Data JPA  | ORM for DB operations                  |
| PostgreSQL       | Relational database                    |
| Lombok           | Boilerplate code reduction (getters/setters) |
| Spring Boot DevTools | Hot reload during development     |
| Swagger UI       | API Documentation and Testing          |
| Git/GitHub       | Version Control                        |

---

## 🧾 Table Schema - `studentrecords`

| Field        | Type        | Description                  |
|--------------|-------------|------------------------------|
| id           | Integer     | Auto-generated primary key   |
| firstName    | String      | Student's first name         |
| lastName     | String      | Student's last name          |
| email        | String      | Email address (unique)       |
| mobileNumber | String      | Contact number               |
| hireDate     | Date        | Placement date               |
| jobTitle     | String      | Job position/title           |
| salary       | BigDecimal  | Offered salary               |

---

## 🗃️ Database Configuration

**Database:** `postgre`  
**Table:** `studentrecords`

Configure your PostgreSQL connection in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgre
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

| Method | Endpoint    | Description             |
| ------ | ----------- | ----------------------- |
| GET    | `/api/students` | Get all student records |
| GET    | `/api/students/{id}` | Get student by ID       |
| POST   | `/api/student` | Create new record       |
| PUT    | `/api/students/{id}` | Update existing record  |
| DELETE | `/api/{id}` | Delete by ID            |

## Initialize Git in project
git init
## Add remote GitHub repository
git remote add origin "github-repo-url"
## Check status
git status
## Stage all files
git add .
## Commit the changes
git commit -m "Initial commit: Added Spring Boot REST API for Student Records"
## Push code to main branch
git push -u origin main


✅ Features Implemented <br/>
✅ Complete CRUD functionality <br/>
✅ Integration with PostgreSQL <br/>
✅ Exception handling <br/>
✅ Clean code with Lombok <br/>
✅ Git integration for version control <br/>