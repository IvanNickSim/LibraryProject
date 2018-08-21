package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class RegisterScreenLibrarian extends JFrame {

    private JPanel registerLibrarianPanel;
    private JTextField username = new JTextField(20);
    private JTextField email = new JTextField(20);
    private JTextField secretWord = new JTextField(20);
    private JPasswordField password = new JPasswordField(20);
    private JButton registerBtn = new JButton("Register");
    private JButton backBtn = new JButton("Back");

    public RegisterScreenLibrarian(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - register as librarian screen");

        registerLibrarianPanel = new JPanel();
        JLabel title = new JLabel("Enter your data:");
        title.setFont(new Font("Serif", Font.BOLD, 28));
        JLabel uname = new JLabel("Username: ");
        JLabel pass = new JLabel("Password: ");
        JLabel mail = new JLabel("Email: ");
        JLabel secWord = new JLabel("Secred word: ");
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\megat0n\\Desktop\\StackOVF\\Document.jpg").getImage().getScaledInstance(430,300,Image.SCALE_DEFAULT)));

        JComponent[] components = new JComponent[10];
        components[0] = username;
        components[1] = email;
        components[2] = secretWord;
        components[3] = password;
        components[4] = registerBtn;
        components[5] = backBtn;
        components[6] = uname;
        components[7] = pass;
        components[8] = mail;
        components[9] = secWord;

        for (JComponent x: components
                ) {
            x.setFont(new Font("Serif",Font.BOLD,20));
        }

        registerLibrarianPanel.setLayout(new GridBagLayout());
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
        registerLibrarianPanel.add(title,gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        registerLibrarianPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        registerLibrarianPanel.add(pass,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        registerLibrarianPanel.add(mail,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        registerLibrarianPanel.add(secWord,gridBagConstraints);

        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        registerLibrarianPanel.add(username,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        registerLibrarianPanel.add(password,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        registerLibrarianPanel.add(email,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        registerLibrarianPanel.add(secretWord,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        registerLibrarianPanel.add(registerBtn,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        registerLibrarianPanel.add(backBtn,gridBagConstraints);
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        registerLibrarianPanel.add(image,gridBagConstraints);

        this.add(registerLibrarianPanel);
    }

    public void backBtnListener(ActionListener listenBack){
        backBtn.addActionListener(listenBack);
    }

    public void registerBtnListener(ActionListener listenRegister){
        registerBtn.addActionListener(listenRegister);
    }

}
