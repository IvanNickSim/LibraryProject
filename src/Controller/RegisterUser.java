package Controller;

import Model.User;
import View.RegisterScreenDefault;
import View.RegisterUserScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 23/08/2018.
 */
public class RegisterUser {

    private RegisterUserScreen theRegisterUserScreen;
    private RegisterScreenDefault theRegisterDefaultScreen;

    public RegisterUser(RegisterUserScreen theRegisterUserScreen, RegisterScreenDefault theRegisterDefaultScreen){

        this.theRegisterUserScreen = theRegisterUserScreen;
        this.theRegisterDefaultScreen = theRegisterDefaultScreen;

        this.theRegisterUserScreen.backBtnListener(new backButtonListener());
        this.theRegisterUserScreen.registerBtnListener(new registerButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theRegisterUserScreen.setUsername(null);
                theRegisterUserScreen.setPass(null);
                theRegisterUserScreen.setEmail(null);
                theRegisterUserScreen.setSecretWord(null);

                theRegisterUserScreen.dispose();
                theRegisterDefaultScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class registerButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            boolean isLibrarian = theRegisterUserScreen.getIsLibrarian();
            System.out.println(isLibrarian);
            try {

                User user = new User(theRegisterUserScreen.getUsername(),theRegisterUserScreen.getPass(), theRegisterUserScreen.getEmail(), theRegisterUserScreen.getSecretWord(),theRegisterUserScreen.getIsLibrarian());
                switch (user.registerUser()){

                    case 0:
                        theRegisterUserScreen.displayErrorMessage("Blank space, please fill all fields!");
                        break;
                    case 4:
                        theRegisterUserScreen.displayErrorMessage("Please check your input for the email field!");
                        break;
                    case 2:
                        theRegisterUserScreen.displayErrorMessage("Username is taken. Please try with another one.");
                        break;
                    case 3:
                        theRegisterUserScreen.displayErrorMessage("Email is taken. Please try with another one.");
                        break;
                    case 1:
                        System.out.println("Success!");
                        theRegisterUserScreen.displayErrorMessage("Success!");
                        theRegisterUserScreen.dispose();
                        theRegisterDefaultScreen.setVisible(true);
                        break;
                    case 5:
                        System.out.println("Password must contain at least one uppercase, one lowercase character, a number and the total length must be between 8-16!");
                        theRegisterUserScreen.displayErrorMessage("Password must contains: \n  -> min one uppercase character\n  -> min one lowercase character \n  -> min one number \n  -> total length between 8-16");
                        theRegisterUserScreen.dispose();
                        theRegisterUserScreen.setVisible(true);
                        break;

                    default:
                        theRegisterUserScreen.displayErrorMessage("Something went wrong!");
                        break;
                }
            }catch (Exception e1){
                e1.printStackTrace();
            }


            /*String uname,pass,email,secretWord = null;
            boolean isLibrarian = theRegisterUserScreen.getIsLibrarian();
            System.out.println(isLibrarian);
            try {
                uname = theRegisterUserScreen.getUsername();
                pass = theRegisterUserScreen.getPass();
                email = theRegisterUserScreen.getEmail();
                secretWord = theRegisterUserScreen.getSecretWord();
                System.out.println(uname);
                System.out.println(uname + " " + pass +" " + email +" " + secretWord );

                String result = RegisterUserM.registerUser(uname,pass,email,secretWord,isLibrarian);
                if (result.equals("Success")) {
                    theRegisterUserScreen.displayErrorMessage(result);
                    System.out.println("Success");
                    theRegisterUserScreen.setUsername(null);
                    theRegisterUserScreen.setPass(null);
                    theRegisterUserScreen.setEmail(null);
                    theRegisterUserScreen.setSecretWord(null);

                    theRegisterUserScreen.dispose();
                    theRegisterDefaultScreen.setVisible(true);

                }else{
                    System.out.println(result);
                    theRegisterUserScreen.displayErrorMessage(result);
                }



            }catch (Exception e2){
                e2.printStackTrace();
            }*/
        }
    }







}
