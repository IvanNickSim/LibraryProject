package LibraryController;

import LibraryModel.*;
import LibraryView.LibraryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 * Created by megat0n on 28/07/2018.
 */
public class LibraryController {

    private LibraryView theView;
    private LibraryModel theModel;
    private LibraryLibrarianLogin theLibrarianLogin;
    private LibraryStudentLogin theStudentLogin;
    private LibraryModelRegisterStudent theStudentRegistration;
    private LibraryModelRegisterLibrarian theLibrarianRegistration;
    private LibraryModelAddBooks theAddBooks;
    private LibraryModelViewBooks theViewBooks;
    private LibraryModelSearchBooks theSearchBooks;
    private LibraryModelRemoveBooks theRemoveBooks;

    public LibraryController(LibraryView theView, LibraryModel theModel, LibraryLibrarianLogin theLoginLibrarian, LibraryStudentLogin theStudentLogin, LibraryModelRegisterStudent theStudentRegistration, LibraryModelRegisterLibrarian theLibrarianRegistration, LibraryModelAddBooks theAddBooks, LibraryModelViewBooks theViewBooks, LibraryModelSearchBooks theSearchBooks, LibraryModelRemoveBooks theRemoveBooks){

        this.theView = theView;
        this.theModel = theModel;
        this.theLibrarianLogin = theLoginLibrarian;
        this.theStudentLogin = theStudentLogin;
        this.theStudentRegistration = theStudentRegistration;
        this.theLibrarianRegistration = theLibrarianRegistration;
        this.theAddBooks = theAddBooks;
        this.theViewBooks = theViewBooks;
        this.theSearchBooks = theSearchBooks;
        this.theRemoveBooks = theRemoveBooks;

        this.theView.backStartPanel(new backButtonListener());
        this.theView.backHistoryPanel(new backButtonListenerHistorySecond());
        this.theView.backContactPanel(new backButtonListenerContact());
        this.theView.backLibrarianPanel(new backButtonListenerLibrarian());
        this.theView.loginLibrarianPanel(new loginButtonListenerLibrarian());
        this.theView.loginStudentPanel(new loginButtonListenerStudent());
        this.theView.setRegisterStudentButton(new registerButtonStudentListener());
        this.theView.setRegisterLibrarianButton(new registerButtonLibrarianListener());
        this.theView.logoutLibrarianBtn(new logoutLibrarianButtonListener());
        this.theView.logoutStudentBtn(new logoutStudentButtonListener());
        this.theView.setBackViewBooksButtonLibrarian(new backViewBooksButtonListenerLibrarian());
        this.theView.setBackViewBooksButtonStudent(new backViewBooksButtonListenerStudent());
        this.theView.setBackSearchBooksButtonLibrarian(new backSearchButtonListenerLibrarian());
        this.theView.setBackSearchBooksButtonStudent(new backSearchButtonListenerStudent());
        this.theView.setSearchBooksIntFirstFrameLibrarianAuthorSearch(new backSearchAuthorLibrarianButton());
        this.theView.setSearchBooksIntFirstFrameLibrarianTitleSearch(new backSearchTitleLibrarianButton());
        this.theView.setSearchBooksIntFirstFrameStudentAuthorSearch(new backSearchAuthorStudentButton());
        this.theView.setSearchBooksIntFirstFrameStudentTitleSearch(new backSearchTitleStudentButton());

        this.theView.addBooksLibPanel(new addBookLibrarianListener());
        this.theView.addBooksButtonAddBooks(new addBooksButtonAddBooks());
        this.theView.viewBooksButtonLibrarian(new viewBooksButtonListenerLibrarian());
        this.theView.viewBooksButtonStudent(new viewBooksButtonListenerStudent());
        this.theView.setRemoveButtonLibrarian(new removeBooksListenerLibrarian());
        this.theView.searchBooksLibrarianButton(new searchBooksLoggedLibrarianButton());
        this.theView.searchBooksStudentButton(new searchBooksLoggedStudentButton());
        this.theView.searchBooksInsideLibrarianButton(new searchBooksButtonListenerLibrarian());
        this.theView.searchAuthorInsideLibrarianButton(new searchBooksAuthorButtonListenerLibrarian());
        this.theView.searchBooksInsideStudentButton(new searchBooksButtonListenerStudent());
        this.theView.searchAuthorInsideStudentButton(new searchBooksAuthorButtonListenerStudent());
        this.theView.removeBookByTitleButton(new removeBookByTitleButtonListener());
        this.theView.removeBooksByAuthorButton(new removeBooksByAuthorButtonListener());

        this.theView.backRemoveBooksFrameButton(new backRemoveButtonListener());
        this.theView.backStudentPanel(new backButtonListenerStudent());
        this.theView.nextStartPanel(new nextButtonListenerHistoryFirst());
        this.theView.backFirstRegisterPanel(new backButtonListenerRegisterFirst());
        this.theView.setRegisterStudentWindow(new studentRegisterButtonListener());
        this.theView.setRegisterLibrarianWindow(new librarianRegisterButtonListener());

        this.theView.setBackLibrarianRegister(new backButtonLibrarianRegister());
        this.theView.setBackStudentRegister(new backButtonStudentRegister());
        this.theView.backAddBooksFrameButton(new backButtonAddBooks());

        //start frame buttons
        this.theView.setLibrarianLogin(new librarianLoginButtonListener());
        this.theView.setStudentLogin(new studentLoginButtonListener());
        this.theView.setRegister(new registerButtonListener());
        this.theView.setForgotPass(new forgotPassButtonListener());
        this.theView.setHistoryFrame(new historyButtonListener());
        this.theView.setContactFrame(new contactButtonListener());


    }

