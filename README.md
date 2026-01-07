# Hostel Management System (SQLite Version)

A beginner-friendly JavaFX application for managing hostel students with full CRUD operations. All data is stored in a **SQLite database** with JDBC integration.

![JavaFX](https://img.shields.io/badge/JavaFX-25+-blue)
![SQLite](https://img.shields.io/badge/SQLite-3.5+-orange)
![Java](https://img.shields.io/badge/Java-21+-red)
![License](https://img.shields.io/badge/License-MIT-green)

---

## 📋 Features

- ✅ **Add** new students (Name, Phone, Course)
- ✅ **Update** existing student details
- ✅ **Delete** students from database
- ✅ **Display** students in a TableView
- ✅ **Auto-refresh** table after operations
- ✅ Beginner-friendly code structure

---

## 🗂️ Project Structure

```
HostelApp/
│
├── src/
│   ├── app/
│   │   └── Main.java              # Main application entry point
│   ├── connector/
│   │   └── DBConnector.java       # Database connection handler
│   └── model/
│       └── Student.java           # Student model class
│
├── lib/
│   └── sqlite-jdbc-3.51.1.0.jar   # SQLite JDBC driver
│
├── javafx/
│   └── javafx-sdk-25.0.1/         # JavaFX SDK
│       └── lib/
│
├── out/                            # Compiled classes (auto-generated)
├── hostel.db                       # SQLite database file
└── README.md                       # Project documentation
```

---

## 🛠️ Requirements

- **Java 21+** (JDK)
- **JavaFX SDK 25+**
- **SQLite JDBC Driver** (`sqlite-jdbc-3.51.1.0.jar`)
- **Windows OS** (PowerShell commands provided)
- **IDE** (Optional): VS Code, IntelliJ IDEA, or Eclipse

---

## 📦 Installation & Setup

### 1️⃣ Install Java

Download [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/) and verify:

```cmd
java -version
javac -version
```

### 2️⃣ Download JavaFX SDK

Download [JavaFX SDK 25+](https://gluonhq.com/products/javafx/) and extract to:

```
HostelApp/javafx/javafx-sdk-25.0.1/
```

### 3️⃣ Download SQLite JDBC Driver

Download [SQLite JDBC](https://github.com/xerial/sqlite-jdbc/releases) and place in:

```
HostelApp/lib/sqlite-jdbc-3.51.1.0.jar
```

### 4️⃣ Create SQLite Database

Open **PowerShell** in your project folder:

```powershell
cd "C:\Path\To\Your\HostelApp"
```

Create the database and table:

```powershell
sqlite3 hostel.db
```

Inside SQLite shell:

```sql
CREATE TABLE students (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    phone TEXT NOT NULL,
    course TEXT NOT NULL
);
.exit
```

**Alternative**: Use [DB Browser for SQLite](https://sqlitebrowser.org/) GUI to create the database visually.

---

## 🚀 Compile & Run

### Compile

Open **PowerShell** in project root:

```powershell
javac --module-path "javafx\javafx-sdk-25.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp "lib\sqlite-jdbc-3.51.1.0.jar" -d out (Get-ChildItem -Recurse -Filter *.java).FullName
```

### Run

```powershell
java --module-path "javafx\javafx-sdk-25.0.1\lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics -cp "out;lib\sqlite-jdbc-3.51.1.0.jar" app.Main
```

---

## 💡 Usage Guide

1. **Launch Application** - Run the command above
2. **Add Student** - Fill Name, Phone, Course fields → Click **"Insert"**
3. **Update Student** - Enter Student ID + new details → Click **"Update"**
4. **Delete Student** - Enter Student ID → Click **"Delete"**
5. **View Students** - TableView displays all students automatically

---

## 🔧 Database Configuration

The database connection is configured in `src/connector/DBConnector.java`:

```java
private static final String URL = "jdbc:sqlite:hostel.db";
```

- **No username/password required** for SQLite
- Database file: `hostel.db` (in project root)
- Automatically connects when app runs

---

## 🐛 Troubleshooting

### Database Errors

✅ Ensure `hostel.db` exists in project root  
✅ Verify table exists:

```powershell
sqlite3 hostel.db
sqlite> .tables
students
sqlite> .exit
```

### Compilation Errors

✅ Check JavaFX SDK path is correct  
✅ Verify SQLite JDBC JAR is in `lib/` folder  
✅ Confirm Java version:

```cmd
java -version
```

### Runtime Errors

✅ Ensure `out/` directory exists  
✅ Check all `.java` files are in correct packages  
✅ Verify module path points to JavaFX `lib` folder

---

## 📚 Code Overview

### Main.java
- JavaFX UI with TextFields and TableView
- CRUD operation buttons
- Auto-refresh after database operations

### DBConnector.java
- Singleton pattern for database connection
- Connection pooling to SQLite database
- Error handling for failed connections

### Student.java
- Model class with properties: id, name, phone, course
- JavaFX properties for TableView binding

---

## 🔮 Future Enhancements

- [ ] 🎨 Enhanced UI styling with CSS
- [ ] 🔍 Search/filter students by name or course
- [ ] 📄 Export data to CSV/PDF
- [ ] 🏠 Room allocation management
- [ ] 📷 Student photo upload
- [ ] 📧 Email notifications
- [ ] 📊 Reports and analytics dashboard
- [ ] 🔐 User authentication system

---

## 📄 License

This project is licensed under the **MIT License** - free to use and modify.

---

## 👨‍💻 Author

**Moses Tumbo**  
Beginner-friendly JavaFX + SQLite demonstration project

---

## ⭐ Quick Start Checklist

- [ ] Install Java 21+
- [ ] Download and extract JavaFX SDK
- [ ] Download SQLite JDBC JAR
- [ ] Create `hostel.db` with `students` table
- [ ] Compile project
- [ ] Run application
- [ ] Start managing students!

---

**Ready to run!** Clone this project, follow the setup steps, and start managing hostel students in minutes. Perfect for learning JavaFX with database integration.
