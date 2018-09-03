package Model;

import java.sql.*;

/**
 * Created by megat0n on 28/08/2018.
 */
public class AddBooksM {


    public static Connection createConnection(){

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/booksdatabase";
        String username = "root";
        String password = "L9i6e0b3e1";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Printing connection object " + conn);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean addBook(String title, String author, int iSBN, Date date, int quantity){

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        String bookTitle = title;
        String bookAuthor = author;
        int bookISBN = iSBN;
        Date bookDate = date;
        int bookQuantity = quantity;

        try {
            conn = createConnection();
            String query = "INSERT INTO booksdatabase(booknr,bookTitle,bookAuthor,bookISBN,bookDate,bookQuantity) values (NULL,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,bookTitle);
            preparedStatement.setString(2,bookAuthor);
            preparedStatement.setInt(3,bookISBN);
            preparedStatement.setDate(4,bookDate);
            preparedStatement.setInt(5,bookQuantity);

            int i = preparedStatement.executeUpdate();
            if (i != 0){
                return true;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;

    }


}
