package LibraryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 * Created by megat0n on 02/08/2018.
 */
public class LibraryModelAddBooks {

    public static String addBook(String title, String author, int iSBN, Date date, int quantity){

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        String bookTitle = title;
        String bookAuthor = author;
        int bookISBN = iSBN;
        Date bookDate = date;
        int bookQuantity = quantity;

        try {
            conn = LibraryModelDatabaseBooks.createConnection();
            String query = "INSERT INTO booksdatabase(booknr,bookTitle,bookAuthor,bookISBN,bookDate,bookQuantity) values (NULL,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,bookTitle);
            preparedStatement.setString(2,bookAuthor);
            preparedStatement.setInt(3,bookISBN);
            preparedStatement.setDate(4,bookDate);
            preparedStatement.setInt(5,bookQuantity);

            int i = preparedStatement.executeUpdate();
            if (i != 0){
                return "Success";
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return "Something went wrong!!!";

    }

}
