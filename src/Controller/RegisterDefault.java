package Controller;

import View.HomeScreen;
import View.RegisterScreenDefault;
import View.RegisterScreenLibrarian;
import View.RegisterScreenStudent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class RegisterDefault {


    private RegisterScreenDefault theRegisterDefaultScreen;
    private HomeScreen theHomeScreen;
    private RegisterScreenStudent theRegisterStudentScreen;
    private RegisterScreenLibrarian theRegisterLibrarianScreen;

    public RegisterDefault(RegisterScreenDefault theRegisterDefaultScreen, HomeScreen theHomeScreen, RegisterScreenStudent theRegisterStudentScreen, RegisterScreenLibrarian theRegisterLibrarianScreen){

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
    }

}
