package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class HistoryScreenFirst extends JFrame{

    private JPanel historyFirstPanel;
    private JButton backBtn = new JButton();
    private JButton nextBtn = new JButton();

    public HistoryScreenFirst(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - history first screen");

        historyFirstPanel = new JPanel();

        JLabel historyTitle = new JLabel("The history of the Sofia national library part I",SwingConstants.CENTER);
        historyTitle.setFont(new Font("Serif",Font.BOLD,34));


        StringBuilder theText = new StringBuilder("<html><br/>The SS. Cyril and Methodius National Library (Национална библиотека <br/>");
        theText.append("„Свети Свети Кирил и Методий“) is the national library of Bulgaria, situated <br/>");
        theText.append("in the capital city of Sofia. Founded on 4 April 1878, the library received the<br/>");
        theText.append("status of Bulgarian National Library three years later and the Bulgarian National<br/>");
        theText.append("Revival Archive was merged into it in 1924.<br/><br/>");
        theText.append("It is named after \"SS. Cyril and Methodius\"; Saints Cyril and Methodius. They are <br/>");
        theText.append("the creators of the Glagolitic alphabet. The Cyrillic alphabet is named after Cyril.<br/><br/>");
        theText.append("The present building of the library is among the landmarks of Sofia. It was designed <br/>");
        theText.append("by the famous Bulgarian architectural team Vasilyov-Dimitur Tsolov and completed in <br/>");
        theText.append("the period 1940-1953.<br/><br/>");
        theText.append("<u>Notabale Collections:</u> <br/>");
        theText.append("  Slavonic Scriptures, a collection of around 1700 originals dating from 11th century!<br/>");
        theText.append("  Eastern Scriptures, containing around 3100 Arabic and 500 Ottoman codicies. <br/>");
        theText.append("  Bulgarian Historical Archive with over 1.5 million documents under 700 separate<br/>");
        theText.append("      archives covering the work of Bulgarian revolutionaires, economic, cultural<br/>");
        theText.append("      and public people.</html>");

        JLabel historyText = new JLabel();
        historyText.setText(theText.toString());
        historyText.setFont(new Font("Serif",Font.BOLD,22));

        JLabel[] labels = new JLabel[2];
        labels[0] = historyTitle;
        labels[1] = historyText;

        for (JLabel x: labels
             ) {
            x.setBorder(new LineBorder(Color.black,3));
            x.setOpaque(true);
            x.setBackground(Color.lightGray);
        }

        backBtn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\back.jpg").getImage().getScaledInstance(200,550,Image.SCALE_DEFAULT)));
        nextBtn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\next.jpg").getImage().getScaledInstance(200,550,Image.SCALE_DEFAULT)));

        JButton[] buttons = new JButton[2];
        buttons[0] = backBtn;
        buttons[1] = nextBtn;

        for (JButton x: buttons
             ) {
            x.setOpaque(true);
            x.setBackground(Color.LIGHT_GRAY);
            x.setBorder(new LineBorder(Color.black,3));
        }

        historyFirstPanel.setLayout(new BorderLayout());
        historyFirstPanel.add(historyTitle,BorderLayout.NORTH);
        historyFirstPanel.add(historyText,BorderLayout.CENTER);
        historyFirstPanel.add(backBtn,BorderLayout.WEST);
        historyFirstPanel.add(nextBtn,BorderLayout.EAST);

        this.add(historyFirstPanel);

    }

    public void backBtnListener(ActionListener listenBack){
        backBtn.addActionListener(listenBack);
    }

    public void nextBtnListener(ActionListener listenNext){
        nextBtn.addActionListener(listenNext);
    }
}
