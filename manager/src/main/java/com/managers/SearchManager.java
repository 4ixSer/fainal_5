package com.managers;

import DAO.factory.Factoty;
import com.entity.*;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by qny4i on 08.11.2016.
 */
public class SearchManager {

    private static SearchManager instance = null;

    private SearchManager() {
    }

    public static synchronized SearchManager getInstance() {
        if (instance == null)
            instance = new SearchManager();
        return instance;
    }

    public JSONObject findByName(String name) {
        JSONObject jsonObject = new JSONObject();

        List<Sauna> saunaList = Factoty.getInstance().getSaunaDAO().findByName(name);

        for (int i = 0; i < saunaList.size(); i++) {
            System.out.print("Название - " + saunaList.get(i).getName());
            System.out.print(", цена = " + saunaList.get(i).getPrice());
            System.out.print(", вместимость = " + saunaList.get(i).getCapacity());
            System.out.println(", расположенны на = " + saunaList.get(i).getAddress());
            System.out.println(saunaList.get(i).getDistrict());
            System.out.println(saunaList.get(i).getType());
            System.out.println(saunaList.get(i).getPhones());
            System.out.println();
        }

        jsonObject.put("name",saunaList.get(0).getName() );
        jsonObject.put("price",saunaList.get(0).getPrice() );
        jsonObject.put("capacity",saunaList.get(0).getCapacity() );
        jsonObject.put("url",saunaList.get(0).getUrlPage() );

        return jsonObject;
    }

    public JSONObject findByOption(List<String> newOption) {
        JSONObject jsonObject = new JSONObject();

        List<Sauna> allSauna =  Factoty.getInstance().getSaunaDAO().findByAll(newOption);

        for (int i = 0; i <allSauna.size() ; i++) {

            System.out.print("Название - "+allSauna.get(i).getName());
            System.out.print(", цена = "+ allSauna.get(i).getPrice());
            System.out.print(", вместимость = "+allSauna.get(i).getCapacity());
            System.out.println(", расположенны на = "+ allSauna.get(i).getAddress());
            System.out.println(allSauna.get(i).getDistrict());
            System.out.println(allSauna.get(i).getType());
            System.out.println(allSauna.get(i).getPhones());
            System.out.println();
        }

        jsonObject.put("name",allSauna.get(0).getName() );
        jsonObject.put("price",allSauna.get(0).getPrice() );
        jsonObject.put("capacity",allSauna.get(0).getCapacity() );
        jsonObject.put("url",allSauna.get(0).getUrlPage() );





        return jsonObject;
    }



}
