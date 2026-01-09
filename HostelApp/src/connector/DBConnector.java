package connector;

import app.Main; // Import Main class
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class DBConnector {

    private static final String URL = "jdbc:sqlite:hostel.db";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void insertStudent(String name, String phone, String course) throws SQLException {
        String sql = "INSERT INTO students(name, phone, course) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, course);
            ps.executeUpdate();
        }
    }

    public static boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public static boolean updateStudent(int id, String name, String phone, String course) throws SQLException {
        String sql = "UPDATE students SET name = ?, phone = ?, course = ? WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, course);
            ps.setInt(4, id);
            return ps.executeUpdate() > 0;
        }
    }

    public static ObservableList<Main.Student> getAllStudents() throws SQLException {
        ObservableList<Main.Student> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM students";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Main.Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("course")));
            }
        }
        return list;
    }
}
