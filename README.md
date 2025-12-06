# Hostel Management System

A beginner-friendly JavaFX application for managing hostel students. Users can **add** and **delete** students, with all data stored in a MySQL database. This project demonstrates how to connect a JavaFX GUI with a database using JDBC.

![JavaFX](https://img.shields.io/badge/JavaFX-25+-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-orange)
![Java](https://img.shields.io/badge/Java-21+-red)
![License](https://img.shields.io/badge/License-MIT-green)

---

## 📋 Features

- ✅ Add new students (Name, Phone, Course)
- ✅ Delete students from database
- ✅ Display students in a TableView
- ✅ Refresh table to reload data
- ✅ Beginner-friendly code for learning JavaFX + MySQL integration

---

## 🛠️ Requirements

- **Java 21+** (JDK)
- **JavaFX SDK 25+**
- **MySQL Server 8.0+** (default port `3306`)
- **MySQL Connector/J** (e.g., `mysql-connector-j-9.5.0.jar`)
- Optional: **VS Code**, **IntelliJ IDEA**, or **Eclipse**

---

## 📦 Installation & Setup

### 1. Install Java and JavaFX

Download and install:
- [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/)
- [JavaFX SDK 25+](https://gluonhq.com/products/javafx/)

### 2. Install MySQL

Download and install [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)

### 3. Download MySQL Connector

Download [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) and place the JAR file in a `lib` folder in your project directory.

---

## 🗄️ Database Setup

Open MySQL Workbench or MySQL command line and run:

```sql
DROP DATABASE IF EXISTS hostel;
CREATE DATABASE hostel;
USE hostel;

CREATE TABLE students(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20),
    course VARCHAR(50)
);
```

### Configure Database Connection

In `Main.java`, update the database credentials:

```java
String url = "jdbc:mysql://localhost:3306/hostel?useSSL=false&allowPublicKeyRetrieval=true";
String user = "root";
String pass = ""; // Replace with your MySQL password
```

---

## 🚀 How to Compile and Run

### Windows

**Compile:**
```cmd
javac --module-path "C:\path\to\javafx-sdk-25.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp ".;lib\mysql-connector-j-9.5.0.jar" Main.java
```

**Run:**
```cmd
java --module-path "C:\path\to\javafx-sdk-25.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp ".;lib\mysql-connector-j-9.5.0.jar" Main
```

### Linux/Mac

**Compile:**
```bash
javac --module-path "/path/to/javafx-sdk-25.0.1/lib" --add-modules javafx.controls,javafx.fxml -cp ".:lib/mysql-connector-j-9.5.0.jar" Main.java
```

**Run:**
```bash
java --module-path "/path/to/javafx-sdk-25.0.1/lib" --add-modules javafx.controls,javafx.fxml -cp ".:lib/mysql-connector-j-9.5.0.jar" Main
```

---

## 💡 Usage

1. **Start MySQL Server** - Ensure MySQL is running on port 3306
2. **Run the Application** - Execute the run command above
3. **Add Students** - Fill in Name, Phone, and Course fields, then click "Add Student"
4. **Delete Students** - Select a student from the table and click "Delete Selected"
5. **Refresh Table** - Click "Refresh" to reload data from the database

---

## 📝 Notes

- Keep JavaFX SDK path consistent when compiling and running
- Ensure MySQL server is running before starting the application
- The application uses prepared statements to prevent SQL injection
- Ideal for beginners learning TableView, Buttons, and event handling in JavaFX
- Default MySQL password is empty (`""`), change it in the code if needed

---

## 🔮 Future Improvements

- [ ] Edit/Update student information
- [ ] Enhanced refresh table button
- [ ] Search/filter students by name, phone, or course
- [ ] UI styling with CSS for modern look
- [ ] Separate UI and Database logic into different classes
- [ ] Input validation and error handling
- [ ] Export data to CSV/PDF
- [ ] Room allocation feature
- [ ] Fee management system

---

## 📄 License

This project is licensed under the MIT License - see below for details.

```
MIT License

Copyright (c) 2025 [Your Name]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 🙏 Acknowledgments

- JavaFX documentation and community
- MySQL Connector/J documentation
- Open source community for inspiration

---

## 📞 Support

If you encounter any issues or have questions:

1. Check the [Issues](https://github.com/yourusername/hostel-management/issues) page
2. Create a new issue with detailed information
3. Contact the maintainer

---

**⭐ If you find this project helpful, please give it a star!**
