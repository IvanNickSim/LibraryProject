package Controller;

import View.HomeScreen;
import View.RegisterScreenDefault;
import View.RegisterUserScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class RegisterDefault {


    private RegisterScreenDefault theRegisterDefaultScreen;
    private HomeScreen theHomeScreen;
   // private RegisterScreenStudent theRegisterStudentScreen;
    //private RegisterScreenLibrarian theRegisterLibrarianScreen;
    private RegisterUserScreen theRegisterUser;

    /*public RegisterDefault(RegisterScreenDefault theRegisterDefaultScreen, HomeScreen theHomeScreen, RegisterScreenStudent theRegisterStudentScreen, RegisterScreenLibrarian theRegisterLibrarianScreen){

        this.theRegisterDefaultScreen = theRegisterDefaultScreen;
        this.theHomeScreen = theHomeScreen;
        this.theRegisterLibrarianScreen = theRegisterLibrarianScreen;
        this.theRegisterStudentScreen = theRegisterStudentScreen;

        this.theRegisterDefaultScreen.backBtnListener(new backButtonListener());
        this.theRegisterDefaultScreen.registerStudentBtnListener(new registerStudentButtonListener());
        this.theRegisterDefaultScreen.registerLibrarianBtnListener(new registerLibrarianButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterDefaultScreen.dispose();
                theHomeScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class registerStudentButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterDefaultScreen.dispose();
                theRegisterStudentScreen.setVisible(true);

            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class registerLibrarianButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterDefaultScreen.dispose();
                theRegisterLibrarianScreen.setVisible(true);

            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }*/

    public RegisterDefault(RegisterScreenDefault theRegisterDefaultScreen, HomeScreen theHomeScreen, RegisterUserScreen theRegisterUser){

        this.theRegisterDefaultScreen = theRegisterDefaultScreen;
        this.theHomeScreen = theHomeScreen;
        this.theRegisterUser = theRegisterUser;

        this.theRegisterDefaultScreen.backBtnListener(new backButtonListener());
        this.theRegisterDefaultScreen.registerLibrarianBtnListener(new registerLibrarianButtonListener());
        this.theRegisterDefaultScreen.registerStudentBtnListener(new registerStudentButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterDefaultScreen.dispose();
                theHomeScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class registerLibrarianButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterUser.setIsLibrarian(true);
                theRegisterDefaultScreen.dispose();
                theRegisterUser.setVisible(true);
                System.out.println(theRegisterUser.getIsLibrarian());
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class registerStudentButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterDefaultScreen.dispose();
                theRegisterUser.setIsLibrarian(false);
                theRegisterUser.setVisible(true);
                System.out.println(theRegisterUser.getIsLibrarian());
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
