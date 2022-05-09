import java.util.List;
public class AdministrationEmployee extends Employee{
    private final List<String> subjectsToAdministrate;

    public AdministrationEmployee(String name, String phone, List<String> subjectsToAdministrate) {
        super(name, phone);
        this.subjectsToAdministrate = subjectsToAdministrate;
        super.setSalaryPerHour(19);
    }
}
