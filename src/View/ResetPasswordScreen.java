package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 28/08/2018.
 */
public class ResetPasswordScreen extends JFrame{

    private JPanel resetPassPanel;
    private JTextField username = new JTextField(20);
    private JTextField email = new JTextField(20);
    private JTextField secretWord = new JTextField(20);
    private JButton backBtn = new JButton("Back");
    private JButton resetBtn = new JButton("Reset Password");

    public ResetPasswordScreen(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Library management app - reset password screen");

        resetPassPanel = new JPanel();
        JLabel title = new JLabel("Reset you password by entering following data: ");
        title.setFont(new Font("Serif",Font.BOLD,24));
        JLabel uname = new JLabel("Enter username: ");
        JLabel mail = new JLabel("Enter email: ");
        JLabel secretWrd = new JLabel("Enter secret word: ");

        JComponent[] components = new JComponent[8];
        components[0] = uname;
        components[1] = mail;
        components[2] = secretWrd;
        components[3] = username;
        components[4] = email;
        components[5] = secretWord;
        components[6] = backBtn;
        components[7] = resetBtn;

        for (JComponent x: components
             ) {
            x.setFont(new Font("Serif", Font.BOLD, 20));
        }

        resetPassPanel.setLayout(new GridBagLayout());
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
        resetPassPanel.add(title,gridBagConstraints);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        resetPassPanel.add(uname,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        resetPassPanel.add(mail,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        resetPassPanel.add(secretWrd,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        resetPassPanel.add(username,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        resetPassPanel.add(email,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        resetPassPanel.add(secretWord,gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        resetPassPanel.add(resetBtn,gridBagConstraints);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        resetPassPanel.add(backBtn,gridBagConstraints);

        this.add(resetPassPanel);

    }

    public void resetPassBtnListener(ActionListener listenResetPass){
        resetBtn.addActionListener(listenResetPass);
    }

    public void backBtnListener(ActionListener listenBack){
        backBtn.addActionListener(listenBack);
    }

    public String getUsername(){
        return this.username.getText();
    }

    public void setUsername(String username){
        this.username.setText(username);
    }

    public String getEmail(){
        return this.email.getText();
    }

    public void setEmail(String email){
        this.email.setText(email);
    }

    public String getSecretWord(){
        return this.secretWord.getText();
    }

    public void setSecretWord(String secretWord){
        this.secretWord.setText(secretWord);
    }

    public void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this,errorMessage);

    }

}
