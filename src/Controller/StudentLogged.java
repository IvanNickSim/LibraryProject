package Controller;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class StudentLogged {


    private StudentScreenLogged theStudentLoggedScreen;
    private StudentScreenLogin theStudentLoginScreen;

    private ViewBooksScreen theViewBooksScreen;
    private SearchBooksScreen theSearchBooksScreen;
    private TakeBooksScreen theTakeBooksScreen;
    private ReturnBooksScreen theReturnBooksScreen;
    private ViewTakenBooksScreen theViewTakenBooksScreen;



    public StudentLogged(StudentScreenLogged theStudentLoggedScreen, StudentScreenLogin theStudentLoginScreen, SearchBooksScreen theSearchBooksScreen,ViewBooksScreen theViewBooksScreen,TakeBooksScreen theTakeBooksScreen,ReturnBooksScreen theReturnBooksScreen,ViewTakenBooksScreen theViewTakenBooksScreen){

        this.theStudentLoggedScreen = theStudentLoggedScreen;
        this.theStudentLoginScreen = theStudentLoginScreen;
        this.theSearchBooksScreen = theSearchBooksScreen;
        this.theViewBooksScreen = theViewBooksScreen;
        this.theTakeBooksScreen = theTakeBooksScreen;
        this.theReturnBooksScreen = theReturnBooksScreen;
        this.theViewTakenBooksScreen = theViewTakenBooksScreen;


        this.theStudentLoggedScreen.searchBooksBtnListner(new searchBooksButtonListener());
        this.theStudentLoggedScreen.viewBooksBtnListner(new viewBooksButtonListener());
        this.theStudentLoggedScreen.takeBooksBtnListener(new takeBooksButtonListener());
        this.theStudentLoggedScreen.returnBooksBtnListener(new returnBooksButtonListener());
        this.theStudentLoggedScreen.takenBooksBtnListener(new takenBooksButtonListener());

        this.theStudentLoggedScreen.logoutBtnListener(new logoutButtonListener());
    }


    class searchBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theStudentLoggedScreen.dispose();
                theSearchBooksScreen.setVisible(true);
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

    class viewBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theStudentLoggedScreen.dispose();
                theViewBooksScreen.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class takeBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theStudentLoggedScreen.dispose();
                theTakeBooksScreen.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class returnBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theStudentLoggedScreen.dispose();
                theReturnBooksScreen.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class takenBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theStudentLoggedScreen.dispose();
                theViewTakenBooksScreen.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }


    class logoutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theStudentLoggedScreen.dispose();
                theStudentLoginScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }




}
