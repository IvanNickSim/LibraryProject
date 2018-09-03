package Controller;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class Home {

    private HomeScreen theHomeScreen;
    private HistoryScreenFirst theHistoryFirstScreen;
    private ContactScreen theContactScreen;
    private RegisterScreenDefault theRegisterDefaultScreen;
    private StudentScreenLogin theStudentLoginScreen;
    private LibrarianScreenLogin theLibrarianLoginScreen;
    private LoginUserScreen theLoginUserScreen;
    private LoginUser theLoginUser;
    private ResetPasswordScreen theResetPassScreen;



    public Home(HomeScreen theHomeScreen, HistoryScreenFirst theHistoryFirstScreen, ContactScreen theContactScreen, RegisterScreenDefault theRegisterDefaultScreen, StudentScreenLogin theStudentLoginScreen, LibrarianScreenLogin theLibrarianLoginScreen, LoginUserScreen theLoginUserScreen,LoginUser theLoginUser,ResetPasswordScreen theResetPassScreen){

        this.theHomeScreen = theHomeScreen;
        this.theHistoryFirstScreen = theHistoryFirstScreen;
        this.theContactScreen = theContactScreen;
        this.theRegisterDefaultScreen = theRegisterDefaultScreen;
        this.theStudentLoginScreen = theStudentLoginScreen;
        this.theLibrarianLoginScreen = theLibrarianLoginScreen;
        this.theLoginUserScreen = theLoginUserScreen;
        this.theLoginUser = theLoginUser;
        this.theResetPassScreen = theResetPassScreen;

        this.theHomeScreen.historyBtnListener(new historyButtonListener());
        this.theHomeScreen.contactBtnListener(new contactButtonListener());
        this.theHomeScreen.registerBtnListener(new registerButtonListener());
        this.theHomeScreen.studentLoginBtnListener(new loginStudentButtonListener());
        this.theHomeScreen.librarianLoginBtnListener(new loginLibrarianButtonListener());
        this.theHomeScreen.forgotPassBtnListener(new forgotPassButtonListener());
    }

    class historyButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHistoryFirstScreen.setVisible(true);
                //theHomeScreen.setVisible(false);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class forgotPassButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHomeScreen.setVisible(false);
                theResetPassScreen.setVisible(true);
            }catch (Exception e6){
                e6.printStackTrace();
            }
        }
    }

    class contactButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHomeScreen.dispose();
                theContactScreen.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class registerButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHomeScreen.dispose();
                theRegisterDefaultScreen.setVisible(true);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

    class loginStudentButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHomeScreen.dispose();
               // theStudentLoginScreen.setVisible(true);
                //theStudentLoginScreen.setIsStudent(true);
                //System.out.println(theStudentLoginScreen.getIsStudent());
                theLoginUserScreen.setVisible(true);
                theLoginUserScreen.setIsStudent(true);
                theLoginUser.setIsStudent(true);
                System.out.println(theLoginUserScreen.getIsStudent());

            }catch (Exception e4){
                e4.printStackTrace();
            }
        }
    }

    class loginLibrarianButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHomeScreen.dispose();
                //theLibrarianLoginScreen.setVisible(true);
                //theLibrarianLoginScreen.setIsStudent(false);
                //System.out.println(theLibrarianLoginScreen.getIsStudent());
                theLoginUserScreen.setVisible(true);
                theLoginUserScreen.setIsStudent(false);
                theLoginUser.setIsStudent(false);
                System.out.println(theLoginUserScreen.getIsStudent());


            }catch (Exception e5){
                e5.printStackTrace();
            }
        }
    }


}
