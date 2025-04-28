package handlers;

public class User {

    // Приватные поля для хранения личной информации пользователя
    private String email;
    private String password;
    private String name;

    // Конструктор с тремя параметрами для инициализации полного профиля пользователя
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // Альтернативный конструктор с двумя параметрами, если имя пользователя не обязательно
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Пустой конструктор для случаев, когда экземпляр создаётся без начальных значений
    public User() {}

    // Геттер для электронного адреса пользователя
    public String getEmail() {
        return email;
    }

    // Геттер для пароля пользователя
    public String getPassword() {
        return password;
    }

    // Геттер для имени пользователя
    public String getName() {
        return name;
    }

    // Сеттер для установки значения электронной почты
    public void setEmail(String email) {
        this.email = email;
    }

    // Сеттер для установки значения пароля
    public void setPassword(String password) {
        this.password = password;
    }

    // Сеттер для установки значения имени пользователя
    public void setName(String name) {
        this.name = name;
    }

}