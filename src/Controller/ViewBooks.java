package Controller;

import View.LibrarianScreenLogged;
import View.StudentScreenLogged;
import View.ViewBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class ViewBooks {

    private ViewBooksScreen theViewBooksScreen;
    private LibrarianScreenLogged theLoggedLibrarianScreen;
    private StudentScreenLogged theLoggedStudentScreen;

    public ViewBooks(ViewBooksScreen theViewBooksScreen, LibrarianScreenLogged theLoggedLibrarianScreen, StudentScreenLogged theLoggedStudentScreen){

        this.theViewBooksScreen = theViewBooksScreen;
        this.theLoggedLibrarianScreen = theLoggedLibrarianScreen;
        this.theLoggedStudentScreen = theLoggedStudentScreen;

        this.theViewBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theViewBooksScreen.dispose();
                if (theViewBooksScreen.getIsStudent()){
                    theLoggedStudentScreen.setVisible(true);
                }else {
                    theLoggedLibrarianScreen.setVisible(true);
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
