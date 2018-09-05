package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class TakeBooksScreen extends JFrame {

    private JPanel takeBookPanel;
    private JButton takeBooksBackButton = new JButton("Back");
    private JButton takeBookButton = new JButton("Take Book");
    private JTextField bookTitle;
    private JTextField bookAuthor;
    private String loggedStudentusername;



    public TakeBooksScreen() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - take book screen");

        takeBookPanel = new JPanel();
        JPanel takeBooksInnerPanel = new JPanel();
        bookTitle = new JTextField(20);
        bookAuthor = new JTextField(20);
        JLabel title = new JLabel("<html><u>Enter following data to take a book!</u></html>");
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
        components[4] = takeBooksBackButton;
        components[5] = takeBookButton;

        for (JComponent x : components
                ) {
            x.setFont(new Font("Serif", Font.BOLD, 20));
        }

        takeBookPanel.setLayout(new BorderLayout());
        takeBookPanel.add(takeBooksInnerPanel, BorderLayout.CENTER);
        takeBookPanel.add(image1, BorderLayout.EAST);
        takeBookPanel.add(image2, BorderLayout.WEST);


        takeBooksInnerPanel.setLayout(new GridBagLayout());
        takeBooksInnerPanel.setBorder(new LineBorder(Color.black, 3));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        takeBooksInnerPanel.add(title, gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        takeBooksInnerPanel.add(enterTitle, gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        takeBooksInnerPanel.add(bookTitle, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        takeBooksInnerPanel.add(enterAuthor, gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        takeBooksInnerPanel.add(bookAuthor, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        takeBooksInnerPanel.add(takeBookButton, gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        takeBooksInnerPanel.add(takeBooksBackButton, gridBagConstraints);

        this.add(takeBookPanel);


    }

    public void backBtnListener(ActionListener backListen) {
        takeBooksBackButton.addActionListener(backListen);
    }

    public void takeBookBtnListener(ActionListener addBooksListen) {
        takeBookButton.addActionListener(addBooksListen);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public String getBookTitle(){
        return this.bookTitle.getText();
    }

    public void setBookTitle(String bookTitle){
        this.bookTitle.setText(bookTitle);
    }

    public String getBookAuthor(){
        return this.bookAuthor.getText();
    }

    public void setBookAuthor(String bookAuthor){
        this.bookAuthor.setText(bookAuthor);
    }

    public String getLoggedStudentUsername(){
        return this.loggedStudentusername;
    }

    public void setLoggedStudentUsername(String username){
        this.loggedStudentusername = username;
    }

}
