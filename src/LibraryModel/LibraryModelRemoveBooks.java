package LibraryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by megat0n on 14/08/2018.
 */
public class LibraryModelRemoveBooks {

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String bookTitle = null;
    String bookAuthor = null;

    public void removeBookByTitle(String title){

        bookTitle = title;

        try {

            conn = LibraryModelDatabaseBooks.createConnection();
            String query = "DELETE from booksdatabase WHERE bookTitle = ? ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,bookTitle);
            preparedStatement.executeUpdate();


        }catch (SQLException sql){
            sql.printStackTrace();
        }

    }

    public void removeAllBooksByAuthor(String authorFullname){

        bookAuthor = authorFullname;

        try {

            conn = LibraryModelDatabaseBooks.createConnection();
            String query = "DELETE from booksdatabase WHERE bookAuthor = ? ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,bookAuthor);
            preparedStatement.executeUpdate();

        }catch (SQLException sql){
            sql.printStackTrace();
        }

    }



}
