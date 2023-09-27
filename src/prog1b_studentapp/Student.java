package prog1b_studentapp;

public class Student {
    private String studentID;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String studentID, String name, int age, String email, String course) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public String getStudentID() {
        return studentID;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
    }

    Object getName() {
        throw new UnsupportedOperationException("Not supported yet.");
}   }


