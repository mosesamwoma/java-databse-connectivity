package connector;

import java.sql.*;

public class DBConnector {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hostel";
        String user = "root";
        String password = "";

        String query = "SELECT * FROM students";

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("✅ Connected to hostel database successfully!");

            if (!rs.isBeforeFirst()) {
                System.out.println("❌ No students found!");
            } else {
                System.out.println("Students in hostel:");
                while (rs.next()) {
                    System.out.printf("%d | %s | %s | %s%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("course"));
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Database error!");
            e.printStackTrace();
        }
    }
}
