package Controller;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class LibrarianLogged {

    private LibrarianScreenLogged theLibrarianLoggedScreen;
    private LibrarianScreenLogin theLibrarianLoginScreen;
    private AddBooksScreen theAddBooksScreen;
    private RemoveBooksScreen theRemoveBooksScreen;
    private SearchBooksScreen theSearchBooksScreen;
    private ViewBooksScreen theViewBooksScreen;
    private IssuedBooksScreen theIssuedBooksScreen;

    public LibrarianLogged(LibrarianScreenLogged theLibrarianLoggedScreen, LibrarianScreenLogin theLibrarianLoginScreen,AddBooksScreen theAddBooksScreen,RemoveBooksScreen theRemoveBooksScreen,SearchBooksScreen theSearchBooksScreen,ViewBooksScreen theViewBooksScreen,IssuedBooksScreen theIssuedBooksScreen){

        this.theLibrarianLoggedScreen = theLibrarianLoggedScreen;
        this.theLibrarianLoginScreen = theLibrarianLoginScreen;
        this.theViewBooksScreen = theViewBooksScreen;
        this.theSearchBooksScreen = theSearchBooksScreen;
        this.theAddBooksScreen = theAddBooksScreen;
        this.theRemoveBooksScreen = theRemoveBooksScreen;
        this.theIssuedBooksScreen = theIssuedBooksScreen;

        this.theLibrarianLoggedScreen.logoutBtnListener(new logoutButtonListener());
        this.theLibrarianLoggedScreen.viewBooksBtnListner(new viewBooksButtonListener());
        this.theLibrarianLoggedScreen.searchBooksBtnListner(new searchBooksButtonListener());
        this.theLibrarianLoggedScreen.addBooksBtnListener(new addBooksButtonListener());
        this.theLibrarianLoggedScreen.removeBooksBtnListener(new removeBooksButtonListener());
        this.theLibrarianLoggedScreen.issuedBooksBtnListener(new issuedBooksButtonListener());



    }

    class logoutButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLibrarianLoggedScreen.dispose();
                theLibrarianLoginScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class viewBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLibrarianLoggedScreen.dispose();
                theViewBooksScreen.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class searchBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLibrarianLoggedScreen.dispose();
                theSearchBooksScreen.setVisible(true);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

    class addBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLibrarianLoggedScreen.dispose();
                theAddBooksScreen.setVisible(true);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

    class removeBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLibrarianLoggedScreen.dispose();
                theRemoveBooksScreen.setVisible(true);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

    class issuedBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLibrarianLoggedScreen.dispose();
                theIssuedBooksScreen.setVisible(true);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

}
