package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 04/09/2018.
 */
public class ViewSearchedBooksScreen extends JFrame {

    private JPanel viewSearchBooksPanel = new JPanel();
    private JButton backBtn = new JButton("Back");
    private boolean isStudent;
    private String[][] data;
    private String[] column;


    public ViewSearchedBooksScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - view searched books screen");

        viewSearchBooksPanel = new JPanel();
        viewSearchBooksPanel.setLayout(new BorderLayout());
        backBtn.setFont(new Font("Serif",Font.BOLD,20));


/*
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        viewBooksPanel.add(scrollPane,BorderLayout.CENTER);*/
        viewSearchBooksPanel.add(backBtn,BorderLayout.SOUTH);



        this.add(viewSearchBooksPanel);

    }

    public void setViewSearchBooksTable(String[][]data, String[] column){
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        viewSearchBooksPanel.add(scrollPane,BorderLayout.CENTER);

    }

    public void backBtnListener(ActionListener backListen){

        backBtn.addActionListener(backListen);
    }

    public boolean getIsStudent(){
        return isStudent;
    }

    public void setIsStudent(boolean isStudents){
        this.isStudent = isStudents;
    }

}
