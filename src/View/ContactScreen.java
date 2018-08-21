package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class ContactScreen extends JFrame{

    private JPanel contactPanel;
    private JButton backBtn = new JButton("Back");

    public ContactScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - contact us screen");

        contactPanel = new JPanel();


        JPanel contactInnerPanel = new JPanel();
        JLabel locationPic = new JLabel();
        locationPic.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Loc.jpg").getImage().getScaledInstance(1280,400,Image.SCALE_DEFAULT)));
        locationPic.setBorder(new LineBorder(Color.black,5));
        backBtn.setFont(new Font("Serif",Font.BOLD,20));

        JLabel address = new JLabel("<html><u>Address: Sofia 1504, 88 Vasil Levski blvd.</u></html>",SwingConstants.CENTER);
        address.setFont(new Font("Serif",Font.BOLD,30));
        JLabel secretary = new JLabel("<html><u>Secretary:</u><br/>Hristiana Koleva<br/>Tel.: (+ 359 2) 9183/101;(+ 359) 878 273 403<br/>" +
                "e-mail: secretary@nationallibrary.bg</html>");
        JLabel personalManager = new JLabel("<html><u>Personal Manager:</u><br/>Kornelia Lyubenova<br/>Tel.: (+ 359 2) 9183/163<br/>" +
                "e-mail: k.lyubenova@nationallibrary.bg</html>");
        JLabel publicRelations = new JLabel("<html><u>Public Relations:</u><br/>Violeta Tsvetkova<br/>Tel.: (+ 359 2) 981 23 24; (+ 359 2) 9183 212<br/>" +
                "e-mail: v.tsvetkova@nationallibrary.bg</html>");

        contactPanel.setLayout(new BorderLayout());
        contactPanel.add(locationPic,BorderLayout.NORTH);
        contactPanel.add(contactInnerPanel,BorderLayout.CENTER);
        contactPanel.add(backBtn,BorderLayout.SOUTH);

        JLabel[] labels = new JLabel[3];
        labels[0] = secretary;
        labels[1] = personalManager;
        labels[2] = publicRelations;


        for (JLabel x: labels
             ) {
            x.setHorizontalAlignment(SwingConstants.CENTER);
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        contactInnerPanel.setLayout(new BorderLayout(15,15));
        contactInnerPanel.setBorder(new EmptyBorder(15,15,15,15));
        contactInnerPanel.add(address,BorderLayout.NORTH);
        contactInnerPanel.add(secretary,BorderLayout.CENTER);
        contactInnerPanel.add(personalManager,BorderLayout.WEST);
        contactInnerPanel.add(backBtn,BorderLayout.SOUTH);
        contactInnerPanel.add(publicRelations,BorderLayout.EAST);

        this.add(contactPanel);
    }


    public void backBtnListener(ActionListener listenBack){
        backBtn.addActionListener(listenBack);
    }

}