    class backSearchAuthorStudentButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setSearchBooksFirstFrameFromSearchAuthorStudent();

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backSearchTitleStudentButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                theView.setSearchBooksFirstFrameFromSearchTitleStudent();

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


    class backSearchAuthorLibrarianButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setSearchBooksFirstFrameFromSearchAuthor();

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backSearchTitleLibrarianButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                theView.setSearchBooksFirstFrameFromSearchTitle();

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class removeBookByTitleButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.displayErrorMessage("Clicked");
                String result = theSearchBooks.searchBooksByTitle(theView.getRemovedTitleBook());
                if (result.equals("No Such a Book!")){
                    theView.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Title Field!")){
                    theView.displayErrorMessage(result);
                }else {
                    theRemoveBooks.removeBookByTitle(theView.getRemovedTitleBook());
                    theView.displayErrorMessage("Book " + theView.getRemovedTitleBook() + " was successfully removed!");
                }

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class removeBooksByAuthorButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.displayErrorMessage("Clicked");
                String result = theSearchBooks.searchBooksByAuthor(theView.getRemovedAuthorBooks());
                if (result.equals("No Books by this Author!")){
                    theView.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Author Field!")){
                    theView.displayErrorMessage(result);
                }else {
                    theRemoveBooks.removeAllBooksByAuthor(theView.getRemovedAuthorBooks());
                    theView.displayErrorMessage("Book/s by " + theView.getRemovedAuthorBooks() + " was/were successfully removed!");
                }

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backRemoveButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setLoggedLibrarianFromRemoveBooks();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class removeBooksListenerLibrarian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.displayErrorMessage("Clicking Remove Books");
                theView.setRemoveBooksLibrarian();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backSearchButtonListenerLibrarian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage(":::");
                theView.setLoggedLibrarianFromSearchBooks();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backSearchButtonListenerStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage(":::");
                theView.setLoggedStudentFromSearchBooks();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class searchBooksLoggedLibrarianButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.displayErrorMessage("Clicked");
                theView.setSearchBooksLibrarian();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class searchBooksLoggedStudentButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.displayErrorMessage("Clicked");
                theView.setSearchBooksStudent();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backViewBooksButtonListenerStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setLoggedStudentFromViewBooks();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


