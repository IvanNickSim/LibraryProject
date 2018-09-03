package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class RemoveBooksScreen extends JFrame{

    private JPanel removeBooksPanel;
    private JButton removeBookTitle = new JButton("Remove book by title");
    private JButton removeBookAuthor = new JButton("Remove all books from author");
    private JButton backBtn = new JButton("Back");
    private JTextField removeByBookTitle;
    private JTextField removeByBookAuthor;

    public RemoveBooksScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - remove books screen");

        removeBooksPanel = new JPanel();
        JPanel removeBooksInnerPanel = new JPanel();
        removeByBookAuthor = new JTextField(20);
        removeByBookTitle = new JTextField(20);
        JLabel title = new JLabel("<html><u>Delete book by name or delete all books by author!</u></html>");
        title.setFont(new Font("Serif",Font.BOLD,30));
        JLabel enterTitle = new JLabel("Enter Book Title: ",SwingConstants.CENTER);
        JLabel enterAuthor = new JLabel("Enter Author Fullname: ",SwingConstants.CENTER);

        JComponent[] components = new JComponent[7];
        components[0] = removeBookTitle;
        components[1] = removeBookAuthor;
        components[2] = backBtn;
        components[3] = removeByBookTitle;
        components[4] = removeByBookAuthor;
        components[5] = enterTitle;
        components[6] = enterAuthor;

        for (JComponent x: components
             ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        removeBooksPanel.setLayout(new BorderLayout());
        removeBooksPanel.add(title,BorderLayout.NORTH);
        removeBooksPanel.add(removeBooksInnerPanel,BorderLayout.CENTER);

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
        removeBooksInnerPanel.add(removeBookTitle,gridBagConstraints);


        //
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        removeBooksInnerPanel.add(removeByBookTitle,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        removeBooksInnerPanel.add(removeByBookAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        removeBooksInnerPanel.add(removeBookAuthor,gridBagConstraints);
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        removeBooksInnerPanel.add(backBtn,gridBagConstraints);

        this.add(removeBooksPanel);


    }

    public void backBtnListener(ActionListener listenBack){
        backBtn.addActionListener(listenBack);
    }

    public void removeBookByTitle(ActionListener listenRemoveByTitle){
        removeBookTitle.addActionListener(listenRemoveByTitle);
    }

    public void removeBooksByAuthor(ActionListener listenRemoveByAuthor){
        removeBookAuthor.addActionListener(listenRemoveByAuthor);
    }

    public void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this,errorMessage);

    }


}
