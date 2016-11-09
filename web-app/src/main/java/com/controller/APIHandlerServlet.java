package com.controller;

import com.utils.JSON;
import com.utils.JSONResponses;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.utils.JSONResponses.ERROR_INCORRECT_REQUEST;


/**
 * Created by cube on 20.08.2016.
 */
public class APIHandlerServlet extends HttpServlet{


    public abstract static class APIRequestHandler {

        protected abstract JSONStreamAware processRequest(HttpServletRequest request) throws Exception;

    }

    private static Map<String, APIRequestHandler> apiRequestHandlers = new HashMap<>();

    static {
        Map<String, APIRequestHandler> map = new HashMap<>();

        map.put("login", LoginServlet.getInstance());
        map.put("registration", RegistrationServlet.getInstance());
        map.put("searchName", Search1Servlet.getInstance());
        map.put("searchOptions", RegistrationServlet.getInstance());
        apiRequestHandlers = Collections.unmodifiableMap(map);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public static Map<String, APIRequestHandler> getApiRequestHandlers() {
        return apiRequestHandlers;
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setDateHeader("Expires", 0);

        JSONStreamAware response = JSON.emptyJSON;

        try {

            long startTime = System.currentTimeMillis();        //запись времени

            String requestType = req.getParameter("requestType");       //считываем данные
            if (requestType == null) {          //если нечего не пришло то все плохо кидаем  ERROR_INCORRECT_REQUEST
                response = ERROR_INCORRECT_REQUEST;
                return;
            }

            APIRequestHandler apiRequestHandler = apiRequestHandlers.get(requestType);  //считывает тип запроса для выбора нужного сервлета
            if (apiRequestHandler == null) {
                response = ERROR_INCORRECT_REQUEST;         //если такой тив не зарегестрирован в apiRequestHandlers то ошибка
                return;
            }
            response = apiRequestHandler.processRequest(req);       //вызыввет  нужный сервелет из списка
            if (response instanceof JSONObject) {               //запихует время наверное для разработки
                ((JSONObject) response).put("requestProcessingTime", System.currentTimeMillis() - startTime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resp.setContentType("text/plain; charset=UTF-8");
            try (Writer writer = resp.getWriter()) {        //создается поток и во resp записуется вся информация
                response.writeJSONString(writer);
            }
        }

    }

}
