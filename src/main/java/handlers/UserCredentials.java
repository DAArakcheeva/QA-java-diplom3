package handlers;

public class UserCredentials {

    private final String email;
    private final String password;
    private final String accessToken;

    // Приватный конструктор, используемый внутренними методами
    private UserCredentials(String email, String password, String accessToken) {
        this.email = email;
        this.password = password;
        this.accessToken = accessToken;
    }


    // Публичный метод для создания экземпляров с сохранением существующего токена
    public static UserCredentials fromUser(UserCredentials user, String token) {
        return new UserCredentials(user.getEmail(), user.getPassword(), token);
    }

    // Публичный метод для создания экземпляров без пароля, но с существующим токеном
    public static UserCredentials withoutPassword(String email, String token) {
        return new UserCredentials(email, null, token);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

//    public String getToken() {
//        return token;
//    }

}
