package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class HistoryScreenSecond extends JFrame{

    private JPanel historySecondPanel;
    private JButton backBtn = new JButton("Back");

    public HistoryScreenSecond(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - history second screen");

        historySecondPanel = new JPanel();
        historySecondPanel.setLayout(new BorderLayout());

        JLabel historyTitle = new JLabel("The History of the Sofia National Library Part II",SwingConstants.CENTER);
        historyTitle.setFont(new Font("Serif",Font.BOLD,34));

        StringBuilder theText = new StringBuilder("<html>The SS. Cyril and Methodius National Library is currently the largest<br/>");
        theText.append("public library in Bulgaria and the oldest cultural institution after the <br/>");
        theText.append("country's liberation, and also houses one of the richest Ottoman archival<br/>");
        theText.append("collections.<br/><br/>");
        theText.append("In 1878, Mikhail Bobotinov, a teacher and secretary of the City Council in Sofia,<br/>");
        theText.append("proposed to establish a public library for the need of cultural and educational<br/>");
        theText.append("development in Sofia. The library was then arranged and open in 1878 and<br/>");
        theText.append("finally received its own building in 1900. In 1939, a new building began <br/>");
        theText.append("construction, but sadly in 1944 both the new and old building were <br/>");
        theText.append("destroyed during a bombing in Sofia.<br/><br/>");
        theText.append("In 1953, the National Library opens its new building under the name<br/>");
        theText.append(" \"Vasil Kolarov\".<br/>");
        theText.append("It was not until 1963 that the library was renamed from \"Vasil Kolarov\" to<br/>");
        theText.append("\"St. Cyril and Methodius\"</html>");

        JLabel historyText = new JLabel(theText.toString());
        historyText.setFont(new Font("Serif",Font.BOLD,22));

        backBtn.setFont(new Font("Serif",Font.BOLD,22));

        JLabel[] textLabels = new JLabel[2];
        textLabels[0] = historyTitle;
        textLabels[1] = historyText;

        for (JLabel x: textLabels
             ) {
            x.setOpaque(true);
            x.setBackground(Color.LIGHT_GRAY);
            x.setBorder(new LineBorder(Color.black,3));
        }


        JLabel imageOne = new JLabel();
        imageOne.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\2.jpg").getImage().getScaledInstance(250,600, Image.SCALE_DEFAULT)));
        JLabel imageTwo = new JLabel();
        imageTwo.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\1.jpeg").getImage().getScaledInstance(250,600,Image.SCALE_DEFAULT)));

        JLabel[] imageLabels = new JLabel[2];
        imageLabels[0] = imageOne;
        imageLabels[1] = imageTwo;

        for (JLabel x: imageLabels
             ) {
            x.setPreferredSize(new Dimension(250,460));
            x.setBorder(new LineBorder(Color.black,3));
            x.setOpaque(true);
            x.setBackground(Color.LIGHT_GRAY);
        }


        historySecondPanel.add(historyTitle,BorderLayout.NORTH);
        historySecondPanel.add(backBtn,BorderLayout.SOUTH);
        historySecondPanel.add(historyText,BorderLayout.CENTER);
        historySecondPanel.add(imageOne,BorderLayout.WEST);
        historySecondPanel.add(imageTwo,BorderLayout.EAST);

        this.add(historySecondPanel);
    }

    public void backBtnListener(ActionListener listenBack){
        backBtn.addActionListener(listenBack);
    }

}
