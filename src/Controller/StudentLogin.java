package Controller;

import Model.LoginUserM;
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
    private boolean isStudent = false;

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
                String username,password = null;
                username = theLoginStudentScreen.getStudentLoginName();
                password = theLoginStudentScreen.getStudentPassword();
                if (LoginUserM.authenticateUser(username,password,false)) {
                    theLoginStudentScreen.displayErrorMessage("Success!");
                    theLoginStudentScreen.dispose();
                    theLoggedStudentScreen.setVisible(true);
                }else{
                    System.out.println("Wrong!");
                    theLoginStudentScreen.displayErrorMessage("Something went wrong! Please try again!");
                }

            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public void setIsStudent(boolean isStudent){
        this.isStudent = isStudent;
    }

    public boolean getIsStudent(){
        return this.isStudent;
    }

}
