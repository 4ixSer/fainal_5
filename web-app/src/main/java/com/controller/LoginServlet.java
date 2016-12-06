package com.controller;

import com.managers.LoginManeger;
import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

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

        String userPass = request.getParameter("password"); // с реквеста взяли параметро pass
        String userLog = request.getParameter("login");   //с реквеста взяли параметр log
        String response =LoginManeger.getInstance().logInUser(userLog, userPass); //проверили наличие чувака
        System.out.println();
        System.out.println(response);
        System.out.println();
        String result = response;

        jsonObject.put("message", response);
        jsonObject.put("result", result);

        return jsonObject;
    }
}
