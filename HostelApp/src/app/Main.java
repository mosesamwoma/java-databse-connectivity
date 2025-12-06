package app;

import connector.DBConnector;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    TextField nameField = new TextField();
    TextField phoneField = new TextField();
    TextField courseField = new TextField();
    TextField idField = new TextField();

    TableView<Student> table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        nameField.setPromptText("Name");
        phoneField.setPromptText("Phone");
        courseField.setPromptText("Course");
        idField.setPromptText("ID (for update/delete)");

        // Buttons
        Button insertBtn = new Button("Insert");
        insertBtn.setOnAction(e -> {
            try {
                DBConnector.insertStudent(nameField.getText(), phoneField.getText(), courseField.getText());
                showAlert("Insert Successful");
                loadStudents();
            } catch (Exception ex) {
                showAlert("Insert Failed: " + ex.getMessage());
            }
        });

        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(e -> {
            try {
                boolean success = DBConnector.deleteStudent(Integer.parseInt(idField.getText()));
                showAlert(success ? "Delete Successful" : "No student found with that ID");
                loadStudents();
            } catch (Exception ex) {
                showAlert("Delete Failed: " + ex.getMessage());
            }
        });

        Button updateBtn = new Button("Update");
        updateBtn.setOnAction(e -> {
            try {
                boolean success = DBConnector.updateStudent(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        phoneField.getText(),
                        courseField.getText());
                showAlert(success ? "Update Successful" : "No student found with that ID");
                loadStudents();
            } catch (Exception ex) {
                showAlert("Update Failed: " + ex.getMessage());
            }
        });

        // TableView setup
        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Student, String> courseCol = new TableColumn<>("Course");
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        table.getColumns().addAll(idCol, nameCol, phoneCol, courseCol);

        // Layout
        VBox root = new VBox(10, nameField, phoneField, courseField, idField, insertBtn, deleteBtn, updateBtn, table);
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("HostelApp - CRUD Viewer");
        stage.show();

        // Load initial data
        loadStudents();
    }

    // Load students from DB into table
    void loadStudents() {
        try {
            ObservableList<Student> students = DBConnector.getAllStudents();
            table.setItems(students);
        } catch (Exception e) {
            showAlert("Failed to load students: " + e.getMessage());
        }
    }

    void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Inner class for table
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
