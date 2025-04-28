package handlers;

public class StellarBurgersEndpoints {

    // Основной адрес сайта
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    // Страницы приложения
    public static final String MAIN_PAGE = BASE_URL;
    public static final String REGISTER_PAGE = BASE_URL + "register";
    public static final String LOGIN_PAGE = BASE_URL + "login";
    public static final String FORGOT_PASSWORD_PAGE = BASE_URL + "forgot-password";

    // Адреса API
    public static final String API_BASE_PATH = BASE_URL + "api/auth/";
    public static final String AUTH_LOGIN_ENDPOINT = API_BASE_PATH + "login";
    public static final String CREATE_USER_ENDPOINT = API_BASE_PATH + "register";
    public static final String DELETE_USER_ENDPOINT = API_BASE_PATH + "user";
}
