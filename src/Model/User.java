package Model;

import java.sql.*;
import java.util.regex.Pattern;

/**
 * Created by megat0n on 01/09/2018.
 */
public class User {

    private String username;
    private String password;
    private String email;
    private String secretWord;
    private boolean isLibrarian;

    public  User(String username, String password){
        this.setUsername(username);
        this.setPassword(password);
    }

    public User(String username, String password, String email, String secretWord, boolean isLibrarian){
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setSecretWord(secretWord);
        this.setIsLibrarian(isLibrarian);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public boolean getIsLibrarian(){
        return isLibrarian;
    }

    public void setIsLibrarian(boolean isLibrarian){
        this.isLibrarian = isLibrarian;
    }


    public static Connection createConnection(boolean isLibrarian){

        Connection conn = null;
        String url = null;
        if (isLibrarian) {
            url = "jdbc:mysql://localhost:3306/librarianaccounts";
        }else {
            url = "jdbc:mysql://localhost:3306/studentaccounts";
        }

        String username = "root";
        String password = "L9i6e0b3e1";
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(url,username, password);
            System.out.println("Printing connection object " + conn);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }

    public int registerUser(){

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        String userName = username;
        String passWord = password;
        String eMail = email;
        String secredWord = secretWord;
        boolean isLib = isLibrarian;

        if (userName.equals("") || passWord.equals("") || eMail.equals("") || secredWord.equals("")){
            //return "Blank space, please fill all fields!";
            return 4;
        }
        if (!isValid(eMail)){
           // return "Please check your input for the email field!";
            return 1;
        }
        if (authenticateUserTaken(userName)){
           // return "Username is taken. Please try with another one.";
            return 2;
        }

        if (authenticateEmailTaken(eMail)){
            //return "Email is taken. Please try with another one.";
            return 3;
        }
        if (!isValidPassword(isLib)){
            return 5;
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

               // return "Success";
                return 1;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        //return "Something went wrong!";
        return 6;
    }

    public boolean isValidPassword(boolean isLibrarian){

        createConnection(isLibrarian);
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9@#$%^&+=*.\\-_]){8,16}$";
        Pattern pat = Pattern.compile(passwordRegex);
        if (this.getPassword() == null){
            return false;
        }
        return pat.matcher(this.getPassword()).matches();


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

    public boolean authenticateUser(boolean isLibrarian){

        Connection conn = null;
        String query = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String usernameDB = "";
        String passwordDB = "";

        try {

            conn = createConnection(isLibrarian);
            System.out.println("Authenticate User " + isLibrarian);
            if (isLibrarian){
                query = "SELECT userName,password FROM librarianaccounts";
            }else{
                query = "SELECT userName,password FROM studentaccounts";
            }
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){

                usernameDB = rs.getString("userName");
                passwordDB = rs.getString("password");

                if (this.getUsername().equals(usernameDB) && this.getPassword().equals(passwordDB)){
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
