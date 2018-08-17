package LibraryView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 * Created by megat0n on 28/07/2018.
 */

public class LibraryView extends JFrame {

    //the panel in the start frame
    private JPanel startPanel;

    //internal frames

    private JInternalFrame contactPanel;
    private JInternalFrame librarianLoginPanel;
    private JInternalFrame studentLoginPanel;
    private JInternalFrame registerPanel;
    private JInternalFrame registerStudentPanel;
    private JInternalFrame registerLibrarianPanel;
    private JInternalFrame historyPanel;
    private JInternalFrame historyNextPanel;
    private JInternalFrame loggedLibrarianIntFrame;
    private JInternalFrame loggedStudentIntFrame;
    private JInternalFrame addBookIntFrame;
    private JInternalFrame removeBookLibrarian;
    private JInternalFrame viewBooksIntFrameLibrarian;
    private JInternalFrame viewBooksIntFrameStudent;
    private JInternalFrame searchBooksIntFrameLibrarian;
    private JInternalFrame searchBooksIntFrameStudent;
    private JInternalFrame searchedBooksLibrarianView;
    private JInternalFrame searchedAuthorLibrarianView;
    private JInternalFrame searchedBooksStudentView;
    private JInternalFrame searchedAuthorStudentView;

    //buttons inside SearchBooksStudentView by Author
    private JButton searchBooksAuthorBackButtonStudent = new JButton("Back");

    //buttons inside SearchBooksLibrarianView by Title
    private JButton searchBooksBackButtonStudent = new JButton("Back");

    //buttons inside SearchBooksLibrarianView by Author
    private JButton searchBooksAuthorBackButtonLibrarian = new JButton("Back");

    //buttons inside SearchBooksLibrarianView by Title
    private JButton searchBooksBackButtonLibrarian = new JButton("Back");

    //buttons inside viewBooksIntFrame
    private JButton backButtonViewBooksLibrarian = new JButton("Back");
    private JButton backButtonViewBooksStudent = new JButton("Back");

    //buttons and fields inside add book internal frame
    private JButton addBooksBackButton = new JButton("Back");
    private JButton addBookButton = new JButton("Add Book");
    private JTextField bookTitle = new JTextField(20);
    private JTextField bookAuthor = new JTextField(20);
    private JTextField bookISBN = new JTextField(20);
    private JTextField bookDate = new JTextField(20);
    private JTextField bookQuantity = new JTextField(20);

    //button inside both after Login Librarian and Login Student Internal Frames
    private JButton viewBooksLibrarian = new JButton("View Books");
    private JButton viewBooksStudent = new JButton("View Books");

    //button inside both after Login Librarian and Login Student Internal Frames
    private JButton searchBooksStudent = new JButton("Search Books");
    private JButton searchBooksLibrarian = new JButton("Search Books");

    //buttons inside search books logged librarian internal frame
    private JButton searchBooksLibrarianInsideSearchTitle = new JButton("Search Books by Title");
    private JButton searchBooksLibrarianInsideSearchAuthor = new JButton("Search Books by Author");
    private JButton searchBooksLibrarianInsideSearchBoth = new JButton("Search Books by Both");
    private JButton backFromSearchBooksLibrarianInsideSearch = new JButton("Back");
    private JTextField searchByTitleLibrarian = new JTextField(20);
    private JTextField searchByAuthorLibrarian = new JTextField(20);

    //buttons inside search books logged student internal frame
    private JButton searchBooksStudentInsideSearchTitle = new JButton("Search Books by Title");
    private JButton searchBooksStudentInsideSearchAuthor = new JButton("Search Books by Author");
    private JButton searchBooksStudentInsideSearchBoth = new JButton("Search Books by Both");
    private JButton backFromSearchBooksStudentInsideSearch = new JButton("Back");
    private JTextField searchByTitleStudent = new JTextField(20);
    private JTextField searchByAuthorStudent = new JTextField(20);

    //buttons inside the after Login Librarian Internal Frame
    private JButton addBooks = new JButton("Add Books");
    private JButton removeBooks = new JButton("Remove Books");
    private JButton viewIssuedBooks = new JButton("Issued Books");
    private JButton logoutLibrarian = new JButton("Logout");

    //button inside the after Login Student INternal frame
    private JButton studentTakeBooks = new JButton("Take a Book");
    private JButton returnBooks = new JButton("Return a Book");
    private JButton viewTakenBooks = new JButton("View Taken Books");
    private JButton logoutStudent = new JButton("Logout");



    //buttons inside the start frame
    private JButton librarianLogin = new JButton("Librarian Login");
    private JButton studentLogin = new JButton("Student Login");
    private JButton register = new JButton("Register");
    private JButton forgotPass = new JButton("Reset Password");
    private JButton history = new JButton("History");
    private JButton contact = new JButton("Contact Us");

    //green Arrows inside the first History internal frame
    private JButton back = new JButton();
    private JButton nextBtn = new JButton();

    //back button inside Contact Internal Frame
    private JButton backContact = new JButton("Back");

    //back button inside the second history internal frame
    private JButton back2 = new JButton("Back");

    //buttons inside LibrarianLogin internal frame
    private JTextField librarianLoginUsername;
    private JPasswordField librarianLoginPassword;
    private JButton loginLib = new JButton("Login");
    private JButton backLibrarian = new JButton("Back");

    //buttons inside StudentLogin internal frame
    private JTextField studentLoginUsername;
    private JPasswordField studentLoginPassword;
    private JButton loginStudent = new JButton("Login");
    private JButton backStudent = new JButton("Back");

    //buttons inside Register internal frame
    private JButton registerBackButton = new JButton("Back");
    private JButton regAsStudentBtn = new JButton("Student Registration");
    private JButton regAsLibrarianBtn = new JButton("Librarian Registration");

    //Buttons inside Register Student Frame
    private JTextField registerUnameStudent = new JTextField();
    private JTextField registerEmailStudent = new JTextField();
    private JTextField secretWordStudent = new JTextField();
    private JPasswordField registerPassStudent = new JPasswordField();
    private JButton registerStudent = new JButton("Register");
    private JButton backRegisterStudent = new JButton("Back");

    //Buttons inside Register Librarian Frame
    private JTextField registerUnameLibrarian = new JTextField();
    private JTextField registerEmailLibrarian = new JTextField();
    private JTextField secretWordLibrarian = new JTextField();
    private JPasswordField registerPassLibrarian = new JPasswordField();
    private JButton registerLibrarian = new JButton("Register");
    private JButton backRegisterLibrarian = new JButton("Back");

    //buttons inside remove books logged librarian internal frame
    private JButton removeBookByTitle = new JButton("Remove Books by Title");
    private JButton removeBookByAuthor = new JButton("Remove all Books by Authors Fullname");
    private JButton backFromRemoveBooksLibrarian = new JButton("Back");
    private JTextField removeByBookTitle = new JTextField(20);
    private JTextField removeByAuthorFullname = new JTextField(20);





