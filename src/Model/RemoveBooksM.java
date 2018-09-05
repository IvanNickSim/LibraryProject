package Model;

import java.sql.*;

/**
 * Created by megat0n on 29/08/2018.
 */
public class RemoveBooksM {

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String bookTitle = null;
    String bookAuthor = null;

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


    public void removeBookByTitle(String title){

        bookTitle = title;

        try {

            conn = createConnection();
            String query = "DELETE from booksdatabase WHERE bookTitle = ? ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,bookTitle);
            preparedStatement.executeUpdate();


        }catch (SQLException sql){
            sql.printStackTrace();
        }

    }

    public boolean removeAllBooksByAuthor(String authorFullname){

        bookAuthor = authorFullname;

        try {

            conn = createConnection();
            String query = "DELETE from booksdatabase WHERE bookAuthor = ? ";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,bookAuthor);
            int i = preparedStatement.executeUpdate();
            if (i != 0) {
                return true;
            }

        }catch (SQLException sql){
            sql.printStackTrace();
        }
        return false;
    }

}
