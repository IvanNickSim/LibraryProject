package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class ReturnBooksScreen extends JFrame {

    private JPanel returnBookPanel;
    private JButton returnBooksBackButton = new JButton("Back");
    private JButton returnBookButton = new JButton("Return Book");
    private JTextField bookTitle;
    private JTextField bookAuthor;
    private String loggedStudentusername;


    public ReturnBooksScreen() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - take book screen");

        returnBookPanel = new JPanel();
        JPanel returnBooksInnerPanel = new JPanel();
        bookTitle = new JTextField(20);
        bookAuthor = new JTextField(20);
        JLabel title = new JLabel("<html><u>Enter following data to return a book!</u></html>");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        JLabel enterTitle = new JLabel("Enter Title: ");
        JLabel enterAuthor = new JLabel("Enter Author: ");
        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Unity-3D-1.jpg").getImage().getScaledInstance(350, 700, Image.SCALE_DEFAULT)));
        image1.setBorder(new LineBorder(Color.black, 3));
        JLabel image2 = new JLabel();
        image2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\ultimate-list-of-programming-books.jpg").getImage().getScaledInstance(350, 700, Image.SCALE_DEFAULT)));
        image2.setBorder(new LineBorder(Color.black, 3));

        JComponent[] components = new JComponent[6];
        components[0] = enterTitle;
        components[1] = enterAuthor;
        components[2] = bookTitle;
        components[3] = bookAuthor;
        components[4] = returnBookButton;
        components[5] = returnBooksBackButton;


        for (JComponent x : components
                ) {
            x.setFont(new Font("Serif", Font.BOLD, 20));
        }

        returnBookPanel.setLayout(new BorderLayout());
        returnBookPanel.add(returnBooksInnerPanel, BorderLayout.CENTER);
        returnBookPanel.add(image1, BorderLayout.EAST);
        returnBookPanel.add(image2, BorderLayout.WEST);


        returnBooksInnerPanel.setLayout(new GridBagLayout());
        returnBooksInnerPanel.setBorder(new LineBorder(Color.black, 3));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        returnBooksInnerPanel.add(title, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        returnBooksInnerPanel.add(enterTitle, gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        returnBooksInnerPanel.add(bookTitle, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        returnBooksInnerPanel.add(enterAuthor, gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        returnBooksInnerPanel.add(bookAuthor, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        returnBooksInnerPanel.add(returnBookButton, gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        returnBooksInnerPanel.add(returnBooksBackButton, gridBagConstraints);

        this.add(returnBookPanel);

    }

    public void backBtnListener(ActionListener backListen) {
        returnBooksBackButton.addActionListener(backListen);
    }

    public void returnBookBtnListener(ActionListener addBooksListen) {
        returnBookButton.addActionListener(addBooksListen);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public String getBookTitle() {
        return this.bookTitle.getText();
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle.setText(bookTitle);
    }

    public String getBookAuthor() {
        return this.bookAuthor.getText();
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor.setText(bookAuthor);
    }

    public String getLoggedStudentUsername(){
        return this.loggedStudentusername;
    }

    public void setLoggedStudentUsername(String username){
        this.loggedStudentusername = username;
    }

}