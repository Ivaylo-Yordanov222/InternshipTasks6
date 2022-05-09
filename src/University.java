import java.util.ArrayList;
import java.util.List;
public class University {
    private double balance = 500;
    private final List<Person> personal = new ArrayList<>();

    public double getBalance() {
        return balance;
    }
    private void setBalance(double balance) {
        this.balance = balance;
        if(balance <= 0){
            throw new IllegalStateException("Bankrupcy");
        }
    }

    public List<Person> getPersonal() {
        return personal;
    }

    public void increaseBalance(int amount){
        setBalance(balance + amount);
    }
    public void decreaseBalance(int amount){
        setBalance(balance - amount);
    }
}
