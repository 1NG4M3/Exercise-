package helpers;

import io.restassured.response.Response;

public class ApiHelper extends RequestHelper {
    public static Response response;
    public static ConfigProp prop = new ConfigProp();
    public static class TestData {
        public static final String ERROR_MESSAGE_400_PHONE = "Mobile phone must have 11 digits without +.";
        public static final String ERROR_MESSAGE_400_PASSWORD = "Password must be from 6 to 20 characters, " +
                "contain any of the follow characters (!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~)," +
                "have at least one capital letter and at least one digit";
        public static final String ERROR_MESSAGE_400_EMPTY_PASSWORD = "'Password' must not be empty.";
        public static final String ERROR_MESSAGE_400_EMPTY_PHONE = "'Mobile Phone' must not be empty.";
        public static final String ERROR_MESSAGE_400_EMPTY_EMAIL = "'Email' must not be empty.";
        public static final String ERROR_MESSAGE_400_EMPTY_SQ = "'Security Question' must not be empty.";
        public static final String ERROR_MESSAGE_400_EMPTY_PASSPORT = "'Passport Number' must not be empty.";
        public static final String ERROR_MESSAGE_400_LONG_PHONE = "The JSON value could not be converted to System.String. " +
                "Path: $.mobilePhone | LineNumber: 0 | BytePositionInLine: 26.";


    }
}