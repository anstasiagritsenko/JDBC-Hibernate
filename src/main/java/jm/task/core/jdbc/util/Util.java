package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // Задаем константы для URL, имени пользователя и пароля для подключения к базе данных PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "999";

    // Статический метод для установления соединения с базой данных
    public static Connection getConnection() {
        try {
            // Получаем соединение с базой данных, используя DriverManager и передавая URL, имя пользователя и пароль
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // В случае возникновения SQLException, выводим трассировку стека и выбрасываем RuntimeException с сообщением
            e.printStackTrace();
            throw new RuntimeException("Не удалось подключиться к базе данных");
        }
    }
}
