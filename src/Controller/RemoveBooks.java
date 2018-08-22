package Controller;

import View.LibrarianScreenLogged;
import View.RemoveBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class RemoveBooks {

    private RemoveBooksScreen theRemoveBooksScreen;
    private LibrarianScreenLogged theLibrarianLoggedScreen;

    public RemoveBooks(RemoveBooksScreen theRemoveBooksScreen, LibrarianScreenLogged theLibrarianLoggedScreen){
        this.theRemoveBooksScreen = theRemoveBooksScreen;
        this.theLibrarianLoggedScreen = theLibrarianLoggedScreen;

        this.theRemoveBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRemoveBooksScreen.dispose();
                theLibrarianLoggedScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
