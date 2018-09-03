package Controller;

import Model.ViewBooksM;
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
    private LoginUserScreen theLoginUserScreen;
    private ViewBooksM theViewBooksModel;

    public LibrarianLogged(LibrarianScreenLogged theLibrarianLoggedScreen, LibrarianScreenLogin theLibrarianLoginScreen,AddBooksScreen theAddBooksScreen,RemoveBooksScreen theRemoveBooksScreen,SearchBooksScreen theSearchBooksScreen,ViewBooksScreen theViewBooksScreen,IssuedBooksScreen theIssuedBooksScreen,LoginUserScreen theLoginUserScreen, ViewBooksM theViewBooksModel){

        this.theLibrarianLoggedScreen = theLibrarianLoggedScreen;
        this.theLibrarianLoginScreen = theLibrarianLoginScreen;
        this.theViewBooksScreen = theViewBooksScreen;
        this.theSearchBooksScreen = theSearchBooksScreen;
        this.theAddBooksScreen = theAddBooksScreen;
        this.theRemoveBooksScreen = theRemoveBooksScreen;
        this.theIssuedBooksScreen = theIssuedBooksScreen;
        this.theLoginUserScreen = theLoginUserScreen;
        this.theViewBooksModel = theViewBooksModel;

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
                //theLibrarianLoginScreen.setVisible(true);
                theLoginUserScreen.setVisible(true);
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
                theViewBooksScreen.setIsStudent(false);

                String[][] data = theViewBooksModel.dataValue();
                String[] column = theViewBooksModel.columnValue();
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

    class searchBooksButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theLibrarianLoggedScreen.dispose();
                theSearchBooksScreen.setVisible(true);
                theViewBooksScreen.setIsStudent(false);
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
