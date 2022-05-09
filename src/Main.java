import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String row;
        String[] command;
        String firstName,lastName,facultyNumber;
        String lectureCount, exerciseCount;
        double weekSalary, workHoursPerDay;
        while(!((row = scanner.nextLine()).trim().equals("END"))){
            command = row.trim().split(" ");
            firstName = command[0];
            lastName = command[1];
            if(command.length == 5){
                facultyNumber = command[2];
                lectureCount = command[3];
                exerciseCount = command[4];
                try{
                    Person student = new Student(firstName, lastName,facultyNumber, lectureCount,exerciseCount);
                    System.out.println(student);
                }catch (IllegalStateException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }
            else{
                weekSalary = Double.parseDouble(command[2]);
                workHoursPerDay = Double.parseDouble(command[3]);
                try{
                    Person worker = new Worker(firstName, lastName,weekSalary, workHoursPerDay);
                    System.out.println(worker);
                }catch (IllegalStateException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
    }
}