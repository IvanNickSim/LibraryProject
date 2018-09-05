package Controller;

import View.LibrarianScreenLogged;
import View.SearchBooksScreen;
import View.StudentScreenLogged;
import View.ViewSearchedBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 04/09/2018.
 */
public class ViewSearchedBooks {

    private ViewSearchedBooksScreen theViewSearchedBooksScreen;
    private LibrarianScreenLogged theLoggedLibrarianScreen;
    private StudentScreenLogged theLoggedStudentScreen;
    private SearchBooksScreen theSearchBooksScreen;

    public ViewSearchedBooks(ViewSearchedBooksScreen theViewSearchedBooksScreen, LibrarianScreenLogged theLoggedLibrarianScreen, StudentScreenLogged theLoggedStudentScreen, SearchBooksScreen theSearchBooksScreen){

        this.theViewSearchedBooksScreen = theViewSearchedBooksScreen;
        this.theLoggedLibrarianScreen = theLoggedLibrarianScreen;
        this.theLoggedStudentScreen = theLoggedStudentScreen;
        this.theSearchBooksScreen = theSearchBooksScreen;

        this.theViewSearchedBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theViewSearchedBooksScreen.dispose();
                if (theViewSearchedBooksScreen.getIsStudent()){
                    theSearchBooksScreen.setIsStudent(true);
                    theSearchBooksScreen.setVisible(true);
                    System.out.println(theSearchBooksScreen.getIsStudent() + " I must active Student Frame>!");
                   // theLoggedStudentScreen.setVisible(true);
                }else {
                    theSearchBooksScreen.setIsStudent(false);
                    theSearchBooksScreen.setVisible(true);
                    System.out.println(theSearchBooksScreen.getIsStudent() + "I must be Librarian>>?!");
                    //theLoggedLibrarianScreen.setVisible(true);
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
