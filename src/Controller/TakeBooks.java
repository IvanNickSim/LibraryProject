package Controller;

import View.StudentScreenLogged;
import View.TakeBooksScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class TakeBooks {

    private TakeBooksScreen theTakeBooksScreen;
    private StudentScreenLogged theStudentLoggedScreen;


    public TakeBooks(TakeBooksScreen theTakeBooksScreen, StudentScreenLogged theStudentLoggedScreen){

        this.theTakeBooksScreen = theTakeBooksScreen;
        this.theStudentLoggedScreen = theStudentLoggedScreen;


        this.theTakeBooksScreen.takeBookBtnListener(new takeBookButtonListener());
        this.theTakeBooksScreen.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                theTakeBooksScreen.dispose();
                theStudentLoggedScreen.setVisible(true);
                theTakeBooksScreen.setBookTitle(null);
                theTakeBooksScreen.setBookAuthor(null);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class takeBookButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                theTakeBooksScreen.setBookTitle(null);
                theTakeBooksScreen.setBookAuthor(null);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

}
