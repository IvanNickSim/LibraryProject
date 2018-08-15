package LibraryModel;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by megat0n on 01/08/2018.
 */
public class LibraryStudentLogin {

    public String authenticateUser(String userName, String password){

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";

        try {

            //establishing connection
            conn = LibraryModelDatabaseStudents.createConnection();
            //writing query
            statement = conn.createStatement();
            //executing Query
            resultSet = statement.executeQuery("SELECT userName,password FROM studentaccounts");


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
