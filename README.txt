HIBERNATE STUDENT APPLICATION
=============================

Database configuration is already filled in.

Host: db01.dbhost.dev
Port: 5051
Database: db_44z9ambm2

Run:
    mvn clean compile
    mvn exec:java

Or run Main.java from Eclipse/IntelliJ.

The application:
- Maps Student to the student table
- Inserts a Student record
- Updates the course
- Uses Hibernate ORM with MySQL

Verify the record using:
    SELECT * FROM student;
