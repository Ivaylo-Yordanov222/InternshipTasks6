import java.util.List;

public class Teacher extends Employee{
    private final List<String> subjectToTeach;

    public Teacher(String name, String phone, List<String> subjectToTeach) {
        super(name, phone);
        this.subjectToTeach = subjectToTeach;
        super.setSalaryPerHour(25);
    }
}
