import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;

public class Main extends Application {

    TableView<Student> table = new TableView<>();
    ObservableList<Student> data = FXCollections.observableArrayList();
    TextField name = new TextField(), phone = new TextField(), course = new TextField();

    String url = "jdbc:mysql://localhost:3306/hostel?useSSL=false&allowPublicKeyRetrieval=true";
    String user = "root", pass = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        name.setPromptText("Name");
        phone.setPromptText("Phone");
        course.setPromptText("Course");
        Button add = new Button("Add");
        add.setOnAction(e -> addStudent());
        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Student, String> nCol = new TableColumn<>("Name");
        nCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, String> pCol = new TableColumn<>("Phone");
        pCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Student, String> cCol = new TableColumn<>("Course");
        cCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        TableColumn<Student, Void> delCol = new TableColumn<>("Delete");
        delCol.setCellFactory(tc -> new TableCell<>() {
            Button b = new Button("Del");
            {
                b.setOnAction(e -> deleteStudent(getTableView().getItems().get(getIndex()).id));
            }

            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : b);
            }
        });
        table.getColumns().addAll(idCol, nCol, pCol, cCol, delCol);
        table.setItems(data);
        VBox root = new VBox(name, phone, course, add, table);
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
        loadStudents();
    }

    void loadStudents() {
        data.clear();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next())
                data.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
                        rs.getString("course")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addStudent() {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn.prepareStatement("INSERT INTO students(name,phone,course) VALUES(?,?,?)")) {
            ps.setString(1, name.getText());
            ps.setString(2, phone.getText());
            ps.setString(3, course.getText());
            ps.executeUpdate();
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void deleteStudent(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Student {
        int id;
        String name, phone, course;

        Student(int i, String n, String p, String c) {
            id = i;
            name = n;
            phone = p;
            course = c;
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
