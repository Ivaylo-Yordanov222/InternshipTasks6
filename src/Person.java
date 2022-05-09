public class Person {
    private final String firstName;
    private final String lastName;

    protected String occupation;

    public Person(String firstName, String lastName) {
        this.ValidateName(firstName,"firstName");
        this.firstName = firstName;
        this.ValidateName(lastName,"lastName");
        this.lastName = lastName;
    }
    @Override
    public String toString(){
        return "First name: " + firstName+"\n"
                +"Last name: " + lastName + "\n";
    }
    private void ValidateName(String name, String parameterName){
        if(name.length() < 2 || name.length() > 30){
            throw new IllegalStateException("Expected length for "+parameterName+" is between 2 and 30 symbols.");
        }
        if(!name.matches("[a-zA-Z]+")){
            throw new IllegalStateException("Expected only Latin letters in " + parameterName +".");
        }
        if(!Character.isUpperCase(name.charAt(0))){
            throw new IllegalStateException("Expected upper case letter at first position of "+ parameterName +".");
        }
    }
}
