package DAO.factory;

import DAO.*;

/**
 * Created by qny4i on 02.11.2016.
 */
public class Factoty {



    private static UserService userService = null;
    private static BillService billService = null;
    private static DistrictService districtService = null;
    private static TypeService typeService = null;
    private static PhoneService phoneService = null;
    private static SaunaService saunaService = null;
    private static ActiveSessionService activeSessionService = null;

    private static Factoty instance = null;

    public static synchronized Factoty getInstance() {
        if (instance == null) {
            instance = new Factoty();
        }
        return instance;
    }



    public UserService getUserDAO() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public BillService getBillDAO() {
        if (billService == null) {
            billService = new BillService();
        }
        return billService;
    }

    public DistrictService getDistrictDAO() {
        if (districtService == null) {
            districtService = new DistrictService();
        }
        return districtService;
    }
    public PhoneService getPhoneDAO() {
        if (phoneService == null) {
            phoneService = new PhoneService();
        }
        return phoneService;
    }
    public TypeService getTypeDAO() {
        if (typeService == null) {
            typeService = new TypeService();
        }
        return typeService;
    }

    public SaunaService getSaunaDAO() {
        if (saunaService == null) {
            saunaService = new SaunaService();
        }
        return saunaService;
    }

    public ActiveSessionService getActiveSessionDAO() {
        if (activeSessionService == null) {
            activeSessionService = new ActiveSessionService();
        }
        return activeSessionService;
    }
}
