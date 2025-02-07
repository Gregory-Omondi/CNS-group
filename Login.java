import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JLabel userLabel, passwordLabel, success;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JPanel loginPanel;

    Login(){//Creates a login frame
    this.setTitle("Login");
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 250);


    loginPanel = new JPanel();//creates a login panel
    loginPanel.setLayout(null);
    loginPanel.setBounds(10, 10, 260, 200);
    add(loginPanel);

    userLabel = new JLabel("Username");//label for the username
    userLabel.setBounds(10,20,80,25);
    loginPanel.add(userLabel);
    usernameField = new JTextField();
    usernameField.setBounds(100,20,165,25);
    loginPanel.add(usernameField);

    passwordLabel = new JLabel("Password");//label for the password
    passwordLabel.setBounds(10,50,80,25);
    loginPanel.add(passwordLabel);
    passwordField = new JPasswordField();
    passwordField.setBounds(100,50,165,25);
    loginPanel.add(passwordField);

    loginButton = new JButton("Login");//login button creation and functionality
    loginButton.setBounds(100,80,80,25);
    loginButton.addActionListener(this);
    loginPanel.add(loginButton);

    success= new JLabel("");//Creates a label without any text
    success.setBounds(10,120,300,25);
    loginPanel.add(success);


    this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if(username.equals("admin") && password.equals("admin")){
            dispose();//if the password is correct the login window disappears
            new GUI ();//the GUI containing all the other functions appears
        }
        else{
            success.setText("Login Failed!!");//displays the text only when the password is wrong
        }
    }
}
