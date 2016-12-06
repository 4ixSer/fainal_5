package com.controller;

import com.managers.SearchManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qny4i on 10.11.2016.
 */
public class SearchServlet extends APIHandlerServlet.APIRequestHandler {

    public static final SearchServlet instance = new SearchServlet();


    public static SearchServlet getInstance() {
        return instance;
    }

    private SearchServlet() {
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
