package Controller;

import Model.User;
import View.HomeScreen;
import View.LibrarianScreenLogged;
import View.LoginUserScreen;
import View.StudentScreenLogged;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 27/08/2018.
 */
public class LoginUser {


    private LoginUserScreen theLoginUserScreen;
    private LibrarianScreenLogged theLoggedLibrarianScreen;
    private StudentScreenLogged theLoggedStudentScreen;
    private HomeScreen theHomeScreen;
    private boolean isStudent = false;


    public LoginUser(LoginUserScreen theLoginUserScreen, LibrarianScreenLogged theLoggedLibrarianScreen, StudentScreenLogged theLoggedStudentScreen, HomeScreen theHomeScreen){

        this.theLoginUserScreen = theLoginUserScreen;
        this.theLoggedLibrarianScreen = theLoggedLibrarianScreen;
        this.theLoggedStudentScreen = theLoggedStudentScreen;
        this.theHomeScreen = theHomeScreen;

        this.theLoginUserScreen.backBtnListener(new backButtonListener());
        this.theLoginUserScreen.loginBtnListener(new loginButtonListener());

    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                theLoginUserScreen.dispose();
                theHomeScreen.setVisible(true);
                theLoginUserScreen.setUsername(null);
                theLoginUserScreen.setPassword(null);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class loginButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                /*String username,password = null;
                username = theLoginUserScreen.getUsername();
                password = theLoginUserScreen.getPassword();*/
                System.out.println("Am I Student? " + isStudent);
                User user = new User(theLoginUserScreen.getUsername(),theLoginUserScreen.getPassword());
                if (user.authenticateUser(isStudent)){
                    theLoginUserScreen.displayErrorMessage("Success!");
                    theLoginUserScreen.dispose();
                    if (isStudent){
                        theLoggedStudentScreen.setVisible(true);
                        theLoginUserScreen.setUsername(null);
                        theLoginUserScreen.setPassword(null);
                    }else {
                        theLoggedLibrarianScreen.setVisible(true);
                        theLoginUserScreen.setUsername(null);
                        theLoginUserScreen.setPassword(null);
                    }
                }else{
                    System.out.println("Wrong!");
                    theLoginUserScreen.displayErrorMessage("Something went wrong! Please try again!");
                }
                /*if (LoginUserM.authenticateUser(username,password,isStudent)) {
                    theLoginUserScreen.displayErrorMessage("Success!");
                    theLoginUserScreen.dispose();
                    if (isStudent){
                        theLoggedStudentScreen.setVisible(true);
                        theLoginUserScreen.setUsername(null);
                        theLoginUserScreen.setPassword(null);
                    }else {
                        theLoggedLibrarianScreen.setVisible(true);
                        theLoginUserScreen.setUsername(null);
                        theLoginUserScreen.setPassword(null);
                    }
                }else{
                    System.out.println("Wrong!");
                    theLoginUserScreen.displayErrorMessage("Something went wrong! Please try again!");
                }*/
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
