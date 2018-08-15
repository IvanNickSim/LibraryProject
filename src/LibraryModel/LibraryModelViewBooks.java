package LibraryModel;

import java.sql.*;

/**
 * Created by megat0n on 03/08/2018.
 */
public class LibraryModelViewBooks {



    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String data[][] = null;
    String column[] = null;


    public String[] columnValue() {

        try {

            conn = LibraryModelDatabaseBooks.createConnection();
            statement = conn.prepareStatement("SELECT * FROM booksdatabase",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
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

            conn = LibraryModelDatabaseBooks.createConnection();
            statement = conn.prepareStatement("SELECT * FROM booksdatabase",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
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



}
