package Main;

import Controller.*;
import Model.SearchBooksM;
import Model.ViewBooksM;
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
        RegisterUserScreen theRegisterUserScreen = new RegisterUserScreen();
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
        LoginUserScreen theLoginUserScreen = new LoginUserScreen();
        ResetPasswordScreen theResetPassScreen = new ResetPasswordScreen();
        ViewBooksM theViewBooksM = new ViewBooksM();
        SearchBooksM theSearchBooksModel = new SearchBooksM();

        LoginUser theLoginUser = new LoginUser(theLoginUserScreen,theLibrarianLoggedScreen,theStudentLoggedScreen,theHomeScreen);


        Home theHomeScreenController = new Home(theHomeScreen,theHistoryFirst,theContactScreen,theRegisterDefaultScreen,theStudentLoginScreen,theLibrarianLoginScreen,theLoginUserScreen,theLoginUser,theResetPassScreen);
        theHomeScreen.setVisible(true);


        HistoryFirst theHistoryFirstController = new HistoryFirst(theHistoryFirst,theHomeScreen,theHistorySecond);
        HistorySecond theHistorySecondController = new HistorySecond(theHistorySecond,theHistoryFirst);
        Contact theContact = new Contact(theContactScreen, theHomeScreen);

        //RegisterDefault theRegisterDefault = new RegisterDefault(theRegisterDefaultScreen,theHomeScreen, theRegisterStudentScreen,theRegisterLibrarianScreen);
        RegisterDefault theRegisterDefault = new RegisterDefault(theRegisterDefaultScreen,theHomeScreen,theRegisterUserScreen);

        RegisterUser theRegisterUser = new RegisterUser(theRegisterUserScreen,theRegisterDefaultScreen);
        RegisterLibrarian theRegisterLibrarian = new RegisterLibrarian(theRegisterLibrarianScreen,theRegisterDefaultScreen);
        RegisterStudent theRegisterStudent = new RegisterStudent(theRegisterStudentScreen,theRegisterDefaultScreen);
        StudentLogin theLoginStudent = new StudentLogin(theStudentLoginScreen,theStudentLoggedScreen,theHomeScreen);
        LibrarianLogin theLoginLibrarian = new LibrarianLogin(theLibrarianLoginScreen,theLibrarianLoggedScreen,theHomeScreen);
        StudentLogged theLoggedStudent = new StudentLogged(theStudentLoggedScreen,theStudentLoginScreen,theSearchBooksScreen,theViewBooksScreen,theTakeBooksScreen,theReturnBooksScreen,theViewTakenBooksScreen,theLoginUserScreen);
        LibrarianLogged theLoggedLibrarian = new LibrarianLogged(theLibrarianLoggedScreen,theLibrarianLoginScreen,theAddBooksScreen,theRemoveBooksScreen,theSearchBooksScreen,theViewBooksScreen,theIssuedBooksScreen,theLoginUserScreen,theViewBooksM);
        AddBooks theAddBooks = new AddBooks(theAddBooksScreen,theLibrarianLoggedScreen);
        ViewBooks theViewBooks = new ViewBooks(theViewBooksScreen,theLibrarianLoggedScreen,theStudentLoggedScreen);
        RemoveBooks theRemoveBooks = new RemoveBooks(theRemoveBooksScreen,theLibrarianLoggedScreen);
        SearchBooks theSearchBooks = new SearchBooks(theSearchBooksScreen,theLibrarianLoggedScreen,theStudentLoggedScreen, theSearchBooksModel,theViewBooksScreen);
       // LoginUser theLoginUser = new LoginUser(theLoginUserScreen,theLibrarianLoggedScreen,theStudentLoggedScreen,theHomeScreen);
        ResetPassword theResetPassword = new ResetPassword(theResetPassScreen,theHomeScreen);
    }

}
