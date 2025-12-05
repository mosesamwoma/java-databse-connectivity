public class Student {

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
