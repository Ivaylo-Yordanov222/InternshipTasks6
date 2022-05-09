public class Person {
    private final String name;
    private final String phone;
    private int toleranceThreshold = 20;
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public int getToleranceThreshold() {
        return toleranceThreshold;
    }

    protected void setToleranceThreshold(int toleranceThreshold) {
        this.toleranceThreshold = toleranceThreshold;
        if(toleranceThreshold <= 0){
            throw new IllegalStateException(name +" is not happy.");
        }
    }

    public String getName() {
        return name;
    }

    public void increase(int amount){
       this.setToleranceThreshold(this.getToleranceThreshold() + amount);
    }

    public void decrease(int amount){
        this.setToleranceThreshold(this.getToleranceThreshold() - amount);
    }
    public void decreaseToleranceToAll(){
        this.setToleranceThreshold(this.toleranceThreshold - 5);
    }
}
