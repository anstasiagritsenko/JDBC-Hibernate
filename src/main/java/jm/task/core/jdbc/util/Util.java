package jm.task.core.jdbc.util; // Объявляем пакет jm.task.core.jdbc.util

import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета model
import org.hibernate.SessionFactory; // Импортируем класс SessionFactory из пакета org.hibernate
import org.hibernate.boot.MetadataSources; // Импортируем класс MetadataSources из пакета org.hibernate.boot
import org.hibernate.boot.registry.StandardServiceRegistry; // Импортируем класс StandardServiceRegistry из пакета org.hibernate.boot.registry
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; // Импортируем класс StandardServiceRegistryBuilder из пакета org.hibernate.boot.registry

import java.sql.Connection; // Импортируем класс Connection из пакета java.sql
import java.sql.DriverManager; // Импортируем класс DriverManager из пакета java.sql
import java.sql.SQLException; // Импортируем класс SQLException из пакета java.sql

public class Util { // Объявляем класс Util
    private static final SessionFactory sessionFactory = buildSessionFactory(); // Создаем и инициализируем переменную sessionFactory, вызывая метод buildSessionFactory()
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres"; // Инициализируем константу JDBC_URL с URL для подключения к базе данных PostgreSQL
    private static final String JDBC_USERNAME = "postgres"; // Инициализируем константу JDBC_USERNAME с именем пользователя для подключения к базе данных
    private static final String JDBC_PASSWORD = "999"; // Инициализируем константу JDBC_PASSWORD с паролем для подключения к базе данных

    private static Connection connection; // Объявляем статическое поле connection для хранения подключения к базе данных

    static { // Блок статической инициализации
        try { // Обработка исключений
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD); // Устанавливаем соединение с базой данных
        } catch (SQLException e) { // Обработка исключений типа SQLException
            e.printStackTrace(); // Выводим трассировку стека исключения
        }
    }

    private static SessionFactory buildSessionFactory() { // Метод для создания фабрики сеансов Hibernate
        try { // Обработка исключений
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder() // Создаем реестр служб Hibernate
                    .applySetting("hibernate.connection.driver_class", "org.postgresql.Driver") // Устанавливаем класс драйвера PostgreSQL
                    .applySetting("hibernate.connection.url", JDBC_URL) // Устанавливаем URL для подключения к базе данных
                    .applySetting("hibernate.connection.username", JDBC_USERNAME) // Устанавливаем имя пользователя для подключения к базе данных
                    .applySetting("hibernate.connection.password", JDBC_PASSWORD) // Устанавливаем пароль для подключения к базе данных
                    .applySetting("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect") // Устанавливаем диалект PostgreSQL
                    .build(); // Строим реестр служб

            return new MetadataSources(registry) // Создаем источники метаданных из реестра
                    .addAnnotatedClass(jm.task.core.jdbc.model.User.class) // Добавляем аннотированный класс User
                    .buildMetadata() // Строим метаданные
                    .buildSessionFactory(); // Строим фабрику сеансов
        } catch (Throwable ex) { // Обработка всех исключений
            System.err.println("Initial SessionFactory creation failed." + ex); // Вывод сообщения об ошибке при создании фабрики сеансов
            throw new ExceptionInInitializerError(ex); // Генерация исключения при ошибке создания фабрики сеансов
        }
    }

    public static SessionFactory getSessionFactory() { // Метод для получения фабрики сеансов Hibernate
        return sessionFactory; // Возвращаем фабрику сеансов
    }

    public static Connection getConnection() { // Метод для получения соединения с базой данных
        return connection; // Возвращаем соединение с базой данных
    }
}
