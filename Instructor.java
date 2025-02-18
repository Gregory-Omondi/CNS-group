public class Instructor extends Person {
    String inID;

    public Instructor(String name, String email, String inID) {
        super(name, email);
        this.inID = inID;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Instructor ID: " + inID);
    }

}