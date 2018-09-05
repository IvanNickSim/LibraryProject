package Controller;

import View.LibrarianScreenLogged;
import View.ViewIssuedBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 05/09/2018.
 */
public class VIewIssuedBooks {


    private ViewIssuedBooksScreen theViewIssuedBooksScreen;
    private LibrarianScreenLogged theLoggedLibrarianScreen;


    public VIewIssuedBooks(ViewIssuedBooksScreen theViewIssuedBooksScreen, LibrarianScreenLogged theLoggedLibrarianScreen){

        this.theViewIssuedBooksScreen = theViewIssuedBooksScreen;
        this.theLoggedLibrarianScreen = theLoggedLibrarianScreen;


        this.theViewIssuedBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theViewIssuedBooksScreen.dispose();
                theLoggedLibrarianScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
