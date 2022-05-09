public class Student extends Person {
    private final String facultyNumber;
    private final int lectureCount;
    private final int exerciseCount;

    private final double hoursPerDay;

    public Student(String firstName, String lastName, String facultyNumber, String lectureCount, String exerciseCount) {
        super(firstName, lastName);
        this.validateFacultyNumber(facultyNumber);
        this.facultyNumber = facultyNumber;
        this.lectureCount = this.validateLectureAndExerciseTypeAndIsPositive(lectureCount, "lectureCount");
        this.exerciseCount = this.validateLectureAndExerciseTypeAndIsPositive(exerciseCount, "exerciseCount");
        super.occupation = "Student";
        this.hoursPerDay = (this.lectureCount*2 + this.exerciseCount * 1.5)/5;
    }
    @Override
    public String toString(){
        return super.toString() + "Occupation: " + occupation +"\n"
                + "Faculty number: "+ facultyNumber +"\n"
                + "Hours per day: " + hoursPerDay;
    }
    private void validateFacultyNumber(String facultyNumber){
        if(facultyNumber.length() < 5 || facultyNumber.length()> 10){
            throw new IllegalStateException("Expected length for faculty number is between 5 and 10 symbols.");
        }
    }
    private int validateLectureAndExerciseTypeAndIsPositive(String number, String parameterName){
        int result;
        try{
            result = Integer.parseInt(number);
            if(result < 0){
                throw new IllegalStateException("Expected positive number for "+parameterName+".");
            }
            return result;
        }catch (NumberFormatException e){
            throw new IllegalStateException("Expected integer for "+parameterName+".");
        }
    }
}
