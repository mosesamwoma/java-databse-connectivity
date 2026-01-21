package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    TextField idField = new TextField();
    TextField nameField = new TextField();
    TextField phoneField = new TextField();
    TextField courseField = new TextField();
    TableView<Student> table = new TableView<>();

    private static final String URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        idField.setPromptText("ID (for update/delete)");
        nameField.setPromptText("Name");
        phoneField.setPromptText("Phone");
        courseField.setPromptText("Course");

        Button insertBtn = new Button("Insert");
        insertBtn.setOnAction(e -> {
            try {
                insertStudent(nameField.getText(), phoneField.getText(), courseField.getText());
                showAlert("Insert Successful");
                loadStudents();
            } catch (Exception ex) {
                showAlert("Insert Failed: " + ex.getMessage());
            }
        });

        Button updateBtn = new Button("Update");
        updateBtn.setOnAction(e -> {
            try {
                boolean success = updateStudent(Integer.parseInt(idField.getText()),
                        nameField.getText(), phoneField.getText(), courseField.getText());
                showAlert(success ? "Update Successful" : "No student found with that ID");
                loadStudents();
            } catch (Exception ex) {
                showAlert("Update Failed: " + ex.getMessage());
            }
        });

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> {
            try {
                boolean success = deleteStudent(Integer.parseInt(idField.getText()));
                showAlert(success ? "Delete Successful" : "No student found with that ID");
                loadStudents();
            } catch (Exception ex) {
                showAlert("Delete Failed: " + ex.getMessage());
            }
        });

        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Student, String> courseCol = new TableColumn<>("Course");
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        table.getColumns().addAll(idCol, nameCol, phoneCol, courseCol);

        VBox root = new VBox(10, idField, nameField, phoneField, courseField, insertBtn, updateBtn, deleteBtn, table);

        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("HostelApp - CRUD Viewer");
        stage.show();

        loadStudents();
    }

    public ObservableList<Student> getAllStudents() throws SQLException {
        ObservableList<Student> list = FXCollections.observableArrayList();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = con.createStatement();
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

    public void insertStudent(String name, String phone, String course) throws SQLException {
        String query = "INSERT INTO students (name, phone, course) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, course);
            ps.executeUpdate();
        }
    }

    public boolean updateStudent(int id, String name, String phone, String course) throws SQLException {
        String query = "UPDATE students SET name=?, phone=?, course=? WHERE id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, course);
            ps.setInt(4, id);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    void loadStudents() {
        try {
            table.setItems(getAllStudents());
        } catch (SQLException e) {
            showAlert("Failed to load students: " + e.getMessage());
        }
    }

    void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static class Student {
        private int id;
        private String name;
        private String phone;
        private String course;

        public Student(int id, String name, String phone, String course) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.course = course;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getCourse() {
            return course;
        }
    }
}
