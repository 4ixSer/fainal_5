package com.managers;

import DAO.factory.Factoty;
import com.entity.ActiveSession;
import com.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by qny4i on 08.11.2016.
 */
public class LoginManeger {
    private static LoginManeger instance = null;

    private LoginManeger() {
    }

    public static synchronized LoginManeger getInstance() {
        if (instance == null)
            instance = new LoginManeger();
        return instance;
    }



    public String logInUser(String login, String password) throws NoSuchAlgorithmException {

        User userNew = Factoty.getInstance().getUserDAO().findByLogin(login);

        if (userNew == null){
            System.out.println("User not found.");
            return "UserNotFound";
        }

        if (!userNew.getUserPassword().equals(password)){

            System.out.println("Password is incorrect. Min length is 5, max length is 24");
            return "PasswordIsIncorrect";
        }


        String tokenString = userNew.getUserName() + System.currentTimeMillis() + (Math.random() * System.currentTimeMillis());
        String md5Hex = DigestUtils.md5Hex(tokenString);

        System.out.println(md5Hex);

        ActiveSession activeSession = Factoty.getInstance().getActiveSessionDAO().findByUser(userNew);
        if (activeSession == null) {
            activeSession = new ActiveSession(userNew, new Date(), md5Hex);
            Factoty.getInstance().getActiveSessionDAO().createActiveSession(activeSession);
        } else {
            activeSession.setLoginTime(new Date());
            activeSession.setToken(md5Hex);
            Factoty.getInstance().getActiveSessionDAO().updateActiveSession(activeSession);
        }

       return "LoginSuccess";
    }

    public String registerInUser(String login, String password) {
        User userNew = Factoty.getInstance().getUserDAO().findByLogin(login);
        if (userNew != null) {

            System.out.println( "Login is already in use.");
            return "LoginIsUse";
        }

        System.out.println(password.length());
        if ((password.length()<5)||(password.length()>24)) {

            System.out.println("Password is incorrect. Min length is 5, max length is 24");
            return "PasswordIsIncorrect";
        }
        Factoty.getInstance().getUserDAO().createUser(new User(login,password,"name"));

        System.out.println( "Registration is success.");
        return "RegistrSuccess";
    }



}
