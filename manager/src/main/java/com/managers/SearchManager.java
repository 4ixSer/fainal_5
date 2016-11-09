package com.managers;

import DAO.factory.Factoty;
import com.entity.Sauna;

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

    public String find(String name) {
        List<Sauna> saunaList = Factoty.getInstance().getSaunaDAO().findAllSauna();

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

        return "ok";
    }



}
