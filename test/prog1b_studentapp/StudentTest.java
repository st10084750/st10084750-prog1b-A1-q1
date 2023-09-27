package prog1b_studentapp;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import prog1b_studentapp.Student;

public class StudentTest {

    @Test
    public void testGetStudentID() {
        // Create a test instance of the Student class
        Student student = new Student("12345", "John Doe", 20, "johndoe@example.com", "Math");

        // Call the getStudentID method and check if it returns the expected value
        String studentID = student.getStudentID();
        assertThat(studentID, is("12345"));
    }

    @Test
    public void testDisplayDetails() {
        // Create a test instance of the Student class
        Student student = new Student("12345", "John Doe", 20, "johndoe@example.com", "Math");

        // Redirect standard output to capture the printed details
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the displayDetails method
        student.displayDetails();

        // Restore the standard output
        System.setOut(System.out);

        // Check if the printed details match the expected output
        String expectedOutput = "Student ID: 12345\nName: John Doe\nAge: 20\nEmail: johndoe@example.com\nCourse: Math\n";
        assertThat(outContent.toString(), is(expectedOutput));
    }
}
