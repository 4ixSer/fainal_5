package com.controller;



import java.util.ArrayList;
import java.util.List;

import com.managers.SearchManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qny4i on 10.11.2016.
 */
public class SearchOptionsServlet extends APIHandlerServlet.APIRequestHandler  {

    public static final SearchOptionsServlet instance = new SearchOptionsServlet();


    public static SearchOptionsServlet getInstance() {
        return instance;
    }

    private SearchOptionsServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        JSONObject jsonObject ;

        String minPrice = request.getParameter("minPrice"); // с реквеста взяли параметро pass
        String maxPrice = request.getParameter("maxPrice");
        String minCapacity = request.getParameter("minCapacity");
        String maxCapacity = request.getParameter("maxCapacity");
        String district = request.getParameter("district");


        List<String> allOptions = new ArrayList<>();
        allOptions.add(minPrice);
        allOptions.add(maxPrice);
        allOptions.add(minCapacity);
        allOptions.add(maxCapacity);
        allOptions.add(district);

        jsonObject= SearchManager.getInstance().findByOption(allOptions);




        System.out.println(jsonObject);




        return jsonObject;
    }
}
