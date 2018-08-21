package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class StudentScreenLogin extends JFrame{


    private JPanel loginStudentPanel;
    private JTextField studentLoginUsername;
    private JPasswordField studentLoginPassword;
    private JButton loginStudent = new JButton("Login");
    private JButton backStudent = new JButton("Back");

    public StudentScreenLogin(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - login as student screen");


        loginStudentPanel = new JPanel();
        studentLoginUsername = new JTextField(20);
        studentLoginPassword = new JPasswordField(20);
        JLabel logInLabel = new JLabel("<html><u>Login to Your Account, Student!</u></html>");
        logInLabel.setFont(new Font("Serif",Font.BOLD,31));
        JLabel uname = new JLabel("Enter Username");
        JLabel pass = new JLabel("Enter Password");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\stud.jpg").getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT)));

        JComponent[] components = new JComponent[6];
        components[0] = uname;
        components[1] = pass;
        components[2] = studentLoginUsername;
        components[3] = studentLoginPassword;
        components[4] = backStudent;
        components[5] = loginStudent;

        for (JComponent x: components
             ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        loginStudentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        loginStudentPanel.add(logInLabel,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        loginStudentPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        loginStudentPanel.add(studentLoginUsername,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        loginStudentPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        loginStudentPanel.add(studentLoginPassword,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        loginStudentPanel.add(loginStudent,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        loginStudentPanel.add(backStudent,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        loginStudentPanel.add(imageLabel,gridBagConstraints);


        this.add(loginStudentPanel);
    }

    public void backBtnListener(ActionListener backListen){
        backStudent.addActionListener(backListen);
    }

    public void loginBtnListener(ActionListener loginListen){
        loginStudent.addActionListener(loginListen);
    }

}
