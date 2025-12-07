# Hostel Management System

A beginner-friendly JavaFX application for managing hostel students. Users can **add**, **update**, **delete**, and **view** students, with all data stored in a MySQL database. This project demonstrates how to connect a JavaFX GUI with a database using JDBC.

![JavaFX](https://img.shields.io/badge/JavaFX-25+-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-orange)
![Java](https://img.shields.io/badge/Java-21+-red)
![License](https://img.shields.io/badge/License-MIT-green)

---

## 📋 Features

- ✅ Add new students (Name, Phone, Course)
- ✅ Update existing student details
- ✅ Delete students from database
- ✅ Display students in a TableView
- ✅ Refresh table to reload data
- ✅ Clean project structure with separate packages
- ✅ Beginner-friendly code for learning JavaFX + MySQL integration

---

## 🛠️ Requirements

- **Java 21+** (JDK)
- **JavaFX SDK 25+**
- **MySQL Server 8.0+** (default port `3306`)
- **MySQL Connector/J** (e.g., `mysql-connector-j-9.5.0.jar`)
- **Windows Operating System**
- Optional: **VS Code**, **IntelliJ IDEA**, or **Eclipse**

---

## 📦 Installation & Setup

### 1. Install Java

Download and install [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/)

Verify installation:
```cmd
java -version
javac -version
```

### 2. Download JavaFX SDK

Download [JavaFX SDK 25+](https://gluonhq.com/products/javafx/) and extract it to the project directory:
```
HostelApp/javafx/javafx-sdk-25.0.1/
```

### 3. Install MySQL

Download and install [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)

### 4. Download MySQL Connector

Download [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) and place the JAR file in the `lib/` folder:
```
HostelApp/lib/mysql-connector-j-9.5.0.jar
```

---

## 🗄️ Database Setup

Open MySQL Workbench or MySQL command line and run:
```sql
DROP DATABASE IF EXISTS hostel;
CREATE DATABASE hostel;
USE hostel;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(20),
    course VARCHAR(50)
);

-- Sample data (optional)
INSERT INTO students (name, phone, course) VALUES
('Alice', '123456789', 'Computer Science'),
('Bob', '987654321', 'Engineering'),
('Carol', '555666777', 'Mathematics'),
('David', '444555666', 'Physics'),
('Eve', '111222333', 'Chemistry'),
('Frank', '999888777', 'Biology'),
('Grace', '222333444', 'Economics');
```

### Configure Database Connection

In `src/connector/DBConnector.java`, update the database credentials:
```java
String url = "jdbc:mysql://localhost:3306/hostel?useSSL=false&allowPublicKeyRetrieval=true";
String user = "root";
String pass = ""; // Replace with your MySQL password
```

---

## 🚀 How to Compile and Run

### Compile
```cmd
javac --module-path "javafx/javafx-sdk-25.0.1/lib" --add-modules javafx.controls,javafx.fxml -cp "lib/mysql-connector-j-9.5.0.jar" -d out src\connector\DBConnector.java src\app\Main.java
```

### Run
```cmd
java --module-path "javafx/javafx-sdk-25.0.1/lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -cp "out;lib/mysql-connector-j-9.5.0.jar" app.Main
```

---

## 💡 Usage

1. **Start MySQL Server** - Ensure MySQL is running on port 3306
2. **Compile the Application** - Run the compile command above
3. **Run the Application** - Execute the run command above
4. **Add Students** - Fill in Name, Phone, and Course fields, then click "Add Student"
5. **Update Students** - Select a student from the table, modify the fields, and click "Update Selected"
6. **Delete Students** - Select a student from the table and click "Delete Selected"
7. **Refresh Table** - Click "Refresh" to reload data from the database

---

## 🐛 Troubleshooting

### Application won't start
- Verify MySQL Server is running: `mysql -u root -p`
- Check database credentials in `DBConnector.java`
- Ensure `hostel` database exists

### Compilation errors
- Verify JavaFX SDK path is correct
- Check Java version: `java -version` (should be 21+)
- Ensure all JAR files are in the correct locations

### Database connection errors
- Test MySQL connection: `mysql -u root -p`
- Verify port 3306 is not blocked by firewall
- Check MySQL user permissions

---

## 📚 Learning Resources

This project is designed for beginners learning:
- JavaFX TableView, Buttons, and event handling
- JDBC and database connectivity
- Prepared statements to prevent SQL injection
- Basic CRUD operations (Create, Read, Update, Delete)
- Project structure with separate packages

---

## 🔮 Future Improvements

- [ ] Enhanced UI styling with CSS for modern look
- [ ] Search/filter students by name, phone, or course
- [ ] Input validation and error handling
- [ ] Pagination for large datasets
- [ ] Export data to CSV/PDF
- [ ] Room allocation feature
- [ ] Fee management system
- [ ] Attendance tracking
- [ ] Student photo upload
- [ ] Email notifications
- [ ] Backup and restore database
- [ ] Multi-user authentication
- [ ] Reports and analytics dashboard

---
**⭐ If you find this project helpful, please give it a star!**

**Happy Coding! 🚀**
