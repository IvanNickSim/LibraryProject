package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class ViewBooksScreen extends JFrame{

    private JPanel viewBooksPanel;
    private JButton backBtn = new JButton("Back");
    private boolean isStudent = false;
    private String[][] data;
    private String[] column;



    public ViewBooksScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - view books screen");

        viewBooksPanel = new JPanel();
        viewBooksPanel.setLayout(new BorderLayout());
        backBtn.setFont(new Font("Serif",Font.BOLD,20));


/*
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        viewBooksPanel.add(scrollPane,BorderLayout.CENTER);*/
        viewBooksPanel.add(backBtn,BorderLayout.SOUTH);



        this.add(viewBooksPanel);

    }

    public void setViewBooksTable(String[][]data, String[] column){
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        viewBooksPanel.add(scrollPane,BorderLayout.CENTER);

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
