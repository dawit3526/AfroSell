package com.eri.util;

public class Constant {

    public static enum USER_STATUS {
        INACTIVE (-1),
        PENDING (0),
        ACTIVE (1);

        private final int status;

        private USER_STATUS (int status) {
            this.status = status;
        }

        public int getStatus () {
            return status;
        }
    }

    public static enum ORDER_STATUS {
        PENDING (0),
        SHIPPING (1),
        COMPLETED (2);

        private final int status;

        private ORDER_STATUS (int status) {
            this.status = status;
        }

        public int getStatus () {
            return status;
        }
    }


}
