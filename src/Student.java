import java.util.List;

public class Student extends Person{
    private final String facultyNumber;

    private final List<String> subjects;

    public Student(String name, String phone,String facultyNumber, List<String>subjects) {
        super(name, phone);
        this.facultyNumber = facultyNumber;
        this.subjects = subjects;
    }

}
