package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by megat0n on 28/08/2018.
 */
public class ResetPasswordM {

    public static Connection createConnection(boolean isLibrarian){

        Connection conn = null;
        String url;
        System.out.println("Connected "+isLibrarian);
        if (!isLibrarian) {
            url = "jdbc:mysql://localhost:3306/librarianaccounts";
        }else{
            url = "jdbc:mysql://localhost:3306/studentaccounts";
        }
        System.out.println(url);
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

    public static String returnPassword(String userName, String email, String secretWord){

        Connection conn = null;
        String query = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String usernameDB = "";
        String passwordDB = "";
        String secretwordDB = "";
        String emailDB = "";

        try {

            conn = createConnection(false);
            query = "SELECT userName,password,email,secredWord FROM librarianaccounts";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                usernameDB = rs.getString("userName");
                passwordDB = rs.getString("password");
                emailDB = rs.getString("email");
                secretwordDB = rs.getString("secredWord");

                if (userName.equals(usernameDB) && email.equals(emailDB) && secretWord.equals(secretwordDB)){
                    return passwordDB;
                }

            }

            conn = createConnection(true);
            query = "SELECT userName,password,email,secredWord FROM studentaccounts";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                usernameDB = rs.getString("userName");
                passwordDB = rs.getString("password");
                emailDB = rs.getString("email");
                secretwordDB = rs.getString("secredWord");

                if (userName.equals(usernameDB) && email.equals(emailDB) && secretWord.equals(secretwordDB)){
                    return passwordDB;
                }

            }

        }catch (Exception e1){
            e1.printStackTrace();
        }

        return null;
    }

}
