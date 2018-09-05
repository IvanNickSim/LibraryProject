package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 05/09/2018.
 */
public class ViewIssuedBooksScreen extends JFrame{

    private JPanel viewIssuedBooksPanel = new JPanel();
    private JButton backBtn = new JButton("Back");
    private String[][] data;
    private String[] column;



    public ViewIssuedBooksScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - view issued books screen");

        viewIssuedBooksPanel = new JPanel();
        viewIssuedBooksPanel.setLayout(new BorderLayout());
        backBtn.setFont(new Font("Serif",Font.BOLD,20));


/*
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        viewBooksPanel.add(scrollPane,BorderLayout.CENTER);*/
        viewIssuedBooksPanel.add(backBtn,BorderLayout.SOUTH);



        this.add(viewIssuedBooksPanel);

    }

    public void setViewIssuedBooksTable(String[][]data, String[] column){
        JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane(table);

        viewIssuedBooksPanel.add(scrollPane,BorderLayout.CENTER);

    }

    public void backBtnListener(ActionListener backListen){
        backBtn.addActionListener(backListen);
    }



}
