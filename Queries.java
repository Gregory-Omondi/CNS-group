import java.sql.*;
import java.util.ArrayList;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;

public class Queries {

    public static void getCourses(){  //Gets the courses from the Courses table in our Maria DB
        Connection conn =Database.connectDB() ;
        if(conn == null){
            System.out.println("No connection");
        }
        try(Statement statement= conn.createStatement();
            ResultSet result=statement.executeQuery("SELECT* FROM Courses")){

            while(result.next()){
               System.out.println("\nCourse ID: "+result.getString("course_id"));
               System.out.println("Course Name: "+result.getString("course_name"));
               System.out.println("Credits: "+result.getInt("credits"));
               System.out.println("Instructor: "+result.getString("instructor"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> getStudents(){// Gets all students from our Maria DB and stores them in a list
        Connection conn =Database.connectDB() ;
        if(conn== null){
            System.out.println("No connection");
        }
        ArrayList<Student> studentList=new ArrayList<>();
        try(Statement statement=conn.createStatement();
            ResultSet result= statement.executeQuery("SELECT* FROM Students")){

            while(result.next()){
                int sID=result.getInt("student_id");
                String name=result.getString("student_name");
                String email=result.getString("email");
                studentList.add(new Student(name,email,sID));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return studentList;//Returns the ArrayList studentList
    }

    public static ArrayList<Instructor> getInstructor(){// Gets all instructors from our Maria DB and stores them in a list
        Connection conn=Database.connectDB();
        if (conn==null){
            System.out.println("No connection");
        }
        ArrayList<Instructor> instructorList=new ArrayList<>();
        try(Statement statement=conn.createStatement();
            ResultSet result=statement.executeQuery("SELECT* FROM Instructor");){

            while(result.next()){
                String inID=result.getString("instructor_id");
                String name=result.getString("instructor_name");
                String email=result.getString("email");
                instructorList.add(new Instructor(name,email,inID));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return instructorList;// returns the ArrayList instructorList
    }

    int sID=0;
    String name="";
    String email="";
    public static void enrollStudent(int sID,String name,String email){//enrolls students to the Maria DB
        Connection conn= Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(PreparedStatement statement=conn.prepareStatement("INSERT INTO Students(student_id,student_name,email) VALUES(?,?,?)")){
            statement.setInt(1,sID);
            statement.setString(2,name);
            statement.setString(3,email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    String cID="";
    String cName="";
    int cCredits=0;
    String insName="";
    public static void addCourse(String cID,String cName,int cCredits,String insName){//adds courses to the Maria DB
        Connection conn=Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(PreparedStatement statement= conn.prepareStatement("INSERT INTO Courses(course_id,course_name,credits,instructor)VALUES(?,?,?,?)")){
            statement.setString(1,cID);
            statement.setString(2,cName);
            statement.setInt(3,cCredits);
            statement.setString(4,insName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    String inID="";
    String inName="";
    String inEmail="";
    public static void addInstructor(String inID,String inName,String inEmail){//adds instructors to the Maria DB
        Connection conn= Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(PreparedStatement statement=conn.prepareStatement("INSERT INTO Instructor(instructor_id,instructor_name,email) VALUES(?,?,?)")){
            statement.setString(1,inID);
            statement.setString(2,inName);
            statement.setString(3,inEmail);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void getMarks(){//gets all the marks from the Maria DB
        Connection conn=Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(Statement statement= conn.createStatement()){
            String sql="SELECT s.student_name, c.course_name, e.grade " +
                    "FROM enrollments e " +
                    "JOIN students s ON e.student_id = s.student_id " +
                    "JOIN courses c ON e.course_id = c.course_id " +
                    "ORDER BY s.student_name";//arranges the marks by student name for continuity
            ResultSet result= statement.executeQuery(sql);
            while(result.next()){
                String sName=result.getString("student_name");
                String courseName=result.getString("course_name");
                int grade=result.getInt("grade");

                System.out.println("Student: "+sName+" "+" Course: "+courseName+" "+" Grade: "+grade);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static DefaultPieDataset calcAverage(){//calculates the average marks per course
        Connection conn=Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        DefaultPieDataset dataset=new DefaultPieDataset();//Creates an instance of a DefaultPieSet to store data for the pie chart

        try(Statement statement= conn.createStatement()){
            String sql= "SELECT c.course_name, AVG(e.grade) AS average_grade " +
                    "FROM enrollments e " +
                    "JOIN courses c ON e.course_id = c.course_id " +
                    "GROUP BY c.course_name";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                String courseName=result.getString("course_name");
                double averageGrade= result.getDouble("average_grade");
                dataset.setValue(courseName, averageGrade);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dataset;// Returns the data for the pie chart
    }
    public static void removeStudent(int sID){// Deletes a student from the students table using their ID
        Connection conn=Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(PreparedStatement statement= conn.prepareStatement("DELETE FROM students WHERE student_id = ?")){
            statement.setInt(1,sID);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void removeCourse(String cID){//Deletes a course from the courses table using the ID
        Connection conn=Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(PreparedStatement statement = conn.prepareStatement("DELETE FROM courses WHERE course_id=?")){
            statement.setString(1,cID);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void removeInstructor(String inID){//Deletes a instructor from the instructor table using their ID
        Connection conn=Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(PreparedStatement statement= conn.prepareStatement("DELETE FROM instructor WHERE instructor_id=?")){
            statement.setString(1,inID);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        }

    public static void addGrade(String eID,int sID, String cID,int grade){
        Connection conn=Database.connectDB();
        if(conn==null){
            System.out.println("No Connection");
        }
        try(PreparedStatement statement=conn.prepareStatement("INSERT INTO enrollments(enrollment_id,student_id,course_id,grade)VALUES(?,?,?,?)")){
            statement.setString(1,eID);
            statement.setInt(2,sID);
            statement.setString(3,cID);
            statement.setInt(4,grade);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    }

