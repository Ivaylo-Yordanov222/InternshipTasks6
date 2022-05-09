public class Worker extends Person {
    private final double weekSalary;
    private final double workHoursPerDay;
    private final double salaryPerHour;
    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        validateSalaryAndWorkHours(weekSalary,"weekSalary");
        this.weekSalary = weekSalary;
        validateSalaryAndWorkHours(workHoursPerDay,"workHoursPerDay");
        this.workHoursPerDay = workHoursPerDay;
        super.occupation = "Worker";
        this.salaryPerHour = weekSalary/(5 * workHoursPerDay);
    }
    @Override
    public String toString(){
        return super.toString() + "Occupation: " + occupation +"\n"
                + "Week salary: "+ weekSalary +"\n"
                + "Hours per day: "+ workHoursPerDay +"\n"
                + "Salary per hour: " + salaryPerHour;
    }


    private  void validateSalaryAndWorkHours(double number,String parameterName){
        if( number < 0){
            throw new IllegalStateException("Expected positive number for "+ parameterName+ ".");
        }
    }
}

