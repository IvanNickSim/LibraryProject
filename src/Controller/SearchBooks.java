package Controller;

import View.LibrarianScreenLogged;
import View.SearchBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class SearchBooks {

    private SearchBooksScreen theSearchBooksScreen;
    private LibrarianScreenLogged theLibrarianLoggedScreen;

    public SearchBooks(SearchBooksScreen theSearchBooksScreen, LibrarianScreenLogged theLibrarianLoggedScreen){

        this.theSearchBooksScreen = theSearchBooksScreen;
        this.theLibrarianLoggedScreen = theLibrarianLoggedScreen;

        this.theSearchBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                theSearchBooksScreen.dispose();
                theLibrarianLoggedScreen.setVisible(true);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


}
