# Hostel Management System (MySQL Version)

A beginner-friendly JavaFX application for managing hostel students with full CRUD operations. All data is stored in a **MySQL database** with JDBC integration using **XAMPP**.

![JavaFX](https://img.shields.io/badge/JavaFX-25+-blue) ![MySQL](https://img.shields.io/badge/MySQL-8.0+-orange) ![Java](https://img.shields.io/badge/Java-21+-red) ![XAMPP](https://img.shields.io/badge/XAMPP-8.2+-yellow) ![License](https://img.shields.io/badge/License-MIT-green)

---

## 📋 Features

- ✅ **Add** new students (Name, Phone, Course)
- ✅ **Update** existing student details
- ✅ **Delete** students from database
- ✅ **Display** students in a TableView
- ✅ Beginner-friendly code structure
- ✅ Uses XAMPP for easy MySQL management

---

## 🛠️ Requirements

- **Java 21+** (JDK)
- **JavaFX SDK 25+**
- **XAMPP** (includes MySQL Server & phpMyAdmin)
- **MySQL JDBC Driver** (`mysql-connector-j-9.6.0.jar`)
- **Windows OS** (PowerShell commands provided)
- **IDE** (Optional): VS Code, IntelliJ IDEA, or Eclipse

---

## 📚 Understanding JDBC Workflow

JDBC (Java Database Connectivity) follows a specific sequence of steps to interact with databases. Every database operation in this application follows these steps:

### The 7 Essential JDBC Steps

1. **Import JDBC packages**
2. **Load and register database driver**
3. **Establish database connection**
4. **Create statement object**
5. **Execute SQL query or update**
6. **Process ResultSet (if any)**
7. **Close ResultSet, Statement, and Connection**

**Note:** This project implements these steps in `DBConnector.java` for connection management

---

## 📦 Installation & Setup

### 1️⃣ Install Java

Download [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/) and verify:

```cmd
java -version
javac -version
```

### 2️⃣ Install XAMPP

1. Download [XAMPP](https://www.apachefriends.org/download.html) (get the latest version)
2. Run the installer
3. Install to default location: `C:\xampp`
4. During installation, make sure **MySQL** is selected
5. After installation, open **XAMPP Control Panel**
6. Click **Start** next to **Apache** and **MySQL**

**Important:** Keep XAMPP Control Panel open while developing. You need MySQL running for the application to work.

### 3️⃣ Download JavaFX SDK

Download [JavaFX SDK 25+](https://gluonhq.com/products/javafx/) and extract to:

```
HostelApp/javafx/javafx-sdk-25.0.1/
```

### 4️⃣ Download MySQL JDBC Driver

Download [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) and place in:

```
HostelApp/lib/mysql-connector-j-9.6.0.jar
```

**Direct link:** Get the Platform Independent ZIP, extract, and copy the JAR file to `lib/` folder.

**Note:** Make sure the version number in your commands matches the actual JAR filename (e.g., `9.6.0`).

### 5️⃣ Navigate to Project Directory

Open **PowerShell** and navigate to your project folder:

```powershell
cd HostelApp
```

### 6️⃣ Setup Database with phpMyAdmin

**Using phpMyAdmin (comes with XAMPP)**

1. Make sure **MySQL** is running in XAMPP Control Panel (green status)
2. Open your browser and go to: `http://localhost/phpmyadmin`
3. Click **New** in the left sidebar
4. Enter database name: `hostel_db`
5. Click **Create**
6. Click on `hostel_db` in the left sidebar to select it
7. Click the **SQL** tab at the top
8. Paste this SQL code:

```sql
-- Create students table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20),
    course VARCHAR(100)
);
```

9. Click **Go** button to execute
10. Click on `hostel_db` in the left sidebar - you should see the `students` table

**Note:** XAMPP's MySQL uses passwordless root access by default, which simplifies development setup.

---

## 🧪 Test Database Connection

Before running the full application, test your database connection using the file located at `HostelApp\src\connector\DBConnector.java`:

### Navigate to Project Directory
```powershell
cd HostelApp
```

### Compile DBConnector
```powershell
javac -cp ".;lib/mysql-connector-j-9.6.0.jar" src\connector\DBConnector.java
```

### Run Connection Test
```powershell
java -cp ".;lib/mysql-connector-j-9.6.0.jar;src" connector.DBConnector
```

**Note:** This runs the `main()` method in `HostelApp\src\connector\DBConnector.java` to verify your database connection works before launching the full JavaFX application.

**Expected Output:**
```
Testing MySQL Database Connection...
=====================================

Database connected successfully!
Connection established successfully!

Executing query: SELECT * FROM students
-------------------------------------

ID      Name                    Phone           Course
==============================================================
1       John Doe                0712345678      Computer Science
2       Jane Smith              0723456789      Business Administration

=====================================
Database test completed successfully!
Connection closed.
```

### Troubleshooting Test Connection

**Error: "ClassNotFoundException: com.mysql.cj.jdbc.Driver"**
- Make sure `mysql-connector-j-9.6.0.jar` is in the `lib/` folder
- Check the JAR filename matches exactly (version number)

**Error: "Access denied for user"**
- Check that your MySQL is configured for passwordless root access
- Or update `DBConnector.java` to use your MySQL credentials

**Error: "Communications link failure"**
- Ensure MySQL is running in XAMPP Control Panel (should be green)
- Check if MySQL is on port 3306 (default for XAMPP)
- Click "Stop" then "Start" on MySQL in XAMPP to restart it

**"No students found in the database"**
- This is normal if table is empty
- Add test data using phpMyAdmin Insert tab

---

## 🚀 Compile & Run JavaFX Application

### Compile Main.java Directly

In **PowerShell** (inside `HostelApp` directory):

**Compile Main.java:**
```powershell
javac --module-path "javafx\javafx-sdk-25.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp ".;lib/mysql-connector-j-9.6.0.jar" src\app\Main.java
```

**Run application:**
```powershell
java --module-path "javafx\javafx-sdk-25.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp ".;lib/mysql-connector-j-9.6.0.jar;src" app.Main
```

**Note:** This compiles only `Main.java` directly from the `src` folder. This is faster for quick testing but requires all Java files to be in the `src` directory structure.

---


---

## 🐛 Troubleshooting

### Connection Errors

✅ **Check XAMPP MySQL is running**
- Open XAMPP Control Panel
- MySQL should show green status
- If red, click "Start" button

✅ **Verify database and table exist in phpMyAdmin**
- Go to `http://localhost/phpmyadmin`
- Check if `hostel_db` database exists in the left sidebar
- Check if `students` table exists under `hostel_db`

### Common Error Messages

**Error: "Unknown database 'hostel_db'"**
- Database not created: Create it in phpMyAdmin
- Follow the Setup Database section above

**"Communications link failure"**
- MySQL not running: Start it in XAMPP Control Panel
- Wrong port: XAMPP uses port 3306 by default
- Port conflict: Check if another program is using port 3306

**"ClassNotFoundException: com.mysql.cj.jdbc.Driver"**
- MySQL JDBC driver not in classpath
- Verify `mysql-connector-j-*.jar` is in `lib/` folder
- Check compile/run commands include the JAR

### Compilation Errors

✅ Check JavaFX SDK path is correct  
✅ Verify MySQL JDBC JAR is in `lib/` folder  
✅ Confirm Java version: `java -version`

### Runtime Errors

✅ Check all `.java` files are in correct packages  
✅ Verify module path points to JavaFX `lib` folder  
✅ **Confirm XAMPP MySQL is running**

### XAMPP Specific Issues

**MySQL won't start in XAMPP:**
- Port 3306 might be in use by another MySQL installation
- Check Windows Services and stop other MySQL services
- Try changing MySQL port in XAMPP config (click Config → my.ini)

**phpMyAdmin not loading:**
- Make sure both Apache and MySQL are running
- Check if you can access `http://localhost` first

---

## 🔮 Future Enhancements

- [ ] Enhanced UI styling with CSS
- [ ] Search/filter students functionality
- [ ] Room allocation management
- [ ] User authentication system

---

## 👨‍💻 Author

**Moses Tumbo**

Production-ready JavaFX + MySQL demonstration project
