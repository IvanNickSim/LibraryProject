package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class AddBooksScreen extends JFrame{

    private JPanel addBooksPanel;
    private JButton addBooksBackButton = new JButton("Back");
    private JButton addBookButton = new JButton("Add Book");
    private JTextField bookTitle;
    private JTextField bookAuthor;
    private JTextField bookISBN;
    private JTextField bookDate;
    private JTextField bookQuantity;

    public AddBooksScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - add books screen");

        addBooksPanel = new JPanel();
        JPanel addBooksInnerPanel = new JPanel();
        bookTitle = new JTextField(20);
        bookAuthor = new JTextField(20);
        bookISBN = new JTextField(20);
        bookDate = new JTextField(20);
        bookQuantity = new JTextField(20);
        JLabel title = new JLabel("<html><u>Enter following data to add new book!</u></html>");
        title.setFont(new Font("Serif",Font.BOLD,30));
        JLabel enterTitle = new JLabel("Enter Title: ");
        JLabel enterAuthor = new JLabel("Enter Author: ");
        JLabel enterISBN = new JLabel("Enter ISBN: ");
        JLabel enterDate = new JLabel("Enter Date: ");
        JLabel enterQuantity = new JLabel("Enter Quantity: ");
        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Unity-3D-1.jpg").getImage().getScaledInstance(350,700,Image.SCALE_DEFAULT)));
        image1.setBorder(new LineBorder(Color.black,3));
        JLabel image2 = new JLabel();
        image2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\ultimate-list-of-programming-books.jpg").getImage().getScaledInstance(350,700,Image.SCALE_DEFAULT)));
        image2.setBorder(new LineBorder(Color.black,3));

        JComponent[] components = new JComponent[12];
        components[0] = enterTitle;
        components[1] = enterAuthor;
        components[2] = enterISBN;
        components[3] = enterDate;
        components[4] = enterQuantity;
        components[5] = bookTitle;
        components[6] = bookAuthor;
        components[7] = bookISBN;
        components[8] = bookDate;
        components[9] = bookQuantity;
        components[10] = addBooksBackButton;
        components[11] = addBookButton;

        for (JComponent x: components
             ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        addBooksPanel.setLayout(new BorderLayout());
        addBooksPanel.add(addBooksInnerPanel,BorderLayout.CENTER);
        addBooksPanel.add(image1,BorderLayout.EAST);
        addBooksPanel.add(image2,BorderLayout.WEST);


        addBooksInnerPanel.setLayout(new GridBagLayout());
        addBooksInnerPanel.setBorder(new LineBorder(Color.black,3));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        addBooksInnerPanel.add(title,gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        addBooksInnerPanel.add(enterTitle,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        addBooksInnerPanel.add(bookTitle,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        addBooksInnerPanel.add(enterAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        addBooksInnerPanel.add(bookAuthor,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        addBooksInnerPanel.add(enterISBN,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        addBooksInnerPanel.add(bookISBN,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        addBooksInnerPanel.add(enterDate,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        addBooksInnerPanel.add(bookDate,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        addBooksInnerPanel.add(enterQuantity,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        addBooksInnerPanel.add(bookQuantity,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        addBooksInnerPanel.add(addBookButton,gridBagConstraints);
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        addBooksInnerPanel.add(addBooksBackButton,gridBagConstraints);

        this.add(addBooksPanel);

    }

    public void backBtnListener(ActionListener backListen){
        addBooksBackButton.addActionListener(backListen);
    }

}
