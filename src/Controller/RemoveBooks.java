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
        this.theRemoveBooksScreen.removeBookByTitle(new removeBookByTitleButton());
        this.theRemoveBooksScreen.removeBooksByAuthor(new removeBookByAuthorButton());

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

    class removeBookByTitleButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRemoveBooksScreen.displayErrorMessage("Clicked");
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class removeBookByAuthorButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRemoveBooksScreen.displayErrorMessage("Clicked");
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }



}
