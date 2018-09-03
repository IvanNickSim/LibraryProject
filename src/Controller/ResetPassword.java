package Controller;

import Model.ResetPasswordM;
import View.HomeScreen;
import View.ResetPasswordScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 28/08/2018.
 */
public class ResetPassword {

    private ResetPasswordScreen theResetPasswordScreen;
    private HomeScreen theHomeScreen;

    public ResetPassword(ResetPasswordScreen theResetPasswordScreen, HomeScreen theHomeScreen){

        this.theResetPasswordScreen = theResetPasswordScreen;
        this.theHomeScreen = theHomeScreen;

        this.theResetPasswordScreen.backBtnListener(new backButtonListener());
        this.theResetPasswordScreen.resetPassBtnListener(new resetPassButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theResetPasswordScreen.setUsername(null);
                theResetPasswordScreen.setEmail(null);
                theResetPasswordScreen.setSecretWord(null);
                theResetPasswordScreen.dispose();
                theHomeScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class resetPassButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            String uname,email,secretWord,password = null;

            try {

                uname = theResetPasswordScreen.getUsername();
                email = theResetPasswordScreen.getEmail();
                secretWord = theResetPasswordScreen.getSecretWord();
                String result = ResetPasswordM.returnPassword(uname,email,secretWord);
                System.out.println(result);
                if (result == null || result.equals("")){
                    theResetPasswordScreen.displayErrorMessage("No such an account.");
                }else{
                    theResetPasswordScreen.displayErrorMessage(result);
                    theResetPasswordScreen.setUsername(null);
                    theResetPasswordScreen.setEmail(null);
                    theResetPasswordScreen.setSecretWord(null);
                }

            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

}
