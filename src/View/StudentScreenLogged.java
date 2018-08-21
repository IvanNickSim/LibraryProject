package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class StudentScreenLogged extends JFrame{

    private JPanel loggedStudentPanel;
    private JButton viewBooks = new JButton("View books");
    private JButton searchBooks = new JButton("Search books");
    private JButton takeBook = new JButton("Take a book");
    private JButton returnBook = new JButton("Return a book");
    private JButton takenBooks = new JButton("View taken books");
    private JButton logout = new JButton("Logout");

    public StudentScreenLogged(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - student logged screen");

        loggedStudentPanel = new JPanel();
        JPanel loggedStudentInnerPanel = new JPanel();

        JLabel title = new JLabel("<html><br/><u>Welcome, Student!</u><br/> </html>",SwingConstants.CENTER);
        title.setFont(new Font("Serif",Font.BOLD,35));
        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Unity-3D-1.jpg").getImage().getScaledInstance(450,700, Image.SCALE_DEFAULT)));
        JLabel image2 = new JLabel();
        image2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\ultimate-list-of-programming-books.jpg").getImage().getScaledInstance(450,700,Image.SCALE_DEFAULT)));

        JComponent[] borders = new JComponent[3];
        borders[0] = title;
        borders[1] = image1;
        borders[2] = image2;

        for (JComponent x: borders
             ) {
            x.setBorder(new LineBorder(Color.black,3));
        }

        JComponent[] components = new JComponent[6];
        components[0] = viewBooks;
        components[1] = searchBooks;
        components[2] = takeBook;
        components[3] = returnBook;
        components[4] = takenBooks;
        components[5] = logout;

        for (JComponent x: components
             ) {
            x.setFont(new Font("Serif",Font.BOLD,22));
        }

        loggedStudentPanel.setLayout(new BorderLayout());
        loggedStudentPanel.add(title,BorderLayout.NORTH);
        loggedStudentPanel.add(loggedStudentInnerPanel,BorderLayout.CENTER);
        loggedStudentPanel.add(image1,BorderLayout.EAST);
        loggedStudentPanel.add(image2,BorderLayout.WEST);

        loggedStudentInnerPanel.setLayout(new GridBagLayout());
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
        loggedStudentInnerPanel.add(viewBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        loggedStudentInnerPanel.add(searchBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        loggedStudentInnerPanel.add(takeBook,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        loggedStudentInnerPanel.add(returnBook,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        loggedStudentInnerPanel.add(takenBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        loggedStudentInnerPanel.add(logout,gridBagConstraints);

        this.add(loggedStudentPanel);
    }

    public void viewBooksBtnListner(ActionListener viewBooksListener){
        viewBooks.addActionListener(viewBooksListener);
    }

    public void searchBooksBtnListner(ActionListener searchBooksListener){
        searchBooks.addActionListener(searchBooksListener);
    }

    public void takeBooksBtnListener(ActionListener takeBooksListener){
        takeBook.addActionListener(takeBooksListener);
    }

    public void returnBooksBtnListener(ActionListener returnBooksListener){
        returnBook.addActionListener(returnBooksListener);
    }

    public void takenBooksBtnListener(ActionListener takenBooksListener){
        takenBooks.addActionListener(takenBooksListener);
    }

    public void logoutBtnListener(ActionListener logoutListener){
        logout.addActionListener(logoutListener);
    }

}
