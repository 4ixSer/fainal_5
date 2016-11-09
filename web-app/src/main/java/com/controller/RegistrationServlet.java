package com.controller;

import com.managers.LoginManeger;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qny4i on 09.11.2016.
 */
public class RegistrationServlet  extends APIHandlerServlet.APIRequestHandler{


    public static final RegistrationServlet instance = new RegistrationServlet();


    public static RegistrationServlet getInstance() {
        return instance;
    }

    private RegistrationServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();       //создали обьект JSONObject

        String userPass = request.getParameter("password"); // с реквеста взяли параметро pass
        String userLog = request.getParameter("login");   //с реквеста взяли параметр log
        String response = LoginManeger.getInstance().registerInUser(userLog, userPass); //проверили наличие чувака
        System.out.println();
        System.out.println(response);
        System.out.println();

        String result = (response.charAt(0) == 'R') ? "OK" : "NO";

        jsonObject.put("message", response);
        jsonObject.put("result", result);

        return jsonObject;
    }
}
