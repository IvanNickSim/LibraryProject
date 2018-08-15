package LibraryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by megat0n on 01/08/2018.
 */
public class LibraryModelRegisterStudent {

    public static String registerUser(String username, String password, String email, String secredword){

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        String userName = username;
        String passWord = password;
        String eMail = email;
        String secredWord = secredword;

        if (userName.equals("") || passWord.equals("") || eMail.equals("") || secredWord.equals("")){
            return "Blank Space, Please Fill ALL FIELDS!!!";
        }
        if (!eMail.contains("@") || eMail.substring(eMail.indexOf("@")+1).contains("@")
                || !eMail.substring(eMail.indexOf("@")+1).contains(".")){
            return "Please Check Your Input for EMAIL FIELD!";
        }


        try {
            conn = LibraryModelDatabaseStudents.createConnection();
            String query = "INSERT INTO studentaccounts(SlNo,userName,password,email,secredWord) values (NULL,?,?,?,?)";
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

        return "Something went WRONG!!!";
    }

}