    public LibraryView(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        //Always after the setSize or it wont affect
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library Management App");


        startPanel = new JPanel();
        startPanel.setBorder(new EmptyBorder(10,10,10,10));

        JPanel innerPanel = new JPanel();

        JLabel introLabel = new JLabel("<html><u>Welcome to Sofia Library Management App</u></html>", SwingConstants.CENTER);
        introLabel.setOpaque(true);
        introLabel.setBackground(Color.lightGray);
        introLabel.setPreferredSize(new Dimension(1200,150));
        introLabel.setFont(new Font("Serif",Font.BOLD,40));
        Border border = new LineBorder(Color.black,3);
        introLabel.setBorder(border);

        JLabel creatorLabel = new JLabel("Created by Ivan Simeonov", SwingConstants.CENTER);
        creatorLabel.setOpaque(true);
        creatorLabel.setBackground(Color.lightGray);
        creatorLabel.setPreferredSize(new Dimension(1200,100));
        creatorLabel.setFont(new Font("Serif",Font.BOLD,30));
        creatorLabel.setBorder(border);

        JLabel whiteSpace = new JLabel(" ");
        whiteSpace.setPreferredSize(new Dimension(250,460));
        whiteSpace.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\LibraryOfCongressClassification.jpg").getImage().getScaledInstance(250,470,Image.SCALE_DEFAULT)));
        whiteSpace.setBorder(border);

        JLabel whiteSpace1 = new JLabel(" ");
        whiteSpace1.setPreferredSize(new Dimension(250,460));
        whiteSpace1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\courses.jpg").getImage().getScaledInstance(250,470,Image.SCALE_DEFAULT)));
        whiteSpace1.setBorder(border);


        //main Panel using Border Layout
        startPanel.setLayout(new BorderLayout());
        startPanel.add(introLabel,BorderLayout.NORTH);
        startPanel.add(creatorLabel,BorderLayout.SOUTH);
        startPanel.add(innerPanel,BorderLayout.CENTER);
        startPanel.add(whiteSpace,BorderLayout.EAST);
        startPanel.add(whiteSpace1,BorderLayout.WEST);

        //Buttons
        librarianLogin.setPreferredSize(new Dimension(300,120));
        librarianLogin.setFont(new Font("Serif",Font.BOLD,22));
        studentLogin.setPreferredSize(new Dimension(300,120));
        studentLogin.setFont(new Font("Serif",Font.BOLD,22));
        register.setPreferredSize(new Dimension(300,120));
        register.setFont(new Font("Serif",Font.BOLD,22));
        forgotPass.setPreferredSize(new Dimension(300,120));
        forgotPass.setFont(new Font("Serif",Font.BOLD,22));
        history.setPreferredSize(new Dimension(300,120));
        history.setFont(new Font("Serif",Font.BOLD,22));
        contact.setPreferredSize(new Dimension(300,120));
        contact.setFont(new Font("Serif",Font.BOLD,22));
        back.setFont(new Font("Serif",Font.BOLD,22));
        back2.setFont(new Font("Serif",Font.BOLD,22));
        nextBtn.setFont(new Font("Serif",Font.BOLD,22));


        //the Center of the startPanel that uses Border Layout, innerPanel uses GridBagLayout
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setBackground(Color.lightGray);
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

        innerPanel.add(librarianLogin,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        innerPanel.add(studentLogin,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        innerPanel.add(register,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        innerPanel.add(forgotPass,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        innerPanel.add(history,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        innerPanel.add(contact,gridBagConstraints);

        this.add(startPanel);

    }

    //Listener for the back button in search by title student frame
    public void setSearchBooksIntFirstFrameStudentTitleSearch(ActionListener listenForBackButton){
        searchBooksBackButtonStudent.addActionListener(listenForBackButton);
    }

    //listener for the back button in search by author student frame
    public void setSearchBooksIntFirstFrameStudentAuthorSearch(ActionListener listenForBackButton){
        searchBooksAuthorBackButtonStudent.addActionListener(listenForBackButton);
    }


    //Listener for the back button in search by title librarian frame
    public void setSearchBooksIntFirstFrameLibrarianTitleSearch(ActionListener listenForBackButton){
        searchBooksBackButtonLibrarian.addActionListener(listenForBackButton);
    }

    //listener for the back button in search by author librarian frame
    public void setSearchBooksIntFirstFrameLibrarianAuthorSearch(ActionListener listenForBackButton){
        searchBooksAuthorBackButtonLibrarian.addActionListener(listenForBackButton);
    }

    //Listener for the Librarian Login button
    public void setLibrarianLogin(ActionListener listenForLibLoginButton){
        librarianLogin.addActionListener(listenForLibLoginButton);
    }

    //Listener for the Student Login button
    public void setStudentLogin(ActionListener listenForStudLoginButton){
        studentLogin.addActionListener(listenForStudLoginButton);
    }

    //Listener for the Register button
    public void setRegister(ActionListener listenForRegisterButton){
        register.addActionListener(listenForRegisterButton);
    }

    //Listener for the Reset Password button
    public void setForgotPass(ActionListener listenForForgotPassButton){
        forgotPass.addActionListener(listenForForgotPassButton);
    }

    /*********/
    /**********/
    /***********/

    //Listener for the remove books button inside librarian frame
    public void setRemoveButtonLibrarian(ActionListener listenForRemoveBtn){
        removeBooks.addActionListener(listenForRemoveBtn);
    }

    //Listener for the back button inside the search books librarian frame
    public void setBackSearchBooksButtonLibrarian(ActionListener listenForBackSearchBooksBtn){
        backFromSearchBooksLibrarianInsideSearch.addActionListener(listenForBackSearchBooksBtn);
    }

    //Listener for the back button inside the search books student frame
    public void setBackSearchBooksButtonStudent(ActionListener listenForBackSearchBooksBtn){
        backFromSearchBooksStudentInsideSearch.addActionListener(listenForBackSearchBooksBtn);
    }

    //Listener for the back Button inside the View Books Librarian frame
    public void setBackViewBooksButtonLibrarian(ActionListener listenForBackViewBooksBtn){
        backButtonViewBooksLibrarian.addActionListener(listenForBackViewBooksBtn);
    }

    //Listener for the back button inside the View Books Student Frame
    public void setBackViewBooksButtonStudent(ActionListener listenForBackViewBooksBtn){
        backButtonViewBooksStudent.addActionListener(listenForBackViewBooksBtn);
    }

    //Listener for the register button inside the Student Register Frame
    public void setRegisterStudentButton(ActionListener listenForRegisterStudentRegisterButton){
        registerStudent.addActionListener(listenForRegisterStudentRegisterButton);
    }

    //Listener for the register button inside the Librarian Register Frame
    public void setRegisterLibrarianButton(ActionListener listenForRegisterLibrarianRegisterButton){
        registerLibrarian.addActionListener(listenForRegisterLibrarianRegisterButton);
    }

    //Listener for the back button inside the Student Register Frame
    public void setBackStudentRegister(ActionListener listenForBackStudentRegisterButton){
        backRegisterStudent.addActionListener(listenForBackStudentRegisterButton);
    }

    //Listener for the back button inside the Librarian Register Frame
    public void setBackLibrarianRegister(ActionListener listenForBackLibrarianRegisterButton){
        backRegisterLibrarian.addActionListener(listenForBackLibrarianRegisterButton);
    }

    //Listener for the Librarian Register button in first Register Frame
    public void setRegisterLibrarianWindow(ActionListener listenForLibrarianRegBtn){
        regAsLibrarianBtn.addActionListener(listenForLibrarianRegBtn);
    }

    //listener for the Student Register button in first Register Frame
    public void setRegisterStudentWindow(ActionListener listenForStudentRegBtn){
        regAsStudentBtn.addActionListener(listenForStudentRegBtn);
    }

    //Listener for the history button
    public void setHistoryFrame(ActionListener listenForHistoryButton){
        history.addActionListener(listenForHistoryButton);
    }

    //Listener for the contact button
    public void setContactFrame(ActionListener listenForContactButton){
        contact.addActionListener(listenForContactButton);
    }

    //Listener for the back button for the first history internal frame
    public void backStartPanel(ActionListener listenForBackButton){
        back.addActionListener(listenForBackButton);
    }

    //Listener for the back button for the second history internal frame
    public void backHistoryPanel(ActionListener listenForBack2Button){
        back2.addActionListener(listenForBack2Button);
    }

    //Listener for the next button in the first history internal frame
    public void nextStartPanel(ActionListener listenForNextButton){
        nextBtn.addActionListener(listenForNextButton);
    }

    //Listener for the back button in the contact internal frame
    public void backContactPanel(ActionListener listenForBackContactButton){backContact.addActionListener(listenForBackContactButton);}

    //Listener for the back button for the librarianLogin internal frame
    public void backLibrarianPanel(ActionListener listenForBackButton){
        backLibrarian.addActionListener(listenForBackButton);
    }

    //Listener for the login button for the librarian login internal frame
    public void loginLibrarianPanel(ActionListener listenForInnerLoginLibrarian){
        loginLib.addActionListener(listenForInnerLoginLibrarian);
    }

    //Listener for the back button for the studentLogin internal frame
    public void backStudentPanel(ActionListener listenForBackButton){
        backStudent.addActionListener(listenForBackButton);
    }

    //Listener for the login button for the student login internal frame
    public void loginStudentPanel(ActionListener listenForInnerLoginStudent){
        loginStudent.addActionListener(listenForInnerLoginStudent);
    }

    //Listener for the back button for the register first internal frame
    public void backFirstRegisterPanel(ActionListener listenForBackButton){
        registerBackButton.addActionListener(listenForBackButton);
    }

    //Listener for the addbooks button in the librarian after login frame
    public  void addBooksLibPanel(ActionListener listenForAddBooksButton){
        addBooks.addActionListener(listenForAddBooksButton);
    }

    //Listener for the viewBooksButton inside Librarian after login frame
    public void viewBooksButtonLibrarian(ActionListener listenerForViewBooks){
        viewBooksLibrarian.addActionListener(listenerForViewBooks);
    }

    //Listener for the viewBooksButton inside Student after login frame
    public void viewBooksButtonStudent(ActionListener listenerForViewBooks){
        viewBooksStudent.addActionListener(listenerForViewBooks);
    }


    //Listener for the remove by title button inside remove books internal frame
    public void removeBookByTitleButton(ActionListener listenForRemoveByTitleButton){
        removeBookByTitle.addActionListener(listenForRemoveByTitleButton);
    }

    //Listener for the remove by author button inside remove books internal frame
    public void removeBooksByAuthorButton(ActionListener listenForRemoveByAuthorButton){
        removeBookByAuthor.addActionListener(listenForRemoveByAuthorButton);
    }

    //Listener for the back button inside the remove books internal frame
    public void backRemoveBooksFrameButton(ActionListener listenForRemoveBooksBackButton){
        backFromRemoveBooksLibrarian.addActionListener(listenForRemoveBooksBackButton);
    }

    //Listener for the back button inside the addbooks internal frame
    public void backAddBooksFrameButton(ActionListener listenForBooksFrameBackButton){
        addBooksBackButton.addActionListener(listenForBooksFrameBackButton);
    }

    //Listener for the add books button inside the addbooks internal frame
    public void addBooksButtonAddBooks(ActionListener listenForAddBooksBtnAddBooks){
        addBookButton.addActionListener(listenForAddBooksBtnAddBooks);
    }

    //Listener for the logout librarian button
    public void logoutLibrarianBtn(ActionListener logoutLibButton){
        logoutLibrarian.addActionListener(logoutLibButton);
    }

    //Listener for the logout student button
    public void logoutStudentBtn(ActionListener logoutStdButton){
        logoutStudent.addActionListener(logoutStdButton);
    }

    //Listener for the search books button inside logged librarian frame
    public void searchBooksLibrarianButton(ActionListener searchBooksListener){
        searchBooksLibrarian.addActionListener(searchBooksListener);
    }

    //Listener for the search books button inside logged student frame
    public void searchBooksStudentButton(ActionListener searchBooksListener){
        searchBooksStudent.addActionListener(searchBooksListener);
    }

    //Listener for the search books by title librarian
    public void searchBooksInsideLibrarianButton(ActionListener searchBooksLibrarianListener){
        searchBooksLibrarianInsideSearchTitle.addActionListener(searchBooksLibrarianListener);
    }

    //Listener for the search books by author librarian
    public void searchAuthorInsideLibrarianButton(ActionListener searchAuthorLibrarianListener){
        searchBooksLibrarianInsideSearchAuthor.addActionListener(searchAuthorLibrarianListener);
    }

    //Listener for the search books by title student
    public void searchBooksInsideStudentButton(ActionListener searchBooksLibrarianListener){
        searchBooksStudentInsideSearchTitle.addActionListener(searchBooksLibrarianListener);
    }

    //Listener for the search books by author student
    public void searchAuthorInsideStudentButton(ActionListener searchAuthorLibrarianListener){
        searchBooksStudentInsideSearchAuthor.addActionListener(searchAuthorLibrarianListener);
    }

    //Internal Frame for the ViewBooks Frame Librarians
    public void setViewBooksLibrarian(String[][] data, String[] column){
        viewBooksIntFrameLibrarian = new JInternalFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        backButtonViewBooksLibrarian.setFont(new Font("Serif",Font.BOLD,20));

        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane,BorderLayout.CENTER);
        panel.add(backButtonViewBooksLibrarian,BorderLayout.SOUTH);
        viewBooksIntFrameLibrarian.add(panel);

        loggedLibrarianIntFrame.dispose();
        viewBooksIntFrameLibrarian.setVisible(true);
        this.add(viewBooksIntFrameLibrarian);

    }

    //Internal Frame for the SearchBooks by title Frame Librarian
    public void setSearchedBooksStudent(String[][]data, String[] column){

        searchedBooksStudentView = new JInternalFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //backButtonViewBooksLibrarian.setFont(new Font("Serif",Font.BOLD,20));

        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane,BorderLayout.CENTER);
        searchBooksBackButtonStudent.setFont(new Font("Serif",Font.BOLD,20));
        panel.add(searchBooksBackButtonStudent,BorderLayout.SOUTH);
        //panel.add(backButtonViewBooksStudent,BorderLayout.SOUTH);
        searchedBooksStudentView.add(panel);

        searchBooksIntFrameStudent.dispose();
        searchedBooksStudentView.setVisible(true);
        this.add(searchedBooksStudentView);

    }

    //Internal Frame for the SearchBooks by author Frame Librarian
    public void setSearchedAuthorStudentView(String[][] data, String[] column){

        searchedAuthorStudentView = new JInternalFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTable table = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane,BorderLayout.CENTER);
        searchBooksAuthorBackButtonStudent.setFont(new Font("Serif",Font.BOLD,20));
        panel.add(searchBooksAuthorBackButtonStudent,BorderLayout.SOUTH);
        searchedAuthorStudentView.add(panel);

        searchBooksIntFrameStudent.dispose();
        searchedAuthorStudentView.setVisible(true);
        this.add(searchedAuthorStudentView);

    }

    //Internal Frame for the SearchBooks by title Frame Librarian
    public void setSearchedBooksLibrarian(String[][]data, String[] column){

        searchedBooksLibrarianView = new JInternalFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //backButtonViewBooksLibrarian.setFont(new Font("Serif",Font.BOLD,20));

        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane,BorderLayout.CENTER);
        searchBooksBackButtonLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        panel.add(searchBooksBackButtonLibrarian,BorderLayout.SOUTH);
        //panel.add(backButtonViewBooksStudent,BorderLayout.SOUTH);
        searchedBooksLibrarianView.add(panel);

        searchBooksIntFrameLibrarian.dispose();
        searchedBooksLibrarianView.setVisible(true);
        this.add(searchedBooksLibrarianView);

    }

    //Internal Frame for the SearchBooks by author Frame Librarian
    public void setSearchedAuthorLibrarianView(String[][] data, String[] column){

        searchedAuthorLibrarianView = new JInternalFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTable table = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane,BorderLayout.CENTER);
        searchBooksAuthorBackButtonLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        panel.add(searchBooksAuthorBackButtonLibrarian,BorderLayout.SOUTH);
        searchedAuthorLibrarianView.add(panel);

        searchBooksIntFrameLibrarian.dispose();
        searchedAuthorLibrarianView.setVisible(true);
        this.add(searchedAuthorLibrarianView);

    }



