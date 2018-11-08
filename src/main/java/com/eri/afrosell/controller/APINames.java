package com.eri.afrosell.controller;
public class APINames {

    public static final String CHARSET = "application/json;charset=utf-8";

    public static final String PRODUCT_BY_ID = "/detail/{product_id}";

    public static final String VERSION = "afrosell/v1/{company_id}";
    public static final String PRODUCTS =VERSION+"/products";
    public static final String PRODUCT_BY_IDS = "/list";
    public static final String PRODUCTS_BY_CATEGORY = "/category";
    public static final String PRODUCTS_FILTER_LIST = "/filter";
    public static final String PRODUCT_CREATE = "/create";
    public static final String PRODUCTS_DELETE = "/delete";
    public static final String PRODUCTS_UPDATE = "/update";
    public static final String PRODUCT_ATTRIBUTES = "/productattributes";
    public static final String PRODUCT_DETAILS = "/productdetails/{product_id}";
    public static final String PRODUCT_ATTRIBUTES_CREATE = "/productattributes/create";

    public static final String ORDERS = VERSION + "/orders";
    public static final String ORDERS_BY_COMPANY = "/{company_id}";
    public static final String ORDER_DETAILS = "/orderDetails/{order_id}";
    public static final String CHANGE_STATUS_ORDERS_BY_COMPANY = "/changeStatus/{order_id}/{status}";
    //company api link
    public static final String COMPANIES_VERSION ="afrosell/v1/";
    public static final String COMPANIES = COMPANIES_VERSION + "/companies";
    public static final String COMPANIES_SEARCH_BY_ID = COMPANIES + "/{id}";
    public static final String COMPANIES_CREATE = COMPANIES + "/create";
    public static final String COMPANIES_DELETE = COMPANIES + "/delete";
    public static final String COMPANIES_UPDATE = COMPANIES + "/update";

    // category api links
    public static final String CATEGORIES = VERSION + "/categories";
    public static final String CATEGORIES_ID = VERSION + "/categories/{id}";

    // Categories APIs
    public static final String CATEGORIES_API = VERSION + "/categories";
    public static final String CATEGORIES_ADD = "/create";
    public static final String CATEGORIES_UPDATE = "/update";
    public static final String CATEGORIES_DELETE = "/delete";
    public static final String CATEGORIES_DETAIL = "/detail/{category_id}";
    public static final String CATEGORIES_LIST = "/list";

    // Upload file API
    public static final String UPLOAD_API = VERSION + "/upload";
    public static final String UPLOAD_FILE = "/file";

    // auth APIs
    public static final String AUTH_API = VERSION + "/auth";
    public static final String SESSION_DATA = "/session/data";
    public static final String USER_LOGOUT = "/logout";
    public static final String ADMIN_LOGIN_API = "/admin/login";

    //user api link
    public static final String USERS = VERSION + "/users";
    public static final String USER_REGISTER = "/register";
    public static final String USER_LIST = "/list";
    public static final String USERS_LOGIN = "/login";
    public static final String USERS_LOGOUT = "/logout";
    public static final String USER_DETAILS = "/detail/{userId}";
    public static final String UPDATE_USER = "/update";
    public static final String DELETE_USER = "/delete";
    public static final String CHANGE_PASSWORD_USER = "/changePassword";

}
