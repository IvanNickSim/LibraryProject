package Controller;

import Model.Book;
import View.AddBooksScreen;
import View.LibrarianScreenLogged;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 21/08/2018.
 */
public class AddBooks {

    private AddBooksScreen theAddBooksScreen;
    private LibrarianScreenLogged theLibrarianLoggedScreen;


    public AddBooks(AddBooksScreen theAddBooksScreen, LibrarianScreenLogged theLibrarianLoggedScreen){

        this.theAddBooksScreen = theAddBooksScreen;
        this.theLibrarianLoggedScreen = theLibrarianLoggedScreen;

        this.theAddBooksScreen.backBtnListener(new backButtonListener());
        this.theAddBooksScreen.addBooksBtnListener(new addBooksButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theAddBooksScreen.dispose();
                theLibrarianLoggedScreen.setVisible(true);
                theAddBooksScreen.setBookTitle(null);
                theAddBooksScreen.setBookAuthor(null);
                theAddBooksScreen.setBookISBN(null);
                theAddBooksScreen.setBookDate(null);
                theAddBooksScreen.setBookQuantity(null);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class addBooksButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

           /* String title,author = null;
            int isbn,quantity = 0;
            Date date = null;

            title = theAddBooksScreen.getBookTitle();
            author = theAddBooksScreen.getBookAuthor();
            isbn = theAddBooksScreen.getBookISBN();
            date = theAddBooksScreen.getBookDate();
            quantity = theAddBooksScreen.getBookQuantity();*/

            Book currentBook = new Book(theAddBooksScreen.getBookTitle(),theAddBooksScreen.getBookAuthor(),theAddBooksScreen.getBookQuantity(),theAddBooksScreen.getBookISBN(),theAddBooksScreen.getBookDate(),theAddBooksScreen.getBookDate());

            try {

                if (currentBook.addBook()){
                    theAddBooksScreen.displayErrorMessage("Success!");
                }else{
                    theAddBooksScreen.displayErrorMessage("Wrong!");
                }
                /*
                if (AddBooksM.addBook(title,author,isbn,date,quantity)){
                    theAddBooksScreen.displayErrorMessage("The book was successfully added!");
                }else{
                    theAddBooksScreen.displayErrorMessage("Something went wrong. Please try again.");
                }*/

                theAddBooksScreen.setBookTitle(null);
                theAddBooksScreen.setBookAuthor(null);
                theAddBooksScreen.setBookISBN(null);
                theAddBooksScreen.setBookDate(null);
                theAddBooksScreen.setBookQuantity(null);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

}
