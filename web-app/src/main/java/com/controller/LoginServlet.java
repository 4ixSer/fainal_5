package com.controller;

import DAO.factory.Factoty;
import com.entity.User;
import com.managers.LoginManeger;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.FactoryConfigurationError;

/**
 * Created by cube on 20.08.2016.
 */
public class LoginServlet extends APIHandlerServlet.APIRequestHandler {

    public static final LoginServlet instance = new LoginServlet();


    public static LoginServlet getInstance() {
        return instance;
    }

    private LoginServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();       //создали обьект JSONObject
        String userPass = request.getParameter("pass"); // с реквеста взяли параметро pass
        String userLog = request.getParameter("log");   //с реквеста взяли параметр log
        String tokenString = userLog +userPass+ System.currentTimeMillis() + (Math.random() * System.currentTimeMillis());      //опять хрень с временим
//        String md5Hex = DigestUtils.md5Hex(tokenString);        //создали токен НАверное зачемто нужен
//        System.out.println(md5Hex);         //распечатали его
//        jsonObject.put("key",md5Hex);           //запиънуди в ответ название паратмера - ответ
        jsonObject.put("result", "ok");
       // Factory.getInstance().getUserDAO();

        Factoty.getInstance().getUserDAO().createUser(new User(userLog,userPass,userLog));
        System.out.println(Factoty.getInstance().getUserDAO().findUser(3));
        LoginManeger
        System.out.println(jsonObject);
        return jsonObject;
    }
}
