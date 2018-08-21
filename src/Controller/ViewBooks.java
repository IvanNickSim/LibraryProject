package Controller;

import View.LibrarianScreenLogged;
import View.ViewBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class ViewBooks {

    private ViewBooksScreen theViewBooksScreen;
    private LibrarianScreenLogged theLoggedLibrarianScreen;

    public ViewBooks(ViewBooksScreen theViewBooksScreen, LibrarianScreenLogged theLoggedLibrarianScreen){

        this.theViewBooksScreen = theViewBooksScreen;
        this.theLoggedLibrarianScreen = theLoggedLibrarianScreen;

        this.theViewBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theViewBooksScreen.dispose();
                theLoggedLibrarianScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
