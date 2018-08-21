package Controller;

import View.AddBooksScreen;
import View.LibrarianScreenLogged;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class AddBooks {

    private AddBooksScreen theAddBooksScreen;
    private LibrarianScreenLogged theLibrarianLoggedScreen;

    public AddBooks(AddBooksScreen theAddBooksScreen, LibrarianScreenLogged theLibrarianLoggedScreen){

        this.theAddBooksScreen = theAddBooksScreen;
        this.theLibrarianLoggedScreen = theLibrarianLoggedScreen;

        this.theAddBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theAddBooksScreen.dispose();
                theLibrarianLoggedScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
