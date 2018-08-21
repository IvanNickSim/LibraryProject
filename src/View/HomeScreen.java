package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class HomeScreen extends JFrame{

    private JPanel homeScreenPanel;
    private JButton librarianLogin = new JButton("Librarian login");
    private JButton studentLogin = new JButton("Student login");
    private JButton register = new JButton("Register");
    private JButton forgotPass = new JButton("Reset password");
    private JButton history = new JButton("History");
    private JButton contact = new JButton("Contact us");

    public HomeScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - home screen");

        homeScreenPanel = new JPanel();
        homeScreenPanel.setBorder(new EmptyBorder(10,10,10,10));

        JPanel innerHomeScreenPanel = new JPanel();
        JLabel introLabel = new JLabel("<html><u>Welcome to Sofia library management app</u></html>", SwingConstants.CENTER);
        JLabel creatorLabel = new JLabel("Created by Ivan Simeonov", SwingConstants.CENTER);
        JLabel imageOne = new JLabel();
        imageOne.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\LibraryOfCongressClassification.jpg").getImage().getScaledInstance(250,470,Image.SCALE_DEFAULT)));
        JLabel imageTwo = new JLabel();
        imageTwo.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\courses.jpg").getImage().getScaledInstance(250,470,Image.SCALE_DEFAULT)));

        JLabel[] labels = new JLabel[2];
        labels[0] = introLabel;
        labels[1] = creatorLabel;

        for (JLabel x: labels
             ) {
            x.setBorder(new LineBorder(Color.black,3));
            x.setOpaque(true);
            x.setBackground(Color.LIGHT_GRAY);
            x.setFont(new Font("Serif",Font.BOLD,40));
            x.setPreferredSize(new Dimension(1200,100));
        }

        JLabel[] imageLabels = new JLabel[2];
        imageLabels[0] = imageOne;
        imageLabels[1] = imageTwo;

        for (JLabel x: imageLabels
             ) {
            x.setBorder(new LineBorder(Color.black,3));
            x.setPreferredSize(new Dimension(250,460));
        }

        homeScreenPanel.setLayout(new BorderLayout());
        homeScreenPanel.add(introLabel,BorderLayout.NORTH);
        homeScreenPanel.add(creatorLabel,BorderLayout.SOUTH);
        homeScreenPanel.add(innerHomeScreenPanel,BorderLayout.CENTER);
        homeScreenPanel.add(imageOne,BorderLayout.EAST);
        homeScreenPanel.add(imageTwo,BorderLayout.WEST);

        JButton[] buttons = new JButton[6];
        buttons[0] = librarianLogin;
        buttons[1] = studentLogin;
        buttons[2] = register;
        buttons[3] = forgotPass;
        buttons[4] = history;
        buttons[5] = contact;


        for (JButton x: buttons
             ) {
            x.setPreferredSize(new Dimension(300,120));
            x.setFont(new Font("Serif",Font.BOLD,22));
        }

        innerHomeScreenPanel.setLayout(new GridBagLayout());
        innerHomeScreenPanel.setBackground(Color.lightGray);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        innerHomeScreenPanel.add(librarianLogin,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        innerHomeScreenPanel.add(studentLogin,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        innerHomeScreenPanel.add(register,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        innerHomeScreenPanel.add(forgotPass,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        innerHomeScreenPanel.add(history,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        innerHomeScreenPanel.add(contact,gridBagConstraints);

        this.add(homeScreenPanel);

    }

    public void historyBtnListener(ActionListener listenHistory){
        history.addActionListener(listenHistory);
    }

    public void contactBtnListener(ActionListener listenContact){
        contact.addActionListener(listenContact);
    }

    public void forgotPassBtnListener(ActionListener listenForgotPassword){
        forgotPass.addActionListener(listenForgotPassword);
    }

    public void registerBtnListener(ActionListener listenRegister){
        register.addActionListener(listenRegister);
    }

    public void studentLoginBtnListener(ActionListener listenStudentLogin){
        studentLogin.addActionListener(listenStudentLogin);
    }

    public void librarianLoginBtnListener(ActionListener listenLibrarianLogin){
        librarianLogin.addActionListener(listenLibrarianLogin);
    }



}
