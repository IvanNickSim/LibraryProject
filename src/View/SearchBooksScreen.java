package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class SearchBooksScreen extends JFrame{

    private JPanel searchBooksPanel;
    private JButton searchBooksTitle = new JButton("Search books by title");
    private JButton searchBooksAuthor = new JButton("Search books by author");
    private JButton searchBooksBoth = new JButton("Search books by both");
    private JButton back = new JButton("Back");
    private JTextField searchByTitle;
    private JTextField searchByAuthor;
    private boolean isStudent = false;

    public SearchBooksScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - search books screen");

        searchBooksPanel = new JPanel();
        JPanel searchBooksInnerPanel = new JPanel();
        searchByTitle = new JTextField(20);
        searchByAuthor = new JTextField(20);

        JLabel title = new JLabel("<html><u>Search by title, author or both!</u></html>");
        title.setFont(new Font("Serif",Font.BOLD,40));
        JLabel enterTitle = new JLabel("Enter Title: ",SwingConstants.CENTER);
        JLabel enterAuthor = new JLabel("Enter Author: ",SwingConstants.CENTER);

        JComponent[] components = new JComponent[8];
        components[0] = enterTitle;
        components[1] = enterAuthor;
        components[2] = searchBooksTitle;
        components[3] = searchBooksAuthor;
        components[4] = searchBooksBoth;
        components[5] = back;
        components[6] = searchByTitle;
        components[7] = searchByAuthor;

        for (JComponent x: components
             ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        searchBooksPanel.setLayout(new BorderLayout());
        searchBooksPanel.add(title,BorderLayout.NORTH);
        searchBooksPanel.add(searchBooksInnerPanel,BorderLayout.CENTER);

        searchBooksInnerPanel.setLayout(new GridBagLayout());
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
        searchBooksInnerPanel.add(title,gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        searchBooksInnerPanel.add(enterTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        searchBooksInnerPanel.add(enterAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        searchBooksInnerPanel.add(searchBooksTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        searchBooksInnerPanel.add(searchBooksAuthor,gridBagConstraints);

        //
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        searchBooksInnerPanel.add(searchByTitle,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        searchBooksInnerPanel.add(searchByAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        searchBooksInnerPanel.add(searchBooksBoth,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        searchBooksInnerPanel.add(back,gridBagConstraints);

        this.add(searchBooksPanel);

    }

    public void backBtnListener(ActionListener backListen){
        back.addActionListener(backListen);
    }

    public boolean getIsStudent(){
        return isStudent;
    }

    public void setIsStudent(boolean isStudents){
        this.isStudent = isStudents;
    }

    public void searchByTitleBtnListner(ActionListener listenSearchTitle){
        searchBooksTitle.addActionListener(listenSearchTitle);
    }

    public void searchByAuthorBtnListener(ActionListener listenSearchAuthor){
        searchBooksAuthor.addActionListener(listenSearchAuthor);
    }

    public void searchByBothBtnListener(ActionListener listenSearchBoth){
        searchBooksBoth.addActionListener(listenSearchBoth);
    }

    public void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this,errorMessage);

    }

    public String getSearchedTitle(){
        return searchByTitle.getText();
    }

    public String getSearchedAuthor(){return searchByAuthor.getText();}


    public void setSearchedBooks(String[][]data, String[] column){
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        searchBooksPanel.add(scrollPane,BorderLayout.CENTER);

    }




    //Internal Frame for the SearchBooks by author Frame Librarian
    public void setSearchedAuthor(String[][] data, String[] column){



        JTable table = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(table);

        searchBooksPanel.add(scrollPane,BorderLayout.CENTER);
    }

    public String getSearchByTitle(){
        return this.searchByTitle.toString();
    }

    public void setSearchByTitle(String title){
        this.searchByTitle.setText(title);
    }

    public String getSearchByAuthor(){
        return this.searchByAuthor.toString();
    }

    public void setSearchByAuthor(String author){
        this.searchByAuthor.setText(author);
    }

}
