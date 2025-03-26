import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GUI extends JFrame implements ActionListener{

    JMenuBar menuBar;
    JMenu academicMenu;
    JMenu viewMenu;
    JMenu administrationMenu;
    JMenuItem courseItem;
    JMenuItem analyticsItem;
    JMenuItem studentsItem;
    JMenuItem instructorsItem;
    JMenuItem marksItem;
    JMenuItem enrollItem;
    JMenuItem registerItem;
    JMenuItem addInstructorItem;
    JMenuItem removeItem;
    JMenuItem assignGradeItem;
    JPanel enrollPanel;
    JPanel registerPanel;
    JPanel instructorPanel;
    JPanel removePanel;
    JPanel assignGradePanel;
    JTextField studentIDField;
    JLabel studentIDLabel;
    JTextField studentNameField;
    JLabel studentNameLabel;
    JTextField studentEmailField;
    JLabel studentEmailLabel;
    JTextField courseIDField;
    JLabel courseIDLabel;
    JTextField courseNameField;
    JLabel courseNameLabel;
    JTextField courseCreditsField;
    JLabel courseCreditsLabel;
    JTextField courseInstructorField;
    JLabel courseInstructorLabel;
    JTextField instructorIDField;
    JLabel instructorIDLabel;
    JTextField instructorNameField;
    JLabel instructorNameLabel;
    JTextField instructorEmailField;
    JLabel instructorEmailLabel;
    JTextField ID;
    JLabel IDLabel;
    JTextField enrollmentID;
    JLabel enrollmentIDLabel;
    JTextField studentID;
    JLabel studentLabel;
    JTextField courseID;
    JLabel courseLabel;
    JTextField grade;
    JLabel gradeLabel;
    JButton enrollButton;
    JButton registerButton;
    JButton instructorButton;
    JButton removeStudentButton;
    JButton removeInstructorButton;
    JButton removeCourseButton;
    JButton assignGradeButton;
    GUI(){

        enrollPanel = new JPanel();
        enrollPanel.setLayout(null);
        enrollPanel.setBounds(50,50,400,400);
        enrollPanel.setBackground(Color.lightGray);
        studentIDField = new JTextField();
        studentIDLabel=new JLabel("ID");
        studentIDField.setBounds(100,20,200,30);
        studentIDLabel.setBounds(30,20,70,30);
        studentNameField = new JTextField();
        studentNameLabel=new JLabel("Name");
        studentNameField.setBounds(100,60,200,30);
        studentNameLabel.setBounds(30,60,70,30);
        studentEmailField = new JTextField();
        studentEmailLabel=new JLabel("Email");
        studentEmailField.setBounds(100,100,200,30);
        studentEmailLabel.setBounds(30,100,70,30);
        enrollButton = new JButton("ENROLL");
        enrollButton.setBounds(150,150,100,30);
        enrollButton.addActionListener(this);
        enrollPanel.setVisible(false);
        enrollPanel.add(studentIDField);
        enrollPanel.add(studentNameField);
        enrollPanel.add(studentEmailField);
        enrollPanel.add(studentIDLabel);
        enrollPanel.add(studentNameLabel);
        enrollPanel.add(studentEmailLabel);
        enrollPanel.add(enrollButton);

        registerPanel = new JPanel();
        registerPanel.setLayout(null);
        registerPanel.setBounds(50,50,400,400);
        registerPanel.setBackground(Color.lightGray);
        courseIDField=new JTextField();
        courseIDLabel=new JLabel("ID");
        courseIDField.setBounds(100,20,200,30);
        courseIDLabel.setBounds(30,20,70,30);
        courseNameField=new JTextField();
        courseNameLabel=new JLabel("Course");
        courseNameField.setBounds(100,60,200,30);
        courseNameLabel.setBounds(30,60,70,30);
        courseCreditsField=new JTextField();
        courseCreditsLabel=new JLabel("Credits");
        courseCreditsField.setBounds(100,100,200,30);
        courseCreditsLabel.setBounds(30,100,70,30);
        courseInstructorField= new JTextField();
        courseInstructorLabel=new JLabel("Instructor");
        courseInstructorField.setBounds(100,140,200,30);
        courseInstructorLabel.setBounds(30,140,70,30);
        registerButton=new JButton("REGISTER");
        registerButton.setBounds(150,180,100,30);
        registerButton.addActionListener(this);
        registerPanel.setVisible(false);
        registerPanel.add(courseIDField);
        registerPanel.add(courseNameField);
        registerPanel.add(courseCreditsField);
        registerPanel.add(courseInstructorField);
        registerPanel.add(courseIDLabel);
        registerPanel.add(courseNameLabel);
        registerPanel.add(courseCreditsLabel);
        registerPanel.add(courseInstructorLabel);
        registerPanel.add(registerButton);

        instructorPanel = new JPanel();
        instructorPanel.setLayout(null);
        instructorPanel.setBounds(50,50,400,400);
        instructorPanel.setBackground(Color.lightGray);
        instructorIDField= new JTextField();
        instructorIDLabel=new JLabel("ID");
        instructorIDField.setBounds(100,20,200,30);
        instructorIDLabel.setBounds(30,20,70,30);
        instructorNameField = new JTextField();
        instructorNameLabel=new JLabel("Name");
        instructorNameField.setBounds(100,60,200,30);
        instructorNameLabel.setBounds(30,60,70,30);
        instructorEmailField = new JTextField();
        instructorEmailLabel=new JLabel("Email");
        instructorEmailField.setBounds(100,100,200,30);
        instructorEmailLabel.setBounds(30,100,70,30);
        instructorButton = new JButton("ADD");
        instructorButton.setBounds(150,160,100,30);
        instructorButton.addActionListener(this);
        instructorPanel.setVisible(false);
        instructorPanel.add(instructorIDField);
        instructorPanel.add(instructorNameField);
        instructorPanel.add(instructorEmailField);
        instructorPanel.add(instructorIDLabel);
        instructorPanel.add(instructorNameLabel);
        instructorPanel.add(instructorEmailLabel);
        instructorPanel.add(instructorButton);

        removePanel = new JPanel();
        removePanel.setLayout(null);
        removePanel.setBounds(50,50,400,400);
        removePanel.setBackground(Color.lightGray);
        ID=new JTextField();
        IDLabel=new JLabel("ID");
        ID.setBounds(100,100,200,30);
        IDLabel.setBounds(70,100,70,30);
        removeStudentButton=new JButton("STUDENT");
        removeStudentButton.setBounds(150,180,100,30);
        removeStudentButton.addActionListener(this);
        removeInstructorButton=new JButton("INSTRUCTOR");
        removeInstructorButton.setBounds(125,260,150,30);
        removeInstructorButton.addActionListener(this);
        removeCourseButton=new JButton("COURSE");
        removeCourseButton.setBounds(150,220,100,30);
        removeCourseButton.addActionListener(this);
        removePanel.setVisible(false);
        removePanel.add(IDLabel);
        removePanel.add(ID);
        removePanel.add(removeStudentButton);
        removePanel.add(removeInstructorButton);
        removePanel.add(removeCourseButton);

        assignGradePanel=new JPanel();
        assignGradePanel.setLayout(null);
        assignGradePanel.setBounds(50,50,500,400);
        assignGradePanel.setBackground(Color.lightGray);
        enrollmentID=new JTextField();
        enrollmentIDLabel=new JLabel("Enrollment ID");
        enrollmentID.setBounds(150,20,200,30);
        enrollmentIDLabel.setBounds(60,20,200,30);
        studentID=new JTextField();
        studentLabel=new JLabel("Student ID");
        studentID.setBounds(150,60,200,30);
        studentLabel.setBounds(60,60,200,30);
        courseID=new JTextField();
        courseLabel=new JLabel("Course ID");
        courseID.setBounds(150,100,200,30);
        courseLabel.setBounds(60,100,200,30);
        grade=new JTextField();
        gradeLabel=new JLabel("Grade");
        grade.setBounds(150,140,200,30);
        gradeLabel.setBounds(60,140,200,30);
        assignGradeButton=new JButton("Assign Grade");
        assignGradeButton.setBounds(155,220,180,30);
        assignGradeButton.addActionListener(this);
        assignGradePanel.setVisible(false);
        assignGradePanel.add(enrollmentID);
        assignGradePanel.add(enrollmentIDLabel);
        assignGradePanel.add(studentID);
        assignGradePanel.add(studentLabel);
        assignGradePanel.add(courseID);
        assignGradePanel.add(courseLabel);
        assignGradePanel.add(grade);
        assignGradePanel.add(gradeLabel);
        assignGradePanel.add(assignGradeButton);




        menuBar = new JMenuBar();
        academicMenu = new JMenu("Academics");
        viewMenu = new JMenu("View");
        administrationMenu = new JMenu("Administration");

        courseItem = new JMenuItem("Courses");
        analyticsItem = new JMenuItem("Analytics");
        studentsItem = new JMenuItem("Students");
        instructorsItem = new JMenuItem("Instructors");
        marksItem = new JMenuItem("Marks");
        enrollItem = new JMenuItem("Enroll");
        registerItem = new JMenuItem("Courses");
        addInstructorItem = new JMenuItem("Add Inst.");
        removeItem = new JMenuItem("Remove");
        assignGradeItem = new JMenuItem("Ass.Grade");


        viewMenu.add(courseItem);
        viewMenu.add(analyticsItem);
        viewMenu.add(studentsItem);
        viewMenu.add(instructorsItem);
        viewMenu.add(marksItem);
        administrationMenu.add(enrollItem);
        administrationMenu.add(registerItem);
        administrationMenu.add(addInstructorItem);
        administrationMenu.add(removeItem);
        academicMenu.add(assignGradeItem);
        menuBar.add(viewMenu);
        menuBar.add(administrationMenu);
        menuBar.add(academicMenu);

        courseItem.addActionListener(this);
        analyticsItem.addActionListener(this);
        studentsItem.addActionListener(this);
        instructorsItem.addActionListener(this);
        marksItem.addActionListener(this);
        enrollItem.addActionListener(this);
        registerItem.addActionListener(this);
        addInstructorItem.addActionListener(this);
        removeItem.addActionListener(this);
        assignGradeItem.addActionListener(this);


        this.setJMenuBar(menuBar);
        this.setTitle("MARIA UNIVERSITY");//sets title of frame
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exits code when exit button is pressed
        this.setSize(600, 600);//sets the dimensions of the frame
        this.setVisible(true);//makes frame visible
        this.add(enrollPanel);
        this.add(registerPanel);
        this.add(instructorPanel);
        this.add(removePanel);
        this.add(assignGradePanel);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == courseItem || e.getSource() == studentsItem ||
                e.getSource() == instructorsItem || e.getSource() == enrollItem ||
                e.getSource() == registerItem || e.getSource() == addInstructorItem ||
                e.getSource() == marksItem || e.getSource() == analyticsItem ||
                e.getSource() == removeItem || e.getSource() == assignGradeItem) {

            enrollPanel.setVisible(false);
            registerPanel.setVisible(false);
            instructorPanel.setVisible(false);
            removePanel.setVisible(false);
            assignGradePanel.setVisible(false);
        }

        if(e.getSource()==courseItem){
            Queries.getCourses();
        }
        if(e.getSource()==studentsItem){
            ArrayList<Student> studentList =Queries.getStudents();
            for(Student student : studentList){
                student.displayDetails();
            }
        }
        if(e.getSource()==instructorsItem){
            ArrayList<Instructor> instructorList=Queries.getInstructor();
            for(Instructor instructor : instructorList){
                instructor.displayDetails();
            }
        }
        if(e.getSource()==enrollItem){
            enrollPanel.setVisible(true);
        }
        if(e.getSource()==enrollButton){
            String sID=studentIDField.getText();
            String name=studentNameField.getText();
            String email=studentEmailField.getText();
            Queries.enrollStudent(Integer.parseInt(sID),name,email);
            studentIDField.setText("");
            studentNameField.setText("");
            studentEmailField.setText("");
            studentIDField.requestFocus();
        }
        if(e.getSource()==registerItem){
            registerPanel.setVisible(true);
        }
        if(e.getSource()==registerButton){
            String cId=courseIDField.getText();
            String cName=courseNameField.getText();
            String cCredits=courseCreditsField.getText();
            String insName=courseInstructorField.getText();
            Queries.addCourse(cId,cName,Integer.parseInt(cCredits),insName);
            courseIDField.setText("");
            courseNameField.setText("");
            courseCreditsField.setText("");
            courseInstructorField.setText("");
            courseIDField.requestFocus();
        }
        if(e.getSource()==addInstructorItem){
            instructorPanel.setVisible(true);
        }
        if(e.getSource()==instructorButton){
            String inId=instructorIDField.getText();
            String inName=instructorNameField.getText();
            String inEmail=instructorEmailField.getText();
            Queries.addInstructor(inId,inName,inEmail);
            instructorIDField.setText("");
            instructorNameField.setText("");
            instructorEmailField.setText("");
            instructorIDField.requestFocus();
        }
        if(e.getSource()==marksItem){
            Queries.getMarks();
        }
        if(e.getSource()==analyticsItem){
            Analytics.displayAnalytics();
        }
        if(e.getSource()==removeItem){
            removePanel.setVisible(true);
        }
        if(e.getSource()==removeStudentButton){
            String sID=ID.getText();
            Queries.removeStudent(Integer.parseInt(sID));
            ID.setText("");
            ID.requestFocus();
        }
        if(e.getSource()==removeCourseButton){
            String cID=ID.getText();
            Queries.removeCourse(cID);
            ID.setText("");
            ID.requestFocus();
        }
        if(e.getSource()==removeInstructorButton){
            String inID=ID.getText();
            Queries.removeInstructor(inID);
        }
        if(e.getSource()==assignGradeItem){
            assignGradePanel.setVisible(true);
        }
        if(e.getSource()==assignGradeButton){
            String eID=enrollmentID.getText();
            String sNum=studentID.getText();
            int sID=Integer.parseInt(sNum);
            String cID=courseID.getText();
            String gradeValue=grade.getText();
            int gValue=Integer.parseInt(gradeValue);
            Queries.addGrade(eID,sID,cID,gValue);
            enrollmentID.setText("");
            studentID.setText("");
            courseID.setText("");
            grade.setText("");
            enrollmentID.requestFocus();
        }
    }
}
