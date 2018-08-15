package LibraryMain;

import LibraryController.LibraryController;
import LibraryModel.LibraryModel;
import LibraryView.LibraryView;
import LibraryModel.LibraryLibrarianLogin;
import LibraryModel.LibraryStudentLogin;
import LibraryModel.LibraryModelRegisterStudent;
import LibraryModel.LibraryModelRegisterLibrarian;
import LibraryModel.LibraryModelAddBooks;
import LibraryModel.LibraryModelViewBooks;
import LibraryModel.LibraryModelSearchBooks;
import LibraryModel.LibraryModelRemoveBooks;

/**
 * Created by megat0n on 28/07/2018.
 */
public class LibraryMain {

    public static void main(String[] args) {
        LibraryView theView = new LibraryView();
        LibraryModel theModel = new LibraryModel();
        LibraryLibrarianLogin theLibLogin = new LibraryLibrarianLogin();
        LibraryStudentLogin theStdLogin = new LibraryStudentLogin();
        LibraryModelRegisterStudent theStudentRegistration = new LibraryModelRegisterStudent();
        LibraryModelRegisterLibrarian theLibrarianRegistration = new LibraryModelRegisterLibrarian();
        LibraryModelAddBooks theAddBooks = new LibraryModelAddBooks();
        LibraryModelViewBooks theViewBooks = new LibraryModelViewBooks();
        LibraryModelSearchBooks theSearchBooks = new LibraryModelSearchBooks();
        LibraryModelRemoveBooks theRemoveBooks = new LibraryModelRemoveBooks();

        LibraryController theController = new LibraryController(theView,theModel, theLibLogin, theStdLogin,theStudentRegistration,theLibrarianRegistration,theAddBooks,theViewBooks,theSearchBooks,theRemoveBooks);
        theView.setVisible(true);
    }

}
