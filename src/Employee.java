public class Employee extends Person{
    private int salaryPerHour;

    public Employee(String name, String phone) {
        super(name, phone);
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    protected void setSalaryPerHour(int amount) {
        salaryPerHour += amount;
    }
}
