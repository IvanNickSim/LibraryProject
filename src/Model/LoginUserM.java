package Model;

import java.sql.*;

/**
 * Created by megat0n on 24/08/2018.
 */
public class LoginUserM {

    public static Connection createConnection(boolean isLibrarian){

        Connection conn = null;
        String url;
        System.out.println("Connected "+isLibrarian);
        //change
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

    public static boolean authenticateUser(String userName, String password, boolean isLibrarian){

        Connection conn = null;
        String query = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String usernameDB = "";
        String passwordDB = "";

        try {

            conn = createConnection(isLibrarian);
            System.out.println("Authenticate User " + isLibrarian);
            if (!isLibrarian){
                query = "SELECT userName,password FROM librarianaccounts";
            }else{
                query = "SELECT userName,password FROM studentaccounts";
            }
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){

                usernameDB = rs.getString("userName");
                passwordDB = rs.getString("password");

                if (userName.equals(usernameDB) && password.equals(passwordDB)){
                    System.out.println("Success!");
                    return true;
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }


}
