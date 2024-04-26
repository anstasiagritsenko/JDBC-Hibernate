package jm.task.core.jdbc.dao; // Объявляем пакет для класса

import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета model
import jm.task.core.jdbc.util.Util; // Импортируем класс Util из пакета util

import java.sql.*; // Импортируем пакет java.sql для работы с JDBC
import java.util.ArrayList; // Импортируем класс ArrayList из пакета java.util для хранения списка пользователей
import java.util.List; // Импортируем класс List из пакета java.util для управления списком пользователей

public class UserDaoJDBCImpl implements UserDao { // Объявляем класс, реализующий интерфейс UserDao
    private final Connection connection; // Объявляем поле connection для подключения к базе данных

    public UserDaoJDBCImpl() { // Конструктор класса
        this.connection = Util.getConnection(); // Инициализируем поле connection, получая соединение из класса Util
    }

    @Override
    public void createUsersTable() { // Реализация метода создания таблицы пользователей
        try (Statement statement = connection.createStatement()) { // Создаем объект Statement для выполнения SQL запросов
            String SQL = "CREATE TABLE IF NOT EXISTS users (" + // SQL запрос на создание таблицы
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(45) NOT NULL," +
                    "lastName VARCHAR(45) NOT NULL," +
                    "age SMALLINT NOT NULL)";
            statement.executeUpdate(SQL); // Выполняем SQL запрос
        } catch (SQLException e) { // Обработка исключений типа SQLException
            e.printStackTrace(); // Выводим трассировку стека исключения
        }
    }

    @Override
    public void dropUsersTable() { // Реализация метода удаления таблицы пользователей
        try (Statement statement = connection.createStatement()) { // Создаем объект Statement для выполнения SQL запросов
            statement.executeUpdate("DROP TABLE IF EXISTS users"); // SQL запрос на удаление таблицы
        } catch (SQLException e) { // Обработка исключений типа SQLException
            e.printStackTrace(); // Выводим трассировку стека исключения
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) { // Реализация метода сохранения пользователя
        try (PreparedStatement preparedStatement = connection.prepareStatement( // Создаем объект PreparedStatement для выполнения SQL запросов
                "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, name); // Устанавливаем значение параметра в SQL запросе
            preparedStatement.setString(2, lastName); // Устанавливаем значение параметра в SQL запросе
            preparedStatement.setByte(3, age); // Устанавливаем значение параметра в SQL запросе
            preparedStatement.executeUpdate(); // Выполняем SQL запрос
        } catch (SQLException e) { // Обработка исключений типа SQLException
            e.printStackTrace(); // Выводим трассировку стека исключения
        }
    }

    @Override
    public void removeUserById(long id) { // Реализация метода удаления пользователя по ID
        try (PreparedStatement preparedStatement = connection.prepareStatement( // Создаем объект PreparedStatement для выполнения SQL запросов
                "DELETE FROM users WHERE id = ?")) {
            preparedStatement.setLong(1, id); // Устанавливаем значение параметра в SQL запросе
            preparedStatement.executeUpdate(); // Выполняем SQL запрос
        } catch (SQLException e) { // Обработка исключений типа SQLException
            e.printStackTrace(); // Выводим трассировку стека исключения
        }
    }

    @Override
    public List<User> getAllUsers() { // Реализация метода получения всех пользователей
        List<User> users = new ArrayList<>(); // Создаем объект ArrayList для хранения пользователей
        try (Statement statement = connection.createStatement(); // Создаем объект Statement для выполнения SQL запросов
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) { // Выполняем SQL запрос и получаем результат
            while (resultSet.next()) { // Перебираем результаты запроса
                User user = new User(); // Создаем нового пользователя
                user.setId(resultSet.getLong("id")); // Устанавливаем значения полей пользователя из результатов запроса
                user.setName(resultSet.getString("name")); // Устанавливаем значения полей пользователя из результатов запроса
                user.setLastName(resultSet.getString("lastName")); // Устанавливаем значения полей пользователя из результатов запроса
                user.setAge(resultSet.getByte("age")); // Устанавливаем значения полей пользователя из результатов запроса
                users.add(user); // Добавляем пользователя в список
            }
        } catch (SQLException e) { // Обработка исключений типа SQLException
            e.printStackTrace(); // Выводим трассировку стека исключения
        }
        return users; // Возвращаем список пользователей
    }

    @Override
    public void cleanUsersTable() { // Реализация метода очистки таблицы пользователей
        try (Statement statement = connection.createStatement()) { // Создаем объект Statement для выполнения SQL запросов
            statement.executeUpdate("TRUNCATE TABLE users"); // SQL запрос на очистку таблицы
        } catch (SQLException e) { // Обработка исключений типа SQLException
            e.printStackTrace(); // Выводим трассировку стека исключения
        }
    }
} // Завершение класса