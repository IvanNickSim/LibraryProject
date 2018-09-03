package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 27/08/2018.
 */
public class LoginUserScreen extends JFrame{

    private JPanel loginUserPanel;
    private JTextField username;
    private JPasswordField password;
    private JButton loginBtn = new JButton("Login");
    private JButton backBtn = new JButton("Back");
    private boolean isStudent = false;

    public LoginUserScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - login screen");


        loginUserPanel = new JPanel();
        username = new JTextField(20);
        password = new JPasswordField(20);
        JLabel logInLabel = new JLabel("<html><u>Login to your account!</u></html>");
        logInLabel.setFont(new Font("Serif",Font.BOLD,31));
        JLabel uname = new JLabel("Enter Username");
        JLabel pass = new JLabel("Enter Password");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\lib.jpg").getImage().getScaledInstance(450,300, Image.SCALE_DEFAULT)));

        JComponent[] components = new JComponent[6];
        components[0] = uname;
        components[1] = pass;
        components[2] = username;
        components[3] = password;
        components[4] = backBtn;
        components[5] = loginBtn;

        for (JComponent x: components
                ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        loginUserPanel.setLayout(new GridBagLayout());
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

        loginUserPanel.add(logInLabel,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        loginUserPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        loginUserPanel.add(username,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        loginUserPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        loginUserPanel.add(password,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        loginUserPanel.add(loginBtn,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        loginUserPanel.add(backBtn,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        loginUserPanel.add(imageLabel,gridBagConstraints);


        this.add(loginUserPanel);
    }

    public void backBtnListener(ActionListener backListen){
        backBtn.addActionListener(backListen);
    }

    public void loginBtnListener(ActionListener loginListen){
        loginBtn.addActionListener(loginListen);
    }

    public void setIsStudent(boolean isStudent){
        this.isStudent = isStudent;
    }

    public boolean getIsStudent(){
        return this.isStudent;
    }

    public String getUsername(){
        return username.getText();
    }

    public void setUsername(String username){
        this.username.setText(username);
    }

    public String getPassword(){
        return password.getText();
    }

    public void setPassword(String password){
        this.password.setText(password);
    }

    public void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this,errorMessage);

    }



}
