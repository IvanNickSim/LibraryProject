package Controller;

import View.HomeScreen;
import View.StudentScreenLogged;
import View.StudentScreenLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class StudentLogin {

    private StudentScreenLogin theLoginStudentScreen;
    private StudentScreenLogged theLoggedStudentScreen;
    private HomeScreen theHomeScreen;

    public StudentLogin(StudentScreenLogin theLoginStudentScreen, StudentScreenLogged theLoggedStudentScreen, HomeScreen theHomeScreen){

        this.theLoginStudentScreen = theLoginStudentScreen;
        this.theLoggedStudentScreen = theLoggedStudentScreen;
        this.theHomeScreen = theHomeScreen;

        this.theLoginStudentScreen.backBtnListener(new backButtonListener());
        this.theLoginStudentScreen.loginBtnListener(new loginButtonListener());
    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                theLoginStudentScreen.dispose();
                theHomeScreen.setVisible(true);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class loginButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLoginStudentScreen.dispose();
                theLoggedStudentScreen.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
