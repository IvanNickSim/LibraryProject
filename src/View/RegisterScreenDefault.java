package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class RegisterScreenDefault extends JFrame{

    private JPanel registerDefaultPanel;
    private JButton backBtn = new JButton("Back");
    private JButton registerStudent = new JButton("Student Registration");
    private JButton registerLibrarian = new JButton("Librarian Registration");



    public RegisterScreenDefault(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - register options screen");

        registerDefaultPanel = new JPanel();
        JPanel registerInnerPanel = new JPanel();

        JPanel[] panels = new JPanel[2];
        panels[0] = registerDefaultPanel;
        panels[1] = registerInnerPanel;

        for (JPanel x: panels
             ) {
            x.setBackground(Color.LIGHT_GRAY);
        }

        JLabel title = new JLabel("<html><u>Register your type of account!</u></html>");
        title.setFont(new Font("Serif",Font.BOLD,34));
        JLabel imageOne = new JLabel();
        imageOne.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\1.jpeg").getImage().getScaledInstance(200,720,Image.SCALE_DEFAULT)));
        JLabel imageTwo = new JLabel();
        imageTwo.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\2.jpg").getImage().getScaledInstance(200,720,Image.SCALE_DEFAULT)));
        JLabel imageThree = new JLabel();
        imageThree.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Register.gif").getImage().getScaledInstance(430,250,Image.SCALE_DEFAULT)));
        JLabel[] imageLabels = new JLabel[2];
        imageLabels[0] = imageOne;
        imageLabels[1] = imageTwo;
        for (JLabel x: imageLabels
             ) {
            x.setBorder(new LineBorder(Color.black,3));
        }

        registerDefaultPanel.setLayout(new BorderLayout());
        registerDefaultPanel.add(registerInnerPanel,BorderLayout.CENTER);
        registerDefaultPanel.add(imageOne,BorderLayout.WEST);
        registerDefaultPanel.add(imageTwo,BorderLayout.EAST);

        JButton[] buttons = new JButton[3];
        buttons[0] = backBtn;
        buttons[1] = registerStudent;
        buttons[2] = registerLibrarian;

        for (JButton x: buttons
             ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        registerInnerPanel.setLayout(new GridBagLayout());
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
        registerInnerPanel.add(title,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        registerInnerPanel.add(registerLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        registerInnerPanel.add(registerStudent,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        registerInnerPanel.add(backBtn,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        registerInnerPanel.add(imageThree,gridBagConstraints);





        this.add(registerDefaultPanel);
    }

    public void backBtnListener(ActionListener listenBack){
        backBtn.addActionListener(listenBack);
    }

    public void registerStudentBtnListener(ActionListener listenStudent){
        registerStudent.addActionListener(listenStudent);
    }

    public void registerLibrarianBtnListener(ActionListener listenLibrarian){
        registerLibrarian.addActionListener(listenLibrarian);
    }

}
