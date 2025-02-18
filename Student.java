import java.sql.*;
public class Student extends Person{
    int sID;

    public Student(String name, String email, int sID){
        super(name,email);
        this.sID = sID;
    }

    public int getSID(){
        return sID;
    }
    public void setSID(int sID){
        this.sID = sID;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Student Id: "+sID);

    }
}