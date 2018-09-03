package Model;

import java.sql.*;

/**
 * Created by megat0n on 29/08/2018.
 */
public class Book {

    private String title;
    private String author;
    private int quantity;
    private int isbn;
    private Date takeDate;
    private Date returnDate;

    public Book(){
        this.title = null;
        this.author = null;
        this.quantity = 0;
        this.isbn = 0;
        this.takeDate = null;
        this.returnDate = null;
    }

    public Book(String title, String author, int quantity, int isbn, Date takeDate, Date returnDate){

        this.setTitle(title);
        this.setAuthor(author);
        this.setQuantity(quantity);
        this.setIsbn(isbn);
        this.setTakeDate(takeDate);
        this.setReturnDate(returnDate);

    }

    public boolean addBook(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {

            conn = createConnection();
            String query = "INSERT INTO booksdatabase(booknr,bookTitle,bookAuthor,bookISBN,bookQuantity,bookDate,bookDate1) values (NULL,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, getTitle());
            preparedStatement.setString(2, getAuthor());
            preparedStatement.setInt(3, getIsbn());
            preparedStatement.setInt(4, getQuantity());
            preparedStatement.setDate(5, getTakeDate());
            preparedStatement.setDate(6, getReturnDate());

            int i = preparedStatement.executeUpdate();
            if (i != 0){
                return true;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean searchBooksByTitle(String title){

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String bookTitleDB = null;

        if (title == null || title.isEmpty()){
            return false;
        }
        try {
            conn = createConnection();
            String query = "SELECT * FROM booksdatabase WHERE bookTitle REGEXP '"+title+"' ORDER BY bookTitle";
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                bookTitleDB = resultSet.getString("bookTitle");
                System.out.println(bookTitleDB + " I am DB");
                System.out.println(title);
                if (bookTitleDB.contains(title)){
                    return true;
                }
            }
            assert bookTitleDB != null;
            if (bookTitleDB.contains(title)){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }



    public String[] columnValue(String title) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String column[] = null;
        Statement statement = null;

        try {

            conn = createConnection();
            String query = "SELECT * FROM booksdatabase WHERE bookTitle REGEXP '"+title+"' ORDER BY bookTitle";
            statement = conn.prepareStatement("SELECT * FROM booksdatabase WHERE bookTitle REGEXP '"+title+"' ORDER BY bookTitle",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
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

    public String[][] dataValue(String title){

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String column[] = null;
        String data[][] = null;
        Statement statement = null;

        try {

            conn = createConnection();
            String query = "SELECT * FROM booksdatabase WHERE bookTitle REGEXP '"+title+"' ORDER BY bookTitle";
            statement = conn.prepareStatement("SELECT * FROM booksdatabase WHERE bookTitle REGEXP '"+title+"' ORDER BY bookTitle",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
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
/*
    public String[] getColumn(){
        return this.column;
    }

    public String[][] getData(){
        return this.data;
    }*/

/*
    public String[] columnValue(String title) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String column[] = null;

        try {

            conn = createConnection();
            String query = "SELECT * FROM booksdatabase WHERE bookTitle REGEXP '"+title+"' ORDER BY bookTitle";

            preparedStatement = conn.prepareStatement(query);
         //   preparedStatement.setString(1,title);
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

    public String[][] dataValue(String title){

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String data[][] = null;
        String column[] = null;

        try {

            conn = createConnection();
            String query = "SELECT * FROM booksdatabase WHERE bookTitle REGEXP '"+title+"' ORDER BY bookTitle";

            preparedStatement = conn.prepareStatement(query);
           // preparedStatement.setString(1,title);
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

    }*/



}
