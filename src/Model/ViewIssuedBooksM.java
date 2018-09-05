package Model;

import java.sql.*;

/**
 * Created by megat0n on 05/09/2018.
 */
public class ViewIssuedBooksM { Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String data[][] = null;
    String column[] = null;

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


    public String[] columnValue() {

        try {

            conn = createConnection();
            statement = conn.prepareStatement("SELECT * FROM booksdatabase WHERE bookQuantity <= 3 ORDER BY bookQuantity",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery();
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
            statement = conn.prepareStatement("SELECT * FROM booksdatabase WHERE bookQuantity <= 3 ORDER BY bookQuantity",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery();
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

    public String[] getColumn(){
        return this.column;
    }

    public String[][] getData(){
        return this.data;
    }

}