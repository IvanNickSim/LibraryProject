package Controller;

import View.StudentScreenLogged;
import View.ViewTakenBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class ViewTakenBooks {

    private ViewTakenBooksScreen theViewTakenBooksScreen;
    private StudentScreenLogged theLoggedStudentScreen;


    public ViewTakenBooks(ViewTakenBooksScreen theViewTakenBooksScreen, StudentScreenLogged theLoggedStudentScreen) {

        this.theViewTakenBooksScreen = theViewTakenBooksScreen;
        this.theLoggedStudentScreen = theLoggedStudentScreen;

        this.theViewTakenBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theViewTakenBooksScreen.dispose();
                theLoggedStudentScreen.setVisible(true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
