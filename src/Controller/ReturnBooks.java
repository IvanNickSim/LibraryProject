package Controller;

import View.ReturnBooksScreen;
import View.StudentScreenLogged;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class ReturnBooks {

    private ReturnBooksScreen theReturnBooksScreen;
    private StudentScreenLogged theStudentLoggedScreen;

    public ReturnBooks(ReturnBooksScreen theReturnBooksScreen, StudentScreenLogged theStudentLoggedScreen) {

        this.theReturnBooksScreen = theReturnBooksScreen;
        this.theStudentLoggedScreen = theStudentLoggedScreen;

        this.theReturnBooksScreen.returnBookBtnListener(new returnBookButtonListener());
        this.theReturnBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                theReturnBooksScreen.dispose();
                theStudentLoggedScreen.setVisible(true);
                theReturnBooksScreen.setBookTitle(null);
                theReturnBooksScreen.setBookAuthor(null);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class returnBookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theReturnBooksScreen.setBookTitle(null);
                theReturnBooksScreen.setBookAuthor(null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
