package Model;

import java.sql.*;

/**
 * Created by megat0n on 29/08/2018.
 */
public class SearchBooksM {

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String data[][] = null;
    String column[] = null;
    String bookTitle = null;
    String bookTitleDB = "";
    String bookAuthor = null;
    String bookAuthorDB = "";

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

    public String searchBooksByTitle(String title){

        this.bookTitle = title;

        if (bookTitle == null || bookTitle.isEmpty()){
            return "Blank Space. Please fill the Enter Title Field!";
        }

        try {
            conn = createConnection();
            String query = "SELECT * FROM booksdatabase WHERE bookTitle LIKE ?";
            // String sq="SELECT C_id FROM customer WHERE C_id='"+C_id+"' OR C_name='"+C_id+"' OR C_name Like '"+C_id+"%'"
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,bookTitle);
            resultSet = preparedStatement.executeQuery();
            System.out.println(bookTitleDB + " I am DB");
            System.out.println(bookTitle);
            while (resultSet.next()){
                bookTitleDB = resultSet.getString("bookTitle");
                System.out.println(bookTitleDB + " I am DB");
                System.out.println(bookTitle);
                if (bookTitleDB.contains(bookTitle)){
                    return "Success";
                }
            }
            if (bookTitleDB.contains(bookTitle)){
                return "Success";
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return "No Such a Book!";
    }


    public String[] columnValue() {

        try {

            conn = createConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM booksdatabase WHERE bookTitle LIKE ?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1,bookTitle);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int cols = resultSetMetaData.getColumnCount();
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = resultSetMetaData.getColumnName(i);
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return column;
    }

    public String[][] dataValue(){

        try {

            conn = createConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM booksdatabase WHERE bookTitle LIKE ?",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setString(1,bookTitle);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int cols = resultSetMetaData.getColumnCount();
            System.out.println(cols);
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = resultSetMetaData.getColumnName(i);
            }

            resultSet.last();
            int rows = resultSet.getRow();
            resultSet.beforeFirst();
            System.out.println(rows);
            data = new String[rows][cols];
            int count = 0;
            while (resultSet.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = resultSet.getString(i);
                }
                count++;
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return data;

    }

    public String searchBooksByAuthor(String author){

        this.bookAuthor = author;

        if (bookAuthor == null || bookAuthor.isEmpty()){
            return "Blank Space. Please fill the Enter Author Field!";
        }

        try {

            conn = createConnection();
            statement = conn.createStatement();
            String query="SELECT * FROM booksdatabase WHERE bookAuthor LIKE '"+bookAuthor+"%'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                bookAuthorDB = resultSet.getString("bookAuthor");
                if (bookAuthorDB.contains(bookAuthor)){
                    return "Success";
                }
            }
            if (bookAuthorDB.contains(bookAuthor)){
                return "Success";
            }


        }catch (SQLException sql){
            sql.printStackTrace();
        }

        return "No Books by this Author!";

    }


    public String[] columnValueAuthor() {

        try {

            conn = createConnection();
            String query="SELECT * FROM booksdatabase WHERE bookAuthor LIKE '"+bookAuthor+"%'";
            resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int cols = resultSetMetaData.getColumnCount();
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = resultSetMetaData.getColumnName(i);
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return column;
    }

    public String[][] dataValueAuthor(){

        try {

            conn = createConnection();
            String query="SELECT * FROM booksdatabase WHERE bookAuthor LIKE '"+bookAuthor+"%'";
            resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int cols = resultSetMetaData.getColumnCount();
            System.out.println(cols);
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = resultSetMetaData.getColumnName(i);
            }

            resultSet.last();
            int rows = resultSet.getRow();
            resultSet.beforeFirst();
            System.out.println(rows);
            data = new String[rows][cols];
            int count = 0;
            while (resultSet.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = resultSet.getString(i);
                }
                count++;
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }

        return data;

    }


}