    class backViewBooksButtonListenerLibrarian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setLoggedLibrarianFromViewBooks();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class searchBooksButtonListenerLibrarian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String result = theSearchBooks.searchBooksByTitle(theView.getSearchedTitle());
                if (result.equals("No Such a Book!")){
                    theView.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Title Field!")){
                    theView.displayErrorMessage(result);
                }else {
                    String data[][] = theSearchBooks.dataValue();
                    String column[] = theSearchBooks.columnValue();
                    theView.setSearchedBooksLibrarian(data, column);
                }


            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class searchBooksAuthorButtonListenerLibrarian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String result = theSearchBooks.searchBooksByAuthor(theView.getSearchedAuthor());
                if (result.equals("No Books by this Author!")){
                    theView.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Author Field!")){
                    theView.displayErrorMessage(result);
                }else {
                    String data[][] = theSearchBooks.dataValueAuthor();
                    String column[] = theSearchBooks.columnValueAuthor();
                    theView.setSearchedAuthorLibrarianView(data, column);
                }


            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


    class searchBooksButtonListenerStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String result = theSearchBooks.searchBooksByTitle(theView.getSearchedTitleStudent());
                if (result.equals("No Such a Book!")){
                    theView.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Title Field!")){
                    theView.displayErrorMessage(result);
                }else {
                    String data[][] = theSearchBooks.dataValue();
                    String column[] = theSearchBooks.columnValue();
                    theView.setSearchedBooksStudent(data, column);
                }


            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class searchBooksAuthorButtonListenerStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{

                String result = theSearchBooks.searchBooksByAuthor(theView.getSearchedAuthorStudent());
                if (result.equals("No Books by this Author!")){
                    theView.displayErrorMessage(result);
                }else if(result.equals("Blank Space. Please fill the Enter Author Field!")){
                    theView.displayErrorMessage(result);
                }else {
                    String data[][] = theSearchBooks.dataValueAuthor();
                    String column[] = theSearchBooks.columnValueAuthor();
                    theView.setSearchedAuthorStudentView(data, column);
                }


            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }


