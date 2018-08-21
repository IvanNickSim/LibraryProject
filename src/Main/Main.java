package Main;

import Controller.*;
import View.*;

/**
 * Created by megat0n on 19/08/2018.
 */
public class Main {

    public static void main(String[] args) {

        HomeScreen theHomeScreen = new HomeScreen();
        HistoryScreenFirst theHistoryFirst = new HistoryScreenFirst();
        HistoryScreenSecond theHistorySecond = new HistoryScreenSecond();
        ContactScreen theContactScreen = new ContactScreen();
        RegisterScreenDefault theRegisterDefaultScreen = new RegisterScreenDefault();
        RegisterScreenStudent theRegisterStudentScreen = new RegisterScreenStudent();
        RegisterScreenLibrarian theRegisterLibrarianScreen = new RegisterScreenLibrarian();
        StudentScreenLogin theStudentLoginScreen = new StudentScreenLogin();
        LibrarianScreenLogin theLibrarianLoginScreen = new LibrarianScreenLogin();
        StudentScreenLogged theStudentLoggedScreen = new StudentScreenLogged();
        LibrarianScreenLogged theLibrarianLoggedScreen = new LibrarianScreenLogged();
        AddBooksScreen theAddBooksScreen = new AddBooksScreen();
        RemoveBooksScreen theRemoveBooksScreen = new RemoveBooksScreen();
        SearchBooksScreen theSearchBooksScreen = new SearchBooksScreen();
        ViewBooksScreen theViewBooksScreen = new ViewBooksScreen();
        IssuedBooksScreen theIssuedBooksScreen = new IssuedBooksScreen();
        TakeBooksScreen theTakeBooksScreen = new TakeBooksScreen();
        ReturnBooksScreen theReturnBooksScreen = new ReturnBooksScreen();
        ViewTakenBooksScreen theViewTakenBooksScreen = new ViewTakenBooksScreen();


        Home theHomeScreenController = new Home(theHomeScreen,theHistoryFirst,theContactScreen,theRegisterDefaultScreen,theStudentLoginScreen,theLibrarianLoginScreen);
        theHomeScreen.setVisible(true);


        HistoryFirst theHistoryFirstController = new HistoryFirst(theHistoryFirst,theHomeScreen,theHistorySecond);
        HistorySecond theHistorySecondController = new HistorySecond(theHistorySecond,theHistoryFirst);
        Contact theContact = new Contact(theContactScreen, theHomeScreen);
        RegisterDefault theRegisterDefault = new RegisterDefault(theRegisterDefaultScreen,theHomeScreen, theRegisterStudentScreen,theRegisterLibrarianScreen);
        RegisterLibrarian theRegisterLibrarian = new RegisterLibrarian(theRegisterLibrarianScreen,theRegisterDefaultScreen);
        RegisterStudent theRegisterStudent = new RegisterStudent(theRegisterStudentScreen,theRegisterDefaultScreen);
        StudentLogin theLoginStudent = new StudentLogin(theStudentLoginScreen,theStudentLoggedScreen,theHomeScreen);
        LibrarianLogin theLoginLibrarian = new LibrarianLogin(theLibrarianLoginScreen,theLibrarianLoggedScreen,theHomeScreen);
        StudentLogged theLoggedStudent = new StudentLogged(theStudentLoggedScreen,theStudentLoginScreen,theSearchBooksScreen,theViewBooksScreen,theTakeBooksScreen,theReturnBooksScreen,theViewTakenBooksScreen);
        LibrarianLogged theLoggedLibrarian = new LibrarianLogged(theLibrarianLoggedScreen,theLibrarianLoginScreen,theAddBooksScreen,theRemoveBooksScreen,theSearchBooksScreen,theViewBooksScreen,theIssuedBooksScreen);
        AddBooks theAddBooks = new AddBooks(theAddBooksScreen,theLibrarianLoggedScreen);
        ViewBooks theViewBooks = new ViewBooks(theViewBooksScreen,theLibrarianLoggedScreen);
    }

}
