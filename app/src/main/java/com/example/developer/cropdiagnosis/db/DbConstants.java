package com.example.developer.cropdiagnosis.db;

/**
 * Created by Developer on 16-12-15.
 * He is a intelligent Android developer.
 */

public class DbConstants {

    public static final String DB_NAME = "CropDiagnosis-db";

    public static class DiagnosedStatus {
        public static final int DIAGNOSED = 0x0001;
        public static final int NOT_DIAGNOSED = 0x0002;
    }

    public static class CommentType {
        public static final int VERY_GOOD = 0x0001;
        public static final int GOOD = 0x0002;
        public static final int NORMAL = 0x0003;
        public static final int BAD = 0x0004;
    }

    public static class UserType {
        public static final int PERSON = 0x0001;
        public static final int COMMPANY = 0x0002;
    }
}
