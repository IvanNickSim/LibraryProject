package LibraryModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by megat0n on 02/08/2018.
 */
public class LibraryModelDatabaseBooks {

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

}
