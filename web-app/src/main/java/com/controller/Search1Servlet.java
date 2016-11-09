package com.controller;

import DAO.factory.Factoty;
import com.entity.Sauna;
import com.managers.LoginManeger;
import com.managers.SearchManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by qny4i on 10.11.2016.
 */
public class Search1Servlet extends APIHandlerServlet.APIRequestHandler {

    public static final Search1Servlet instance = new Search1Servlet();


    public static Search1Servlet getInstance() {
        return instance;
    }

    private Search1Servlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();       //создали обьект JSONObject

        String name = request.getParameter("name"); // с реквеста взяли параметро с именем сауны


        SearchManager.getInstance().find("name");
//        String response = LoginManeger.getInstance().logInUser(userLog, userPass); //проверили наличие чувака
//        System.out.println();
//        System.out.println(response);
//        System.out.println();
//        String result = (response.charAt(0) == 'L') ? "OK" : "NO";

//        jsonObject.put("message", response);
//        jsonObject.put("result", result);

        return jsonObject;
    }
}
