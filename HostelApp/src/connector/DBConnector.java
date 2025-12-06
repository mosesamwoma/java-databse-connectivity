package connector;

import app.Main.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConnector {

    private static final String url = "jdbc:mysql://localhost:3306/hostel?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String pass = "";

    // Insert student
    public static void insertStudent(String name, String phone, String course) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn
                        .prepareStatement("INSERT INTO students(name, phone, course) VALUES (?, ?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, course);
            ps.executeUpdate();
        }
    }

    // Delete student by ID
    public static boolean deleteStudent(int id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    // Update student by ID
    public static boolean updateStudent(int id, String name, String phone, String course) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn
                        .prepareStatement("UPDATE students SET name=?, phone=?, course=? WHERE id=?")) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, course);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    // Get all students
    public static ObservableList<Student> getAllStudents() throws SQLException {
        ObservableList<Student> list = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("course")));
            }
        }
        return list;
    }
}
