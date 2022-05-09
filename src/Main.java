import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static University university = new University();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String row;
        String[] commandLine;

        while(!((row = scanner.nextLine()).trim().equals("END"))){
            commandLine = row.trim().split(" ");
            String command = commandLine[0];
            switch (command){
                case "NEW": insertNewPerson(commandLine);
                break;
                case "WORK":
                    try{
                        personWork(commandLine);
                    }catch (IllegalStateException e){
                        System.out.println();
                        System.out.println(e.getMessage());
                        return;
                    }
                    break;
                case "IDLE":
                    try{
                        idle();
                    }catch (IllegalStateException e){
                        System.out.println();
                        System.out.println(e.getMessage());
                        return;
                    }
                    break;
            }
        }
        for(Person p : university.getPersonal()){
            System.out.println(p.getName() + ": "+p.getToleranceThreshold());
        }
        System.out.println("Balance: " + university.getBalance());
    }

    private static void idle() {
        for(Person p : university.getPersonal()){
            p.decreaseToleranceToAll();
        }
    }

    private static void personWork(String[] commandLine) {
        String name = commandLine[1];
        Person person = findPerson(name);
        if(person instanceof Student){
            if(person.getToleranceThreshold() > 50){
                university.increaseBalance(10);
            }
            for (Person p : university.getPersonal()){
                if(p instanceof Student){
                    p.increase(2);
                }else if(p instanceof MaintenanceEmployee){
                    p.decrease(1);
                }
            }
        }else if(person instanceof Employee){
            university.decreaseBalance(((Employee) person).getSalaryPerHour());
            if(person instanceof MaintenanceEmployee){
                for(Person p : university.getPersonal()){
                    p.increase(2);
                }
            }else if(person instanceof Teacher){
                for (Person p: university.getPersonal()){
                    if(p instanceof Student){
                        p.increase(3);
                    }else if(p instanceof MaintenanceEmployee){
                        p.decrease(3);
                    }else if(p instanceof AdministrationEmployee){
                        p.decrease(1);
                    }
                }
            }else{
                for(Person p: university.getPersonal()){
                    if(p instanceof Student || p instanceof Teacher){
                        p.increase(3);
                    }else if(p instanceof MaintenanceEmployee){
                        p.increase(1);
                    }
                }
            }
        }
    }

    private static void insertNewPerson(String[] commandLine) {
        String name, phoneNumber;
        String personType = commandLine[1];
        Person person;
        switch (personType){
            case "STUD":
                name = commandLine[2];
                phoneNumber = commandLine[3];
                String facultyNumber = commandLine[4];
                List<String> subjects = new ArrayList<>();
                fillSubjects(subjects,commandLine, 5);
                person = new Student(name,phoneNumber,facultyNumber,subjects);
                university.getPersonal().add(person);
                break;
            case "TEACH":
                name = commandLine[2];
                phoneNumber = commandLine[3];
                List<String> subjectsToTeach = new ArrayList<>();
                fillSubjects(subjectsToTeach, commandLine, 4);
                person = new Teacher(name,phoneNumber,subjectsToTeach);
                university.getPersonal().add(person);
                break;
            case "ADMIN":
                name = commandLine[2];
                phoneNumber = commandLine[3];
                List<String> subjectToAdministrate = new ArrayList<>();
                fillSubjects(subjectToAdministrate, commandLine, 4);
                person = new AdministrationEmployee(name,phoneNumber,subjectToAdministrate);
                university.getPersonal().add(person);
                break;
            case "MAINT":
                name = commandLine[2];
                phoneNumber = commandLine[3];
                person = new MaintenanceEmployee(name,phoneNumber);
                university.getPersonal().add(person);
        }
    }

    private static void fillSubjects(List<String> subjects, String[] rowOfSubjects, int index){
        for (int i = index; i< rowOfSubjects.length; i++){
            subjects.add(rowOfSubjects[i]);
        }
    }

    private static Person findPerson(String pName){
        Person searchPerson = null;
        for (Person p : university.getPersonal()){
            if(p.getName().equals(pName)){
                searchPerson = p;
                break;
            }
        }
        return searchPerson;
    }
}