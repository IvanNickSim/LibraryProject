package Controller;

import Model.Book;
import Model.SearchBooksM;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class SearchBooks {

    private SearchBooksScreen theSearchBooksScreen;
    private LibrarianScreenLogged theLibrarianLoggedScreen;
    private StudentScreenLogged theStudentLoggedScreen;
    private SearchBooksM theSearchBooks;
    private ViewBooksScreen theViewBooksScreen;
    private ViewSearchedBooksScreen theViewSearchedBooksScreen;

    public SearchBooks(SearchBooksScreen theSearchBooksScreen, LibrarianScreenLogged theLibrarianLoggedScreen, StudentScreenLogged theStudentLoggedScreen, SearchBooksM theSearchBooks, ViewBooksScreen theViewBooksScreen, ViewSearchedBooksScreen theViewSearchedBooksScreen){

        this.theSearchBooksScreen = theSearchBooksScreen;
        this.theLibrarianLoggedScreen = theLibrarianLoggedScreen;
        this.theStudentLoggedScreen = theStudentLoggedScreen;
        this.theSearchBooks = theSearchBooks;
        this.theViewBooksScreen = theViewBooksScreen;
        this.theViewSearchedBooksScreen = theViewSearchedBooksScreen;

        this.theSearchBooksScreen.backBtnListener(new backButtonListener());
        this.theSearchBooksScreen.searchByAuthorBtnListener(new searchByAuthorButtonListener());
        this.theSearchBooksScreen.searchByTitleBtnListner(new searchByTitleButtonListener());
    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                theSearchBooksScreen.dispose();
                if (theSearchBooksScreen.getIsStudent()){
                    theStudentLoggedScreen.setVisible(true);
                }else {
                    theLibrarianLoggedScreen.setVisible(true);
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class searchByTitleButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                theSearchBooksScreen.displayErrorMessage("Clicked");
                Book searchedBook = new Book();
                if (searchedBook.searchBooksByTitle(theSearchBooksScreen.getSearchedTitle())){
                    String data[][] = searchedBook.dataValue(theSearchBooksScreen.getSearchedTitle());
                    String column[] = searchedBook.columnValue(theSearchBooksScreen.getSearchedTitle());
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
                    /*theViewBooksScreen.setViewBooksTable(data,column);
                    theViewBooksScreen.setVisible(true);
                    theSearchBooksScreen.setSearchByTitle(null);
                    theSearchBooksScreen.dispose();
                   // theSearchBooksScreen.setSearchedBooks(data,column);
                   // theSearchBooksScreen.setVisible(true);*/

                    theViewSearchedBooksScreen.setIsStudent(theSearchBooksScreen.getIsStudent());
                    theViewSearchedBooksScreen.setVisible(true);
                    theViewSearchedBooksScreen.setViewSearchBooksTable(data,column);
                    theSearchBooksScreen.dispose();

                }else{
                    theSearchBooksScreen.displayErrorMessage("Something went wrong. Please try again!");
                }
                /*
                String result = theSearchBooks.searchBooksByTitle(theSearchBooksScreen.getSearchedTitle());
                if (result.equals("No Such a Book!")){
                    theSearchBooksScreen.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Title Field!")){
                    theSearchBooksScreen.displayErrorMessage(result);
                }else {
                    String data[][] = theSearchBooks.dataValue();
                    String column[] = theSearchBooks.columnValue();
                    theSearchBooksScreen.setSearchedBooks(data, column);
                }*/


            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class searchByAuthorButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                theSearchBooksScreen.displayErrorMessage("Clicked");
                String result = theSearchBooks.searchBooksByAuthor(theSearchBooksScreen.getSearchedAuthor());
                if (result.equals("No Books by this Author!")){
                    theSearchBooksScreen.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Author Field!")){
                    theSearchBooksScreen.displayErrorMessage(result);
                }else {
                    String data[][] = theSearchBooks.dataValueAuthor();
                    String column[] = theSearchBooks.columnValueAuthor();
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

                    //theSearchBooksScreen.setSearchedAuthor(data, column);
                   // theSearchBooksScreen.setVisible(true);
                    /*theViewBooksScreen.setViewBooksTable(data,column);
                    theViewBooksScreen.setVisible(true);
                    theSearchBooksScreen.dispose();*/

                    theViewSearchedBooksScreen.setIsStudent(theSearchBooksScreen.getIsStudent());
                    theViewSearchedBooksScreen.setVisible(true);
                    theViewSearchedBooksScreen.setViewSearchBooksTable(data,column);
                    theSearchBooksScreen.dispose();
                }


            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


}
