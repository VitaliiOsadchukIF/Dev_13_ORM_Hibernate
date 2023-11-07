package org.example.database.utils;

// Цей клас містить налаштування для з'єднання з базою даних MySQL.

public class Config {

//     JDBC URL для підключення до бази даних.

    public static final String JDBC_URL = "jdbc:h2:~/test";   // jdbc:h2:./mydb

//    Ім'я користувача для підключення до бази даних.

    public static final String USERNAME = "name";

    // Пароль для підключення до бази даних.

    public static final String PASSWORD = "password";

    // Приватний конструктор. Використовується для запобігання створенню екземплярів цього утилітного класу.

    private Config() {
    }
}
