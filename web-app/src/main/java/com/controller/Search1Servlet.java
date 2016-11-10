package com.controller;

import com.managers.SearchManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

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
             //создали обьект JSONObject

        String name = request.getParameter("name"); // с реквеста взяли параметро с именем сауны


        JSONObject jsonObject = SearchManager.getInstance().findByName(name);

        System.out.println(jsonObject);

        return jsonObject;
    }
}
