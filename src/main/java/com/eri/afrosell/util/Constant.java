package com.eri.afrosell.util;
public class Constant {
    public static final String DEFAULT_PAGE_NUMBER = "20";
    public static final String DEFAULT_PAGE_SIZE ="1";
    public static enum STATUS {
        ACTIVE_STATUS(0, "Active"),
        DELETED_STATUS(1, "Deleted"),
        REVOKE_STATUS(2, "Revoke"),
        DISABLED_STATUS(3, "Disable"),
        DELETED_FOREVER_STATUS(4, "Deleted forever"),
        PENDING(5, "Pending"),
        TRIAL_ACCOUNT_STATUS(6, "Trial");

        private final int value;
        private final String type;

        private STATUS(int value, String type) {
            this.value = value;
            this.type = type;
        }

        public int getValue() {
            return value;
        }

        public String getType() {
            return type;
        }
    }


    // define sort key value
    public static final int SORT_BY_PRODUCT_NAME = 1;
    public static final int SORT_BY_PRODUCT_PRICE= 2;
    public static final int SORT_BY_PRODUCT_QUANTITY = 3;
    public static final int SORT_BY_PRODUCT_CREATE_DATE = 4;
    public static final int SORT_BY_FIRST_NAME = 1;
    public static final int SORT_BY_LAST_NAME = 2;
    public static final int SORT_BY_EMAIL_ADDRESS = 3;
    public static final int SORT_BY_CREATE_DATE = 4;

    // define sort key value
    public static final int SORT_BY_ITEMS_QUANTITY = 4;
    public static final int SORT_BY_GRAND_TOTAL = 2;

    public enum ParamError {

        MISSING_USERNAME_AND_EMAIL("accountName", "Missing both user name and email address"),
        USER_NAME("userName", "Invalid user name"),
        EMAIL_ADDRESS("email", "Invalid email address"),
        PASSWORD("passwordHash", "Invalid password hash"),
        PHONE_NUMBER("phone", "Invalid phone number"),
        FIRST_NAME("firstName", "Invalid first name"),
        LAST_NAME("lastName", "Invalid last name"),
        APP_NAME("appName", "Invalid app name"),
        APP_DOMAIN("appDomain", "Invalid app domain"),
        SERVER_KEY("serverKey", "Invalid server key"),
        TOKEN_EXPIRE_DURATION("tokenExpireDuration", "Invalid token expiry duration"),
        REDIRECT_URL("redirectUrl", "Invalid redirect URL"),
        ROLE_NAME("roleName", "Invalid role name"),
        PRODUCT_ID_NOT_CORRECT("Product atrribute details","Invalid product Id"),
        ROLE_DESC("roleDescription", "Invalid role description");


        private final String name;
        private final String desc;

        private ParamError(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }
    }
}
