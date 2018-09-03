package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class LibrarianScreenLogin extends JFrame{


    private JPanel loginLibrarianPanel;
    private JTextField librarianLoginUsername;
    private JPasswordField librarianLoginPassword;
    private JButton loginLib = new JButton("Login");
    private JButton backLibrarian = new JButton("Back");
    private boolean isStudent = false;

    public LibrarianScreenLogin(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - login as librarian screen");


        loginLibrarianPanel = new JPanel();
        librarianLoginUsername = new JTextField(20);
        librarianLoginPassword = new JPasswordField(20);
        JLabel logInLabel = new JLabel("<html><u>Login to Your Account, Librarian!</u></html>");
        logInLabel.setFont(new Font("Serif",Font.BOLD,31));
        JLabel uname = new JLabel("Enter Username");
        JLabel pass = new JLabel("Enter Password");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\lib.jpg").getImage().getScaledInstance(450,300, Image.SCALE_DEFAULT)));

        JComponent[] components = new JComponent[6];
        components[0] = uname;
        components[1] = pass;
        components[2] = librarianLoginUsername;
        components[3] = librarianLoginPassword;
        components[4] = backLibrarian;
        components[5] = loginLib;

        for (JComponent x: components
                ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        loginLibrarianPanel.setLayout(new GridBagLayout());
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

        loginLibrarianPanel.add(logInLabel,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        loginLibrarianPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        loginLibrarianPanel.add(librarianLoginUsername,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        loginLibrarianPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        loginLibrarianPanel.add(librarianLoginPassword,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        loginLibrarianPanel.add(loginLib,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        loginLibrarianPanel.add(backLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        loginLibrarianPanel.add(imageLabel,gridBagConstraints);


        this.add(loginLibrarianPanel);
    }

    public void backBtnListener(ActionListener backListen){
        backLibrarian.addActionListener(backListen);
    }

    public void loginBtnListener(ActionListener loginListen){
        loginLib.addActionListener(loginListen);
    }

    public void setIsStudent(boolean isStudent){
        this.isStudent = isStudent;
    }

    public boolean getIsStudent(){
        return this.isStudent;
    }

    public String getLibrarianLoginName(){
        return librarianLoginUsername.getText();
    }

    public String getLibrarianPassword(){
        return librarianLoginPassword.getText();
    }

    public void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this,errorMessage);

    }
}