    //Internal Frame for the ViewBooks Frame Students
    public void setViewBooksStudent(String[][] data, String[] column){
        viewBooksIntFrameStudent = new JInternalFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        backButtonViewBooksLibrarian.setFont(new Font("Serif",Font.BOLD,20));

        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane,BorderLayout.CENTER);
        panel.add(backButtonViewBooksStudent,BorderLayout.SOUTH);
        viewBooksIntFrameStudent.add(panel);

        loggedStudentIntFrame.dispose();
        viewBooksIntFrameStudent.setVisible(true);
        this.add(viewBooksIntFrameStudent);

    }

    //Internal Frame for the Remove Books Frame Librarian
    public void setRemoveBooksLibrarian(){

        removeBookLibrarian = new JInternalFrame();
        JPanel removeBooks = new JPanel();
        JPanel removeBooksInnerPanel = new JPanel();

        JLabel title = new JLabel("<html><u>Delete a book by name or delete all books by authors fullname!</u></html>");
        title.setFont(new Font("Serif",Font.BOLD,40));
        JLabel enterTitle = new JLabel("Enter Book Title: ",SwingConstants.CENTER);
        enterTitle.setFont(new Font("Serif",Font.BOLD,26));
        JLabel enterAuthor = new JLabel("Enter Author Fullname: ",SwingConstants.CENTER);
        enterAuthor.setFont(new Font("Serif",Font.BOLD,26));

        removeBookByTitle.setFont(new Font("Serif",Font.BOLD,20));
        removeBookByAuthor.setFont(new Font("Serif",Font.BOLD,20));
        backFromRemoveBooksLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        removeByBookTitle.setFont(new Font("Serif",Font.BOLD,20));
        removeByAuthorFullname.setFont(new Font("Serif",Font.BOLD,20));

        removeBooks.setLayout(new BorderLayout());
        removeBooks.add(title,BorderLayout.NORTH);
        removeBooks.add(removeBooksInnerPanel,BorderLayout.CENTER);

        removeBooksInnerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        removeBooksInnerPanel.add(title,gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        removeBooksInnerPanel.add(enterTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        removeBooksInnerPanel.add(enterAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        removeBooksInnerPanel.add(removeBookByTitle,gridBagConstraints);


        //
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        removeBooksInnerPanel.add(removeByBookTitle,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        removeBooksInnerPanel.add(removeByAuthorFullname,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        removeBooksInnerPanel.add(removeBookByAuthor,gridBagConstraints);
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        removeBooksInnerPanel.add(backFromRemoveBooksLibrarian,gridBagConstraints);

        loggedLibrarianIntFrame.dispose();
        removeBookLibrarian.add(removeBooks);
        removeBookLibrarian.setVisible(true);
        this.add(removeBookLibrarian);

    }

    //Internal Frame for the Search Books Frame Librarian
    public void setSearchBooksLibrarian(){

        searchBooksIntFrameLibrarian = new JInternalFrame();
        JPanel searchLibrarianPanel = new JPanel();
        JPanel searchLibrarianInnerPanel = new JPanel();
        JLabel frameTitle = new JLabel("Search by Title, Author or Both!");
        frameTitle.setFont(new Font("Serif",Font.BOLD,40));
        JLabel enterTitle = new JLabel("Enter Title: ",SwingConstants.CENTER);
        enterTitle.setFont(new Font("Serif",Font.BOLD,26));
        JLabel enterAuthor = new JLabel("Enter Author: ",SwingConstants.CENTER);
        enterAuthor.setFont(new Font("Serif",Font.BOLD,26));

        searchBooksLibrarianInsideSearchAuthor.setFont(new Font("Serif",Font.BOLD,20));
        searchBooksLibrarianInsideSearchTitle.setFont(new Font("Serif",Font.BOLD,20));
        searchBooksLibrarianInsideSearchBoth.setFont(new Font("Serif",Font.BOLD,20));
        backFromSearchBooksLibrarianInsideSearch.setFont(new Font("Serif",Font.BOLD,20));
        searchByTitleLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        searchByAuthorLibrarian.setFont(new Font("Serif",Font.BOLD,20));

        searchLibrarianPanel.setLayout(new BorderLayout());
        searchLibrarianPanel.add(frameTitle,BorderLayout.NORTH);
        searchLibrarianPanel.add(searchLibrarianInnerPanel,BorderLayout.CENTER);

        searchLibrarianInnerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        searchLibrarianInnerPanel.add(frameTitle,gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        searchLibrarianInnerPanel.add(enterTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        searchLibrarianInnerPanel.add(enterAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        searchLibrarianInnerPanel.add(searchBooksLibrarianInsideSearchTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        searchLibrarianInnerPanel.add(searchBooksLibrarianInsideSearchAuthor,gridBagConstraints);

        //
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        searchLibrarianInnerPanel.add(searchByTitleLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        searchLibrarianInnerPanel.add(searchByAuthorLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        searchLibrarianInnerPanel.add(searchBooksLibrarianInsideSearchBoth,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        searchLibrarianInnerPanel.add(backFromSearchBooksLibrarianInsideSearch,gridBagConstraints);




        loggedLibrarianIntFrame.dispose();
        searchBooksIntFrameLibrarian.add(searchLibrarianPanel);
        searchBooksIntFrameLibrarian.setVisible(true);
        this.add(searchBooksIntFrameLibrarian);

    }

    //Internal Frame for the Search Books Frame Student
    public void setSearchBooksStudent(){

        searchBooksIntFrameStudent = new JInternalFrame();
        JPanel searchStudentPanel = new JPanel();
        JPanel searchStudentInnerPanel = new JPanel();
        JLabel frameTitle = new JLabel("Search by Title, Author or Both!Student!");
        frameTitle.setFont(new Font("Serif",Font.BOLD,40));
        JLabel enterTitle = new JLabel("Enter Title: ",SwingConstants.CENTER);
        enterTitle.setFont(new Font("Serif",Font.BOLD,26));
        JLabel enterAuthor = new JLabel("Enter Author: ",SwingConstants.CENTER);
        enterAuthor.setFont(new Font("Serif",Font.BOLD,26));

        searchBooksStudentInsideSearchAuthor.setFont(new Font("Serif",Font.BOLD,20));
        searchBooksStudentInsideSearchTitle.setFont(new Font("Serif",Font.BOLD,20));
        searchBooksStudentInsideSearchBoth.setFont(new Font("Serif",Font.BOLD,20));
        backFromSearchBooksStudentInsideSearch.setFont(new Font("Serif",Font.BOLD,20));
        searchByTitleStudent.setFont(new Font("Serif",Font.BOLD,20));
        searchByAuthorStudent.setFont(new Font("Serif",Font.BOLD,20));

        searchStudentPanel.setLayout(new BorderLayout());
        searchStudentPanel.add(frameTitle,BorderLayout.NORTH);
        searchStudentPanel.add(searchStudentInnerPanel,BorderLayout.CENTER);

        searchStudentInnerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        searchStudentInnerPanel.add(frameTitle,gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        searchStudentInnerPanel.add(enterTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        searchStudentInnerPanel.add(enterAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        searchStudentInnerPanel.add(searchBooksStudentInsideSearchTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        searchStudentInnerPanel.add(searchBooksStudentInsideSearchAuthor,gridBagConstraints);

        //
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        searchStudentInnerPanel.add(searchByTitleStudent,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        searchStudentInnerPanel.add(searchByAuthorStudent,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        searchStudentInnerPanel.add(searchBooksStudentInsideSearchBoth,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        searchStudentInnerPanel.add(backFromSearchBooksStudentInsideSearch,gridBagConstraints);




        loggedStudentIntFrame.dispose();
        searchBooksIntFrameStudent.add(searchStudentPanel);
        searchBooksIntFrameStudent.setVisible(true);
        this.add(searchBooksIntFrameStudent);

    }

    //Getting back to the first search librarian internal frame from search by title
    public void setSearchBooksFirstFrameFromSearchTitleStudent(){
        searchedBooksStudentView.dispose();
        searchBooksIntFrameStudent.setVisible(true);
    }

    //Getting back to the first search Librarian internal frame from search by author
    public void setSearchBooksFirstFrameFromSearchAuthorStudent(){
        searchedAuthorStudentView.dispose();
        searchBooksIntFrameStudent.setVisible(true);
    }


    //Getting back to the first search librarian internal frame from search by title
    public void setSearchBooksFirstFrameFromSearchTitle(){
        searchedBooksLibrarianView.dispose();
        searchBooksIntFrameLibrarian.setVisible(true);
    }

    //Getting back to the first search Librarian internal frame from search by author
    public void setSearchBooksFirstFrameFromSearchAuthor(){
        searchedAuthorLibrarianView.dispose();
        searchBooksIntFrameLibrarian.setVisible(true);
    }

    //Getting back to the logged librarain from search books
    public void setLoggedLibrarianFromSearchBooks(){
        searchBooksIntFrameLibrarian.dispose();
        loggedLibrarianIntFrame.setVisible(true);
    }

    //Getting back to the logged student from search books
    public void setLoggedStudentFromSearchBooks(){
        searchBooksIntFrameStudent.dispose();
        loggedStudentIntFrame.setVisible(true);
    }


    //Getting back to logged librarian from view books
    public void setLoggedLibrarianFromViewBooks(){
        viewBooksIntFrameLibrarian.dispose();
        loggedLibrarianIntFrame.setVisible(true);
    }

    //Getting back to the logged student from view books
    public void setLoggedStudentFromViewBooks(){
        viewBooksIntFrameStudent.dispose();
        loggedStudentIntFrame.setVisible(true);
    }


    //Internal Frame for the addBooks Frame
    public void setAddBookIntFrame(){

        addBookIntFrame = new JInternalFrame();
        JPanel addOuterPanel = new JPanel();
        JPanel addBookPanel = new JPanel();

        JLabel title = new JLabel("<html><u>Enter following data to add new book!</u></html>");
        title.setFont(new Font("Serif",Font.BOLD,30));
        JLabel enterTitle = new JLabel("Enter Title: ");
        enterTitle.setFont(new Font("Serif",Font.BOLD,20));
        JLabel enterAuthor = new JLabel("Enter Author: ");
        enterAuthor.setFont(new Font("Serif",Font.BOLD,20));
        JLabel enterISBN = new JLabel("Enter ISBN: ");
        enterISBN.setFont(new Font("Serif",Font.BOLD,20));
        JLabel enterDate = new JLabel("Enter Date: ");
        enterDate.setFont(new Font("Serif",Font.BOLD,20));
        JLabel enterQuantity = new JLabel("Enter Quantity: ");
        enterQuantity.setFont(new Font("Serif",Font.BOLD,20));

        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Unity-3D-1.jpg").getImage().getScaledInstance(350,700,Image.SCALE_DEFAULT)));
        image1.setBorder(new LineBorder(Color.black,3));
        JLabel image2 = new JLabel();
        image2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\ultimate-list-of-programming-books.jpg").getImage().getScaledInstance(350,700,Image.SCALE_DEFAULT)));
        image2.setBorder(new LineBorder(Color.black,3));



        addBooksBackButton.setFont(new Font("Serif",Font.BOLD,20));;
        addBookButton.setFont(new Font("Serif",Font.BOLD,20));;
       // JTextField bookTitle = new JTextField(20);
        bookTitle.setFont(new Font("Serif",Font.BOLD,20));;
       // JTextField bookAuthor = new JTextField(20);
        bookAuthor.setFont(new Font("Serif",Font.BOLD,20));;
      //  JTextField bookISBN = new JTextField(20);
        bookISBN.setFont(new Font("Serif",Font.BOLD,20));;
     //   JTextField bookDate = new JTextField(20);
        bookDate.setFont(new Font("Serif",Font.BOLD,20));;
     //   JTextField bookQuantity = new JTextField(20);
        bookQuantity.setFont(new Font("Serif",Font.BOLD,20));;


        addOuterPanel.setLayout(new BorderLayout());
        addOuterPanel.add(addBookPanel,BorderLayout.CENTER);
        addOuterPanel.add(image1,BorderLayout.EAST);
        addOuterPanel.add(image2,BorderLayout.WEST);


        addBookPanel.setLayout(new GridBagLayout());
        addBookPanel.setBorder(new LineBorder(Color.black,3));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        addBookPanel.add(title,gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        addBookPanel.add(enterTitle,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        addBookPanel.add(bookTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        addBookPanel.add(enterAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        addBookPanel.add(bookAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        addBookPanel.add(enterISBN,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        addBookPanel.add(bookISBN,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        addBookPanel.add(enterDate,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        addBookPanel.add(bookDate,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        addBookPanel.add(enterQuantity,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        addBookPanel.add(bookQuantity,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        addBookPanel.add(addBookButton,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        addBookPanel.add(addBooksBackButton,gridBagConstraints);


        loggedLibrarianIntFrame.dispose();
        addBookIntFrame.add(addOuterPanel);
        addBookIntFrame.setVisible(true);
        this.add(addBookIntFrame);


    }

    //Internal Frame for the Librarian after Login window
    public void setLoggedLibrarian(){

        loggedLibrarianIntFrame = new JInternalFrame();
        JPanel loggedLibPanel = new JPanel();
        JPanel loggedLibInnerPanel = new JPanel();

        JLabel title = new JLabel("<html><br/><u>Welcome, Librarian!</u><br/> </html>",SwingConstants.CENTER);
        title.setBorder(new LineBorder(Color.black,3));
        title.setFont(new Font("Serif",Font.BOLD,35));

        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Unity-3D-1.jpg").getImage().getScaledInstance(450,700,Image.SCALE_DEFAULT)));
        image1.setBorder(new LineBorder(Color.black,3));
        JLabel image2 = new JLabel();
        image2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\ultimate-list-of-programming-books.jpg").getImage().getScaledInstance(450,700,Image.SCALE_DEFAULT)));
        image2.setBorder(new LineBorder(Color.black,3));


        addBooks.setFont(new Font("Serif",Font.BOLD,22));
        removeBooks.setFont(new Font("Serif",Font.BOLD,22));
        viewBooksLibrarian.setFont(new Font("Serif",Font.BOLD,22));
        searchBooksLibrarian.setFont(new Font("Serif",Font.BOLD,22));
        viewIssuedBooks.setFont(new Font("Serif",Font.BOLD,22));
        logoutLibrarian.setFont(new Font("Serif",Font.BOLD,22));

        loggedLibPanel.setLayout(new BorderLayout());
        loggedLibPanel.add(title,BorderLayout.NORTH);
        loggedLibPanel.add(image1,BorderLayout.WEST);
        loggedLibPanel.add(image2,BorderLayout.EAST);
        loggedLibPanel.add(loggedLibInnerPanel,BorderLayout.CENTER);

        loggedLibInnerPanel.setLayout(new GridBagLayout());
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
        loggedLibInnerPanel.add(addBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        loggedLibInnerPanel.add(removeBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        loggedLibInnerPanel.add(viewBooksLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        loggedLibInnerPanel.add(searchBooksLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        loggedLibInnerPanel.add(viewIssuedBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        loggedLibInnerPanel.add(logoutLibrarian,gridBagConstraints);


        librarianLoginPanel.dispose();
        loggedLibrarianIntFrame.add(loggedLibPanel);
        loggedLibrarianIntFrame.setVisible(true);
        this.add(loggedLibrarianIntFrame);


    }

    //Internal Frame for the Student after Login Window
    public void setLoggedStudent(){


        loggedStudentIntFrame = new JInternalFrame();
        JPanel loggedStdPanel = new JPanel();
        JPanel loggedStdInnerPanel = new JPanel();

        JLabel title = new JLabel("<html><br/><u>Welcome, Student!</u><br/> </html>",SwingConstants.CENTER);
        title.setBorder(new LineBorder(Color.black,3));
        title.setFont(new Font("Serif",Font.BOLD,35));

        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Unity-3D-1.jpg").getImage().getScaledInstance(450,700,Image.SCALE_DEFAULT)));
        image1.setBorder(new LineBorder(Color.black,3));
        JLabel image2 = new JLabel();
        image2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\ultimate-list-of-programming-books.jpg").getImage().getScaledInstance(450,700,Image.SCALE_DEFAULT)));
        image2.setBorder(new LineBorder(Color.black,3));


        returnBooks.setFont(new Font("Serif",Font.BOLD,22));
        viewBooksStudent.setFont(new Font("Serif",Font.BOLD,22));
        searchBooksStudent.setFont(new Font("Serif",Font.BOLD,22));
        studentTakeBooks.setFont(new Font("Serif",Font.BOLD,22));
        viewTakenBooks.setFont(new Font("Serif",Font.BOLD,22));
        logoutStudent.setFont(new Font("Serif",Font.BOLD,22));

        loggedStdPanel.setLayout(new BorderLayout());
        loggedStdPanel.add(title,BorderLayout.NORTH);
        loggedStdPanel.add(image1,BorderLayout.WEST);
        loggedStdPanel.add(image2,BorderLayout.EAST);
        loggedStdPanel.add(loggedStdInnerPanel,BorderLayout.CENTER);

        loggedStdInnerPanel.setLayout(new GridBagLayout());
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
        loggedStdInnerPanel.add(viewBooksStudent,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        loggedStdInnerPanel.add(searchBooksStudent,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        loggedStdInnerPanel.add(studentTakeBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        loggedStdInnerPanel.add(returnBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        loggedStdInnerPanel.add(viewTakenBooks,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        loggedStdInnerPanel.add(logoutStudent,gridBagConstraints);


        studentLoginPanel.dispose();
        loggedStudentIntFrame.add(loggedStdPanel);
        loggedStudentIntFrame.setVisible(true);
        this.add(loggedStudentIntFrame);


    }

    //Internal Frame for the contact window
    public void setContact(){
        contactPanel = new JInternalFrame();
        contactPanel.setTitle("Contact Us");
        contactPanel.setLayout(new BorderLayout());
        contactPanel.setBackground(Color.lightGray);


        JLabel locationPic = new JLabel("Here will be the pic");
        locationPic.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Loc.jpg").getImage().getScaledInstance(1280,400,Image.SCALE_DEFAULT)));
        locationPic.setBorder(new LineBorder(Color.black,5));

        JPanel contactInnerPanel = new JPanel();

        contactPanel.add(locationPic,BorderLayout.NORTH);
        contactPanel.add(contactInnerPanel,BorderLayout.CENTER);
        contactPanel.add(backContact,BorderLayout.SOUTH);



        JLabel address = new JLabel("<html><u>Address: Sofia 1504, 88 Vasil Levski blvd.</u></html>",SwingConstants.CENTER);
        address.setFont(new Font("Serif",Font.BOLD,30));
        JLabel secretary = new JLabel("<html><u>Secretary:</u><br/>Hristiana Koleva<br/>" +
                "Tel.: (+ 359 2) 9183/101;(+ 359) 878 273 403<br/>" +
                "e-mail: secretary@nationallibrary.bg</html>");
        secretary.setHorizontalAlignment(SwingConstants.CENTER);
        secretary.setFont(new Font("Serif",Font.BOLD,20));
        JLabel personalManager = new JLabel("<html><u>Personal Manager:</u><br/>Kornelia Lyubenova<br/>" +
                "Tel.: (+ 359 2) 9183/163<br/>" +
                "e-mail: k.lyubenova@nationallibrary.bg</html>");
        personalManager.setHorizontalAlignment(SwingConstants.CENTER);
        personalManager.setFont(new Font("Serif",Font.BOLD,20));
        JLabel publicRelations = new JLabel("<html><u>Public Relations:</u><br/>Violeta Tsvetkova<br/>" +
                "Tel.: (+ 359 2) 981 23 24; (+ 359 2) 9183 212<br/>" +
                "e-mail: v.tsvetkova@nationallibrary.bg</html>");
        publicRelations.setHorizontalAlignment(SwingConstants.CENTER);
        publicRelations.setFont(new Font("Serif",Font.BOLD,20));


        contactInnerPanel.setLayout(new BorderLayout(15,15));
        contactInnerPanel.setBorder(new EmptyBorder(15,15,15,15));
        contactInnerPanel.add(address,BorderLayout.NORTH);
        contactInnerPanel.add(secretary,BorderLayout.CENTER);
        contactInnerPanel.add(personalManager,BorderLayout.WEST);
        contactInnerPanel.add(backContact,BorderLayout.SOUTH);
        contactInnerPanel.add(publicRelations,BorderLayout.EAST);






        startPanel.hide();
        contactPanel.setVisible(true);
        this.add(contactPanel);

    }

    //Internal Frame for the first history window
    public void setHistory(){
        historyPanel = new JInternalFrame();
        //historyPanel.setLayout(new BorderLayout(5,5));
        JLabel historyTitle1 = new JLabel("The History of the Sofia National Library Part I",SwingConstants.CENTER);
        historyTitle1.setFont(new Font("Serif",Font.BOLD,34));
        historyTitle1.setBorder(new LineBorder(Color.black,3));

        historyTitle1.setOpaque(true);;
        historyTitle1.setBackground(Color.lightGray);
        JLabel historyText1 = new JLabel("<html><br/>The SS. Cyril and Methodius National Library (Национална библиотека <br/>" +
                "„Свети Свети Кирил и Методий“) is the national library of Bulgaria, situated <br/>" +
                "in the capital city of Sofia. Founded on 4 April 1878, the library received the<br/>" +
                " status of Bulgarian National Library three years later and the Bulgarian National<br/>"+
                "Revival Archive was merged into it in 1924.<br/>" +
                "<br/>" +
                "It is named after \"SS. Cyril and Methodius\"; Saints Cyril and Methodius. They are <br/>" +
                "the creators of the Glagolitic alphabet. The Cyrillic alphabet is named after Cyril.<br/>" +
                "<br/>" +
                "The present building of the library is among the landmarks of Sofia. It was designed <br/>" +
                "by the famous Bulgarian architectural team Vasilyov-Dimitur Tsolov and completed in <br/>" +
                "the period 1940-1953." +
                "<br/><br/>" +
                "Notabale Collections: <br/>" +
                "  Slavonic Scriptures, a collection of around 1700 originals dating from 11th century!" +
                "<br/>"+
                "  Eastern Scriptures, containing around 3100 Arabic and 500 Ottoman codicies. " +
                "<br/>" +
                "  Bulgarian Historical Archive with over 1.5 million documents under 700 separate<br/>" +
                "      archives covering the work of Bulgarian revolutionaires, economic, cultural<br/>" +
                "      and public people.</html>");
        historyText1.setFont(new Font("Serif",Font.BOLD,22));
        historyText1.setOpaque(true);
        historyText1.setBackground(Color.lightGray);

        back.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\back.jpg").getImage().getScaledInstance(200,550,Image.SCALE_DEFAULT)));
        back.setBackground(Color.LIGHT_GRAY);

        nextBtn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\next.jpg").getImage().getScaledInstance(200,550,Image.SCALE_DEFAULT)));
        nextBtn.setBackground(Color.LIGHT_GRAY);

        historyPanel.add(historyText1,BorderLayout.CENTER);
        historyPanel.add(historyTitle1,BorderLayout.NORTH);
        historyPanel.add(back,BorderLayout.WEST);
        historyPanel.add(nextBtn,BorderLayout.EAST);
        startPanel.hide();
        historyPanel.setVisible(true);

        this.add(historyPanel);
    }

    //Internal Frame for the second history window
    public void setHistorySecond(){
        historyNextPanel = new JInternalFrame();
        //historyNextPanel.setLayout(new BorderLayout(5,5));
        JLabel historyTitle2 = new JLabel("The History of the Sofia National Library Part II",SwingConstants.CENTER);
        historyTitle2.setFont(new Font("Serif",Font.BOLD,34));
        historyTitle2.setOpaque(true);
        historyTitle2.setBorder(new LineBorder(Color.black,3));
        historyTitle2.setBackground(Color.lightGray);
        JLabel historyText2 = new JLabel("<html>The SS. Cyril and Methodius National Library is currently the largest<br/>" +
                "public library in Bulgaria and the oldest cultural institution after the <br/>" +
                "country's liberation, and also houses one of the richest Ottoman archival<br/>" +
                "collections.<br/>" +
                "<br/>" +
                "In 1878, Mikhail Bobotinov, a teacher and secretary of the City Council in Sofia,<br/>" +
                "proposed to establish a public library for the need of cultural and educational<br/>" +
                "development in Sofia. The library was then arranged and open in 1878 and<br/>" +
                "finally received its own building in 1900. In 1939, a new building began <br/>" +
                "construction, but sadly in 1944 both the new and old building were <br/>" +
                "destroyed during a bombing in Sofia.<br/>" +
                "<br/>"+
                "In 1953, the National Library opens its new building under the name<br/>" +
                " \"Vasil Kolarov\".<br/>" +
                "It was not until 1963 that the library was renamed from \"Vasil Kolarov\" to<br/>" +
                "\"St. Cyril and Methodius\"</html>");
        historyText2.setFont(new Font("Serif",Font.BOLD,22));
        historyText2.setOpaque(true);
        historyText2.setBackground(Color.lightGray);

        JLabel imageSpace = new JLabel();
        imageSpace.setPreferredSize(new Dimension(250,460));
        imageSpace.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\2.jpg").getImage().getScaledInstance(250,560,Image.SCALE_DEFAULT)));
        imageSpace.setBorder(new LineBorder(Color.black,3));

        JLabel imageSpace1 = new JLabel();
        imageSpace1.setPreferredSize(new Dimension(250,460));
        imageSpace1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\1.jpeg").getImage().getScaledInstance(250,560,Image.SCALE_DEFAULT)));
        imageSpace1.setBorder(new LineBorder(Color.black,3));

        imageSpace1.setOpaque(true);
        imageSpace.setOpaque(true);
        imageSpace1.setBackground(Color.LIGHT_GRAY);
        imageSpace.setBackground(Color.LIGHT_GRAY);
        historyNextPanel.add(historyText2,BorderLayout.CENTER);
        historyNextPanel.add(back2,BorderLayout.SOUTH);
        historyNextPanel.add(historyTitle2,BorderLayout.NORTH);
        historyNextPanel.add(imageSpace,BorderLayout.WEST);
        historyNextPanel.add(imageSpace1,BorderLayout.EAST);
        //historyPanel.hide();
        historyPanel.dispose();
        historyNextPanel.setVisible(true);
        this.add(historyNextPanel);

    }

    //Internal Frame for the Librarian Login window
    public void setLibrarianLogin(){

        librarianLoginPanel = new JInternalFrame();
        JPanel libPanel = new JPanel();
        JLabel logInLabel = new JLabel("<html><u>Login to Your Account, Librarian!</u></html>");
        logInLabel.setFont(new Font("Serif",Font.BOLD,31));
        JLabel uname = new JLabel("Enter Username");
        uname.setFont(new Font("Serif",Font.BOLD,20));
        JLabel pass = new JLabel("Enter Password");
        pass.setFont(new Font("Serif",Font.BOLD,20));
        librarianLoginUsername = new JTextField(20);
        librarianLoginUsername.setFont(new Font("Serif",Font.BOLD,20));
        librarianLoginPassword = new JPasswordField(20);
        librarianLoginPassword.setFont(new Font("Serif",Font.BOLD,20));
        loginLib.setFont(new Font("Serif",Font.BOLD,20));
        backLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\lib.jpg").getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT)));

        libPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 1; //position
        gridBagConstraints.gridy = 1; //position
        /* How many columns the components gonna take out */
        gridBagConstraints.gridwidth = 20;
        /* How many rows */
        gridBagConstraints.gridheight = 1;
        /* How to fit the component (0 is default)*/
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        //Handle padding around the components
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        libPanel.add(logInLabel,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        libPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        libPanel.add(librarianLoginUsername,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        libPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        libPanel.add(librarianLoginPassword,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        libPanel.add(loginLib,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        libPanel.add(backLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        libPanel.add(imageLabel,gridBagConstraints);



        startPanel.hide();
        libPanel.setBackground(Color.LIGHT_GRAY);
        librarianLoginPanel.add(libPanel);
        librarianLoginPanel.setVisible(true);
        this.add(librarianLoginPanel);



    }

    //Internal Frame for the Student Login window
    public void setStudentLogin(){

        studentLoginPanel = new JInternalFrame();
        JPanel studPanel = new JPanel();
        JLabel logInLabel = new JLabel("<html><u>Login to Your Account, Student!</u></html>");
        logInLabel.setFont(new Font("Serif",Font.BOLD,32));
        JLabel uname = new JLabel("Enter Username");
        uname.setFont(new Font("Serif",Font.BOLD,20));
        JLabel pass = new JLabel("Enter Password");
        pass.setFont(new Font("Serif",Font.BOLD,20));
        studentLoginUsername = new JTextField(20);
        studentLoginUsername.setFont(new Font("Serif",Font.BOLD,20));
        studentLoginPassword = new JPasswordField(20);
        studentLoginPassword.setFont(new Font("Serif",Font.BOLD,20));
        loginStudent.setFont(new Font("Serif",Font.BOLD,20));
        backStudent.setFont(new Font("Serif",Font.BOLD,20));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\stud.jpg").getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT)));

        studPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 1; //position
        gridBagConstraints.gridy = 1; //position
        /* How many columns the components gonna take out */
        gridBagConstraints.gridwidth = 20;
        /* How many rows */
        gridBagConstraints.gridheight = 1;
        /* How to fit the component (0 is default)*/
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        //Handle padding around the components
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        studPanel.add(logInLabel,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        studPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        studPanel.add(studentLoginUsername,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        studPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        studPanel.add(studentLoginPassword,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        studPanel.add(loginStudent,gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        studPanel.add(backStudent,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        studPanel.add(imageLabel,gridBagConstraints);



        startPanel.hide();
        studPanel.setBackground(Color.LIGHT_GRAY);
        studentLoginPanel.add(studPanel);
        studentLoginPanel.setVisible(true);
        this.add(studentLoginPanel);

    }

    //Internal Frame for the First Register window
    public void setRegister(){

        registerPanel = new JInternalFrame();
        JPanel regMainPanel = new JPanel();
        JPanel regPanel = new JPanel();
        JLabel title = new JLabel("<html><u>Register your type of account!</u></html>");
        title.setFont(new Font("Serif",Font.BOLD,34));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Register.gif").getImage().getScaledInstance(430,250,Image.SCALE_DEFAULT)));

        JLabel imageLabel1 = new JLabel();
        imageLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\1.jpeg").getImage().getScaledInstance(200,720,Image.SCALE_DEFAULT)));
        imageLabel1.setBorder(new LineBorder(Color.BLACK,3));

        JLabel imageLabel2 = new JLabel();
        imageLabel2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\2.jpg").getImage().getScaledInstance(200,720,Image.SCALE_DEFAULT)));
        imageLabel2.setBorder(new LineBorder(Color.BLACK,3));

        registerBackButton.setFont(new Font("Serif",Font.BOLD,20));
        regAsLibrarianBtn.setFont(new Font("Serif",Font.BOLD,20));
        regAsStudentBtn.setFont(new Font("Serif",Font.BOLD,20));

        regMainPanel.setLayout(new BorderLayout());
        regMainPanel.setBackground(Color.lightGray);
        regMainPanel.add(regPanel,BorderLayout.CENTER);
        regMainPanel.add(imageLabel1,BorderLayout.WEST);
        regMainPanel.add(imageLabel2,BorderLayout.EAST);


        regPanel.setLayout(new GridBagLayout());
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
        regPanel.add(title,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        regPanel.add(regAsLibrarianBtn,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        regPanel.add(regAsStudentBtn,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        regPanel.add(registerBackButton,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        regPanel.add(imageLabel,gridBagConstraints);




        startPanel.hide();
        regPanel.setBackground(Color.LIGHT_GRAY);
        registerPanel.add(regMainPanel);
        registerPanel.setVisible(true);
        this.add(registerPanel);

    }

    //Internal Frame for the Librarian Register window
    public void setRegisterLibrarian(){

        registerLibrarianPanel = new JInternalFrame();
        JPanel regLibPanel = new JPanel();
        registerUnameLibrarian = new JTextField(20);
        registerUnameLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        registerEmailLibrarian = new JTextField(20);
        registerEmailLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        registerPassLibrarian = new JPasswordField(20);
        registerPassLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        secretWordLibrarian = new JTextField();
        secretWordLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        registerLibrarian.setFont(new Font("Serif",Font.BOLD,20));
        backRegisterLibrarian.setFont(new Font("Serif",Font.BOLD,20));

        JLabel title = new JLabel("Enter your data:");
        title.setFont(new Font("Serif", Font.BOLD, 28));
        JLabel uname = new JLabel("Username: ");
        uname.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel pass = new JLabel("Password: ");
        pass.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel secretWord = new JLabel("Secred word: ");
        secretWord.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Document.jpg").getImage().getScaledInstance(430,300,Image.SCALE_DEFAULT)));
       // JLabel image1 = new JLabel();
       // image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\darrow.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT)));


        regLibPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        regLibPanel.add(title,gridBagConstraints);
       // gridBagConstraints.gridwidth = 12;
       // gridBagConstraints.gridx = 5;
       // gridBagConstraints.gridy = 1;
       // regStdPanel.add(image1,gridBagConstraints);

        //
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        regLibPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        regLibPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        regLibPanel.add(email,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        regLibPanel.add(secretWord,gridBagConstraints);

        //
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        regLibPanel.add(registerUnameLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        regLibPanel.add(registerPassLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        regLibPanel.add(registerEmailLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        regLibPanel.add(secretWordLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        regLibPanel.add(registerLibrarian,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        regLibPanel.add(backRegisterLibrarian,gridBagConstraints);
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        regLibPanel.add(image,gridBagConstraints);

        registerPanel.dispose();
        //registerStudentPanel.setBackground(Color.LIGHT_GRAY);
        registerLibrarianPanel.add(regLibPanel);
        registerLibrarianPanel.setVisible(true);
        this.add(registerLibrarianPanel);

    }

    //Internal Frame for the Student Register window
    public void setRegisterStudent(){

        registerStudentPanel = new JInternalFrame();
        JPanel regStdPanel = new JPanel();
        registerUnameStudent = new JTextField(20);
        registerUnameStudent.setFont(new Font("Serif",Font.BOLD,20));
        registerEmailStudent = new JTextField(20);
        registerEmailStudent.setFont(new Font("Serif",Font.BOLD,20));
        registerPassStudent = new JPasswordField(20);
        registerPassStudent.setFont(new Font("Serif",Font.BOLD,20));
        secretWordStudent = new JTextField();
        secretWordStudent.setFont(new Font("Serif",Font.BOLD,20));
        registerStudent.setFont(new Font("Serif",Font.BOLD,20));
        backRegisterStudent.setFont(new Font("Serif",Font.BOLD,20));

        JLabel title = new JLabel("Enter your data:");
        title.setFont(new Font("Serif", Font.BOLD, 28));
        JLabel uname = new JLabel("Username: ");
        uname.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel pass = new JLabel("Password: ");
        pass.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel secretWord = new JLabel("Secred word: ");
        secretWord.setFont(new Font("Serif", Font.BOLD, 20));
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\thumb.jpg").getImage().getScaledInstance(430,300,Image.SCALE_DEFAULT)));
        // JLabel image1 = new JLabel();
        // image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\darrow.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT)));


        regStdPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        regStdPanel.add(title,gridBagConstraints);
        // gridBagConstraints.gridwidth = 12;
        // gridBagConstraints.gridx = 5;
        // gridBagConstraints.gridy = 1;
        // regStdPanel.add(image1,gridBagConstraints);

        //
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        regStdPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        regStdPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        regStdPanel.add(email,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        regStdPanel.add(secretWord,gridBagConstraints);

        //
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        regStdPanel.add(registerUnameStudent,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        regStdPanel.add(registerPassStudent,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        regStdPanel.add(registerEmailStudent,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        regStdPanel.add(secretWordStudent,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        regStdPanel.add(registerStudent,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        regStdPanel.add(backRegisterStudent,gridBagConstraints);
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        regStdPanel.add(image,gridBagConstraints);

        registerPanel.dispose();
        //registerStudentPanel.setBackground(Color.LIGHT_GRAY);
        registerStudentPanel.add(regStdPanel);
        registerStudentPanel.setVisible(true);
        this.add(registerStudentPanel);

    }

    //Internal Frame for the Forgot Password window
    public void setForgotPass(){}

    //getting back to the logged librarian panel from the remove books frame
    public void setLoggedLibrarianFromRemoveBooks(){
        removeBookLibrarian.dispose();
        loggedLibrarianIntFrame.setVisible(true);
    }

    //getting back to the logged librarian panel from the add books frame
    public void setLoggedLibrarianFromAddBooks(){
        loggedLibrarianIntFrame.setVisible(true);
        addBookIntFrame.dispose();
    }

    //getting back from librarian login frame to the start frame
    public void setLogoutLibrarian(){
        loggedLibrarianIntFrame.dispose();
        startPanel.setVisible(true);

    }

    //getting back from the student login frame to the start frame
    public void setLogoutStudent(){
        loggedStudentIntFrame.dispose();
        startPanel.setVisible(true);
    }

    //getting back to the first Register Panel from the Librarian Register frame
    public void setFirstRegFromLibReg(){
        registerPanel.setVisible(true);
        registerLibrarianPanel.dispose();
    }

    //getting back to the first Register Panel from the Student Register frame
    public void setFirstRegFromStdReg(){
        registerPanel.setVisible(true);
        registerStudentPanel.dispose();
    }

    //getting back to the Start Panel from the first Registration frame
    public void setStartPanelFirstRegistration(){
        startPanel.setVisible(true);
        registerPanel.dispose();
    }

    //getting back to the Start Panel from the first history frame
    public void setStartPanel(){
        startPanel.setVisible(true);
        historyPanel.dispose();
    }

    //getting back to the Start Panel from the librarian frame
    public void setStartPanelLibrarian(){
        startPanel.setVisible(true);
        librarianLoginPanel.dispose();
    }

    //getting back to the Start Panel from the student frame
    public void setStartPanelStudent(){
        startPanel.setVisible(true);
        studentLoginPanel.dispose();
    }

    //getting back to the first History Panel
    public void setHistoryPanel(){
        historyPanel.setVisible(true);
        historyNextPanel.dispose();
    }

    //getting back to the Start Panel from the contact frame
    public void setStartPanelAgain(){
        startPanel.setVisible(true);
        contactPanel.dispose();
    }


    public String getUsernameLibrarian(){
        return librarianLoginUsername.getText();
    }

    public String getPasswordLibrarian(){
        return librarianLoginPassword.getText();
    }

    public String getUsernameStudent(){
        return studentLoginUsername.getText();
    }

    public String getPasswordStudent(){
        return studentLoginPassword.getText();
    }

    public String getUsernameRegisterStudent(){
        return registerUnameStudent.getText();
    }

    public String getPasswordRegisterStudent(){
        return registerPassStudent.getText();
    }

    public String getEmailRegisterStudent(){
        return registerEmailStudent.getText();
    }

    public String getSecretWordRegisterStudent(){
        return secretWordStudent.getText();
    }

    public String getUsernameRegisterLibrarian(){
        return registerUnameLibrarian.getText();
    }

    public String getPasswordRegisterLibrarian(){
        return registerPassLibrarian.getText();
    }

    public String getEmailRegisterLibrarian(){
        return registerEmailLibrarian.getText();
    }

    public String getSecretWordRegisterLibrarian(){
        return secretWordLibrarian.getText();
    }

    public String getBookTitle(){
        return bookTitle.getText();
    }

    public String getBookAuthor(){
        return bookAuthor.getText();
    }

    public int getBookISBN(){
        try{
            return Integer.parseInt(bookISBN.getText().trim());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Date getBookDate(){
        Date da = null;
        try {
            da = Date.valueOf(bookDate.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
        return da;
    }

    public int getBookQuantity(){
        return Integer.parseInt(bookQuantity.getText().trim());
    }

    public String getSearchedTitle(){
        return searchByTitleLibrarian.getText();
    }

    public String getSearchedAuthor(){return searchByAuthorLibrarian.getText();}

    public String getSearchedTitleStudent(){return searchByTitleStudent.getText();}

    public String getSearchedAuthorStudent(){return searchByAuthorStudent.getText();}

    public String getRemovedTitleBook(){
        return removeByBookTitle.getText();
    }

    public String getRemovedAuthorBooks(){
        return removeByAuthorFullname.getText();
    }

    public void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this,errorMessage);

    }



}
