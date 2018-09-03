package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class LibrarianScreenLogged extends JFrame {

    private JPanel loggedLibrarianPanel;
    private JButton viewBooks = new JButton("View books");
    private JButton searchBooks = new JButton("Search books");
    private JButton addBook = new JButton("Add new book");
    private JButton removeBook = new JButton("Remove books");
    private JButton issuedBooks = new JButton("View issued books");
    private JButton logout = new JButton("Logout");
    private boolean isStudent = false;

    public LibrarianScreenLogged(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - librarian logged screen");

        loggedLibrarianPanel = new JPanel();
        JPanel loggedLibrarianInnerPanel = new JPanel();

        JLabel title = new JLabel("<html><br/><u>Welcome, Librarian!</u><br/> </html>",SwingConstants.CENTER);
        title.setFont(new Font("Serif",Font.BOLD,35));
        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Unity-3D-1.jpg").getImage().getScaledInstance(450,700,Image.SCALE_DEFAULT)));
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
        components[2] = addBook;
        components[3] = removeBook;
        components[4] = issuedBooks;
        components[5] = logout;

        for (JComponent x: components
                ) {
            x.setFont(new Font("Serif",Font.BOLD,22));
        }

        loggedLibrarianPanel.setLayout(new BorderLayout());
        loggedLibrarianPanel.add(title,BorderLayout.NORTH);
        loggedLibrarianPanel.add(image1,BorderLayout.WEST);
        loggedLibrarianPanel.add(image2,BorderLayout.EAST);
        loggedLibrarianPanel.add(loggedLibrarianInnerPanel,BorderLayout.CENTER);

        loggedLibrarianInnerPanel.setLayout(new GridBagLayout());
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
        loggedLibrarianInnerPanel.add(addBook,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        loggedLibrarianInnerPanel.add(removeBook,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        loggedLibrarianInnerPanel.add(viewBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        loggedLibrarianInnerPanel.add(searchBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        loggedLibrarianInnerPanel.add(issuedBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        loggedLibrarianInnerPanel.add(logout,gridBagConstraints);

        this.add(loggedLibrarianPanel);
    }


    public void viewBooksBtnListner(ActionListener viewBooksListener){

        viewBooks.addActionListener(viewBooksListener);
    }

    public void searchBooksBtnListner(ActionListener searchBooksListener){
        searchBooks.addActionListener(searchBooksListener);
    }

    public void addBooksBtnListener(ActionListener addBooksListener){
        addBook.addActionListener(addBooksListener);
    }

    public void removeBooksBtnListener(ActionListener removeBooksListener){
        removeBook.addActionListener(removeBooksListener);
    }

    public void issuedBooksBtnListener(ActionListener issuedBooksListener){
        issuedBooks.addActionListener(issuedBooksListener);
    }

    public void logoutBtnListener(ActionListener logoutListener){
        logout.addActionListener(logoutListener);
    }


    public boolean getIsStudent(){
        return isStudent;
    }

    public void setIsStudent(boolean isStudents){
        this.isStudent = isStudents;
    }

}
