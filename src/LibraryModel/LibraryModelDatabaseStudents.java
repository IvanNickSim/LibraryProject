package LibraryModel;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by megat0n on 01/08/2018.
 */
public class LibraryModelDatabaseStudents {

    public static Connection createConnection(){

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/studentaccounts";
        String username = "root";
        String password = "L9i6e0b3e1";

        try {
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }

            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Printing connection object " + conn);
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

}
