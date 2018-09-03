package Model;

import java.sql.*;
import java.util.regex.Pattern;

/**
 * Created by megat0n on 23/08/2018.
 */
public class RegisterUserM {

    public static Connection createConnection(boolean isLibrarian){

        Connection conn = null;
        String url;
        if (isLibrarian) {
            url = "jdbc:mysql://localhost:3306/librarianaccounts";
        }else{
            url = "jdbc:mysql://localhost:3306/studentaccounts";
        }
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

    public static String registerUser(String username, String password, String email, String secredword,boolean isLibrarian){

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        String userName = username;
        String passWord = password;
        String eMail = email;
        String secredWord = secredword;
        boolean isLib = isLibrarian;

        if (userName.equals("") || passWord.equals("") || eMail.equals("") || secredWord.equals("")){
            return "Blank space, please fill all fields!";
        }
        if (!isValid(eMail)){
            return "Please check your input for the email field!";
        }
        if (authenticateUserTaken(userName)){
            return "Username is taken. Please try with another one.";
        }

        if (authenticateEmailTaken(eMail)){
            return "Email is taken. Please try with another one.";
        }

        try {
            conn = createConnection(isLibrarian);
            String query;
            if (isLib) {
                query = "INSERT INTO librarianaccounts(SlNo,userName,password,email,secredWord) values (NULL,?,?,?,?)";
            }else{
                query = "INSERT INTO studentaccounts(SlNo,userName,password,email,secredWord) values (NULL,?,?,?,?)";
            }
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,passWord);
            preparedStatement.setString(3,eMail);
            preparedStatement.setString(4,secredWord);

            int i = preparedStatement.executeUpdate();
            if (i!=0){

                return "Success";
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return "Something went wrong!";
    }


    public static boolean isValid(String email)
    {
        //sukrashtavane na regexa
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    //Same username for librarian and student is not allowed
    public static boolean authenticateUserTaken(String username){
        Connection conn = null;
        String query = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String usernameDB = null;


        try{

            conn = createConnection(true);
            query = "SELECT userName FROM librarianaccounts";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                usernameDB = rs.getString("userName");
                if (username.equals(usernameDB)){
                    System.out.println("Username Exists");
                    return true;
                }
            }

            conn = createConnection(false);
            query = "SELECT userName FROM studentaccounts";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                usernameDB = rs.getString("userName");
                if (username.equals(usernameDB)){
                    System.out.println("Username Exists");
                    return true;
                }
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    //Same email for librarian and student is not allowed
    public static boolean authenticateEmailTaken(String email){

        Connection conn = null;
        String query = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String emailDB = "";

        try {
            conn = createConnection(true);
            query = "SELECT email FROM librarianaccounts";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                emailDB = rs.getString("email");
                if (email.equals(emailDB)){
                    System.out.println("Email Exists");
                    return true;
                }
            }

            conn = createConnection(false);
            query = "SELECT email FROM studentaccounts";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                emailDB = rs.getString("email");
                if (email.equals(emailDB)){
                    System.out.println("Email Exists");
                    return true;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }



}
