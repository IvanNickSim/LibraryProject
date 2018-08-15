package LibraryModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by megat0n on 01/08/2018.
 */
public class LibraryLibrarianLogin {


    public String authenticateUser(String userName, String password){


        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";

        try {

            //establishing connection
            conn = LibraryModelDatabaseLibrarians.createConnection();
            //Statement is used to write queries
            statement = conn.createStatement();
            //ResultSet is used to execute the written queries
            resultSet = statement.executeQuery("SELECT userName,password FROM librarianaccounts");

            while (resultSet.next()){

                userNameDB = resultSet.getString("userName");
                passwordDB = resultSet.getString("password");

                if (userName.equals(userNameDB) && password.equals(passwordDB)){
                    return "Success";
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return "Invalid user data";

    }


}
