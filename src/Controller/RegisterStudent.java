package Controller;

import View.RegisterScreenDefault;
import View.RegisterScreenStudent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class RegisterStudent {

    private RegisterScreenStudent theRegisterStudentScreen;
    private RegisterScreenDefault theRegisterDefaultScreen;

    public RegisterStudent(RegisterScreenStudent theRegisterStudentScreen,RegisterScreenDefault theRegisterDefaultScreen){

        this.theRegisterStudentScreen = theRegisterStudentScreen;
        this.theRegisterDefaultScreen = theRegisterDefaultScreen;

        this.theRegisterStudentScreen.backBtnListener(new backButtonListener());


    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterStudentScreen.dispose();
                theRegisterDefaultScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


}
