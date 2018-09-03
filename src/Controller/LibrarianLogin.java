package Controller;

import Model.LoginUserM;
import View.HomeScreen;
import View.LibrarianScreenLogged;
import View.LibrarianScreenLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class LibrarianLogin {

    private LibrarianScreenLogin theLoginLibrarianScreen;
    private LibrarianScreenLogged theLoggedLibrarianScreen;
    private HomeScreen theHomeScreen;


    public LibrarianLogin(LibrarianScreenLogin theLoginLibrarianScreen, LibrarianScreenLogged theLoggedLibrarianScreen, HomeScreen theHomeScreen){

        this.theLoginLibrarianScreen = theLoginLibrarianScreen;
        this.theLoggedLibrarianScreen = theLoggedLibrarianScreen;
        this.theHomeScreen = theHomeScreen;

        this.theLoginLibrarianScreen.backBtnListener(new backButtonListener());
        this.theLoginLibrarianScreen.loginBtnListener(new loginButtonListener());
    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                theLoginLibrarianScreen.dispose();
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
                username = theLoginLibrarianScreen.getLibrarianLoginName();
                password = theLoginLibrarianScreen.getLibrarianPassword();
                if (LoginUserM.authenticateUser(username,password,true)) {
                   theLoginLibrarianScreen.displayErrorMessage("Success!");
                    theLoginLibrarianScreen.dispose();
                    theLoggedLibrarianScreen.setVisible(true);
                }else{
                    System.out.println("Wrong!");
                    theLoginLibrarianScreen.displayErrorMessage("Something went wrong! Please try again!");
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }


}
