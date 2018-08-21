package Controller;

import View.RegisterScreenDefault;
import View.RegisterScreenLibrarian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class RegisterLibrarian {

    private RegisterScreenLibrarian theRegisterLibrarianScreen;
    private RegisterScreenDefault theRegisterDefaultScreen;

    public RegisterLibrarian(RegisterScreenLibrarian theRegisterLibrarianScreen,RegisterScreenDefault theRegisterDefaultScreen){

        this.theRegisterLibrarianScreen = theRegisterLibrarianScreen;
        this.theRegisterDefaultScreen = theRegisterDefaultScreen;

        this.theRegisterLibrarianScreen.backBtnListener(new backButtonListener());


    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterLibrarianScreen.dispose();
                theRegisterDefaultScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