    class viewBooksButtonListenerLibrarian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String data[][] =theViewBooks.dataValue();
                String column[] = theViewBooks.columnValue();
                theView.setViewBooksLibrarian(data,column);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class viewBooksButtonListenerStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String data[][] =theViewBooks.dataValue();
                String column[] = theViewBooks.columnValue();
                theView.setViewBooksStudent(data,column);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class logoutLibrarianButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setLogoutLibrarian();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class logoutStudentButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setLogoutStudent();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class addBookLibrarianListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage("Clicked");
                theView.setAddBookIntFrame();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class registerButtonLibrarianListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String uname,pass,email,secretWord = null;
            try {
                uname = theView.getUsernameRegisterLibrarian();
                pass = theView.getPasswordRegisterLibrarian();
                email = theView.getEmailRegisterLibrarian();
                secretWord = theView.getSecretWordRegisterLibrarian();

                String result = LibraryModelRegisterLibrarian.registerUser(uname,pass,email,secretWord);
                if (result.equals("Success")){
                    theView.displayErrorMessage(result);
                    theView.setFirstRegFromLibReg();
                }else{
                    theView.displayErrorMessage(result);
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class registerButtonStudentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String uname,pass, email,secretWord = null;
            try {
                uname = theView.getUsernameRegisterStudent();
                pass = theView.getPasswordRegisterStudent();
                email = theView.getEmailRegisterStudent();
                secretWord = theView.getSecretWordRegisterStudent();

                String result = LibraryModelRegisterStudent.registerUser(uname,pass,email,secretWord);
                if (result.equals("Success")){
                    theView.displayErrorMessage(result);
                    theView.setFirstRegFromStdReg();
                }else{
                    theView.displayErrorMessage(result);
                }

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class loginButtonListenerStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String uname,pass = null;
            try {

                uname = theView.getUsernameStudent();
                pass = theView.getPasswordStudent();
                String result = theStudentLogin.authenticateUser(uname,pass);

                if (result.equals("Success")){
                    theView.displayErrorMessage(result);
                    theView.setLoggedStudent();

                }else{
                    theView.displayErrorMessage(result);

                }

            }catch (Exception e1){
                theView.displayErrorMessage(theView.getPasswordStudent());
                e1.printStackTrace();
            }
        }
    }

    class loginButtonListenerLibrarian implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String uname,pass = null;
            try{
                /*int[]i = new int[5];
                i[7] = 15;*/

                uname = theView.getUsernameLibrarian();
                pass = theView.getPasswordLibrarian();
                String result = theLibrarianLogin.authenticateUser(uname,pass);

                if (result.equals("Success")){
                    theView.displayErrorMessage(result);
                    theView.setLoggedLibrarian();


                }else{
                    theView.displayErrorMessage(result);
                }


            }catch (Exception e1){
                theView.displayErrorMessage(theView.getPasswordLibrarian());
                e1.printStackTrace();
            }
        }
    }

    class addBooksButtonAddBooks implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                String title = theView.getBookTitle();
                String author = theView.getBookAuthor();
                int ISBN = theView.getBookISBN();
                Date date = theView.getBookDate();
                int quantity = theView.getBookQuantity();

                String result = theAddBooks.addBook(title,author,ISBN,date,quantity);
                if (result.equals("Success")){
                    theView.displayErrorMessage(result);
                    theView.setLoggedLibrarianFromAddBooks();
                }

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backButtonAddBooks implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setLoggedLibrarianFromAddBooks();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class backButtonLibrarianRegister implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
               // theView.displayErrorMessage("HAHA  LIBRARIAN");
                theView.setFirstRegFromLibReg();
            }catch (Exception e17){
                e17.printStackTrace();
            }
        }
    }

    class backButtonStudentRegister implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage("HAHA  STUDENT");
                theView.setFirstRegFromStdReg();
            }catch (Exception e17){
                e17.printStackTrace();
            }
        }
    }

    class librarianRegisterButtonListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setRegisterLibrarian();
            }catch (Exception e14){
                e14.printStackTrace();
            }
        }
    }

    class studentRegisterButtonListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage("BackButtonClicked!");
                theView.setRegisterStudent();
            }catch (Exception e13){
                e13.printStackTrace();
            }
        }
    }

    class backButtonListenerRegisterFirst implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //  theView.displayErrorMessage("BackButtonClicked!");
                theView.setStartPanelFirstRegistration();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
              //  theView.displayErrorMessage("BackButtonClicked!");
                theView.setStartPanel();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    class backButtonListenerContact implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setStartPanelAgain();
            }catch (Exception e6){
                e6.printStackTrace();
            }
        }
    }

    class backButtonListenerHistorySecond implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setHistoryPanel();
            }catch (Exception e4){
                e4.printStackTrace();
            }
        }
    }

    class backButtonListenerLibrarian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage("BackButtonClicked!");
                theView.setStartPanelLibrarian();
            }catch (Exception e11){
                e11.printStackTrace();
            }
        }
    }

    class backButtonListenerStudent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage("BackButtonClicked!");
                theView.setStartPanelStudent();
            }catch (Exception e12){
                e12.printStackTrace();
            }
        }
    }

    class nextButtonListenerHistoryFirst implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //theView.displayErrorMessage("NextButtonClicked!");
                theView.setHistorySecond();
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

   //StartFrame button listeners

    class librarianLoginButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setLibrarianLogin();
            }catch (Exception e7){
                e7.printStackTrace();
            }
        }
    }

    class studentLoginButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setStudentLogin();
            }catch (Exception e8){
                e8.printStackTrace();
            }
        }
    }

    class registerButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setRegister();
                //theView.displayErrorMessage("Nothing over here! Wait for the update! :D :D");
            }catch (Exception e9){
                e9.printStackTrace();
            }
        }
    }

    class forgotPassButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setForgotPass();
                theView.displayErrorMessage("Nothing over here! Wait for the update! :D :D");
            }catch (Exception e10){
                e10.printStackTrace();
            }
        }
    }

    class historyButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // theView.displayErrorMessage("HistoryButtonClicked!");
                theView.setHistory();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class contactButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.setContact();
            }catch (Exception e5){
                e5.printStackTrace();
            }
        }
    }

}
