package Controller;

import Model.ViewBooksM;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 20/08/2018.
 */
public class StudentLogged {


    private StudentScreenLogged theStudentLoggedScreen;
    private StudentScreenLogin theStudentLoginScreen;
    private LoginUserScreen theUserLoginScreen;
    private LoginUser theLoginUser;

    private ViewBooksScreen theViewBooksScreen;
    private SearchBooksScreen theSearchBooksScreen;
    private TakeBooksScreen theTakeBooksScreen;
    private ReturnBooksScreen theReturnBooksScreen;
    private ViewTakenBooksScreen theViewTakenBooksScreen;
    private ViewBooksM theViewBooksM;
    private String loggedStudentUsername;



    public StudentLogged(StudentScreenLogged theStudentLoggedScreen, StudentScreenLogin theStudentLoginScreen, SearchBooksScreen theSearchBooksScreen,ViewBooksScreen theViewBooksScreen,TakeBooksScreen theTakeBooksScreen,ReturnBooksScreen theReturnBooksScreen,ViewTakenBooksScreen theViewTakenBooksScreen,LoginUserScreen theUserLoginScreen, LoginUser theLoginUser, ViewBooksM theViewBooksM){

        this.theStudentLoggedScreen = theStudentLoggedScreen;
        this.theStudentLoginScreen = theStudentLoginScreen;
        this.theSearchBooksScreen = theSearchBooksScreen;
        this.theViewBooksScreen = theViewBooksScreen;
        this.theTakeBooksScreen = theTakeBooksScreen;
        this.theReturnBooksScreen = theReturnBooksScreen;
        this.theViewTakenBooksScreen = theViewTakenBooksScreen;
        this.theUserLoginScreen = theUserLoginScreen;
        this.theLoginUser = theLoginUser;
        this.theViewBooksM = theViewBooksM;

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
                theSearchBooksScreen.setIsStudent(true);
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
                theViewBooksScreen.setIsStudent(true);
                String[][] data = theViewBooksM.dataValue();
                String[] column = theViewBooksM.columnValue();
                for (int i = 0; i < column.length; i++){
                    System.out.print(column[i] + " ");
                }
                System.out.println();

                for (int i = 0; i < data.length; i++){
                    for (int j = 0; j < data[i].length;j++){
                        System.out.print(data[i][j] + " ");
                    }
                    System.out.println();
                }

                theViewBooksScreen.setViewBooksTable(data,column);

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
                theTakeBooksScreen.setLoggedStudentUsername(theLoginUser.getLoggedStudentUsername());
                System.out.println(theTakeBooksScreen.getLoggedStudentUsername());

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
                theReturnBooksScreen.setLoggedStudentUsername(theLoginUser.getLoggedStudentUsername());
                System.out.println(theReturnBooksScreen.getLoggedStudentUsername());

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
                theViewTakenBooksScreen.setLoggedStudentUsername(theLoginUser.getLoggedStudentUsername());
                System.out.println(theViewTakenBooksScreen.getLoggedStudentUsername());

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
                //theStudentLoginScreen.setVisible(true);
                theUserLoginScreen.setVisible(true);
                theLoginUser.setLoggedStudentUsername(null);


            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public String getLoggedStudentUsername(){
        return this.loggedStudentUsername;
    }

    public void setLoggedStudentUsername(String username){
        this.loggedStudentUsername = username;
    }



}
