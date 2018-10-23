package com.eri.afrosell.controller;
public class APINames {

    public static final String CHARSET = "application/json;charset=utf-8";

    public static final String PRODUCT_BY_ID = "/detail/{product_id}";

    public static final String VERSION = "afrosell/v1/{company_id}";
    public static final String PRODUCTS =VERSION+"/products";
    public static final String PRODUCT_BY_IDS = "/list";
    public static final String PRODUCTS_BY_CATEGORY = "/category";
}
