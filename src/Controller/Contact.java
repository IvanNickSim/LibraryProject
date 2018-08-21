package Controller;

import View.ContactScreen;
import View.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class Contact {

    private ContactScreen theContactScreen;
    private HomeScreen theHomeScreen;

    public Contact(ContactScreen theContactScreen, HomeScreen theHomeScreen){
        this.theContactScreen = theContactScreen;
        this.theHomeScreen = theHomeScreen;

        this.theContactScreen.backBtnListener(new backButtonListener());
    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theContactScreen.dispose();
                theHomeScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
