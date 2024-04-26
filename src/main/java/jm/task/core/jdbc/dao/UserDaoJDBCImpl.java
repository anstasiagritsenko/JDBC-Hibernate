package jm.task.core.jdbc.dao; // Объявляем пакет jm.task.core.jdbc.dao

import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета jm.task.core.jdbc.model
import jm.task.core.jdbc.util.Util; // Импортируем класс Util из пакета jm.task.core.jdbc.util

import java.sql.*; // Импортируем классы из пакета java.sql
import java.util.ArrayList; // Импортируем класс ArrayList из пакета java.util
import java.util.List; // Импортируем класс List из пакета java.util

public class UserDaoJDBCImpl implements UserDao { // Объявляем класс UserDaoJDBCImpl, который реализует интерфейс UserDao
    private Connection connection; // Объявляем приватное поле connection типа Connection

    public UserDaoJDBCImpl() { // Объявляем конструктор класса
        this.connection = Util.getConnection(); // Инициализируем поле connection, используя метод getConnection() из класса Util
    }

    @Override
    public void createUsersTable() { // Переопределяем метод createUsersTable из интерфейса UserDao
        try (Statement statement = connection.createStatement()) { // Используем try-with-resources для автоматического закрытия statement после использования
            String SQL = "CREATE TABLE IF NOT EXISTS users (" + // Определяем строку SQL для создания таблицы users
                    "id SERIAL PRIMARY KEY," +
                    "name VARCHAR(45) NOT NULL," +
                    "lastName VARCHAR(45) NOT NULL," +
                    "age SMALLINT NOT NULL)";
            statement.executeUpdate(SQL); // Выполняем SQL-запрос для создания таблицы
        } catch (SQLException e) { // Обрабатываем возможные исключения SQLException
            e.printStackTrace(); // Выводим информацию об ошибке
        }
    }

    @Override
    public void dropUsersTable() { // Переопределяем метод dropUsersTable из интерфейса UserDao
        try (Statement statement = connection.createStatement()) { // Используем try-with-resources для автоматического закрытия statement после использования
            statement.executeUpdate("DROP TABLE IF EXISTS users"); // Выполняем SQL-запрос для удаления таблицы, если она существует
        } catch (SQLException e) { // Обрабатываем возможные исключения SQLException
            e.printStackTrace(); // Выводим информацию об ошибке
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) { // Переопределяем метод saveUser из интерфейса UserDao
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)")) { // Подготавливаем SQL-запрос с параметрами
            preparedStatement.setString(1, name); // Устанавливаем параметры запроса
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос для добавления пользователя
        } catch (SQLException e) { // Обрабатываем возможные исключения SQLException
            e.printStackTrace(); // Выводим информацию об ошибке
        }
    }

    @Override
    public void removeUserById(long id) { // Переопределяем метод removeUserById из интерфейса UserDao
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM users WHERE id = ?")) { // Подготавливаем SQL-запрос с параметрами
            preparedStatement.setLong(1, id); // Устанавливаем параметры запроса
            preparedStatement.executeUpdate(); // Выполняем SQL-запрос для удаления пользователя по ID
        } catch (SQLException e) { // Обрабатываем возможные исключения SQLException
            e.printStackTrace(); // Выводим информацию об ошибке
        }
    }

    @Override
    public List<User> getAllUsers() { // Переопределяем метод getAllUsers из интерфейса UserDao
        List<User> users = new ArrayList<>(); // Создаем новый список пользователей
        try (Statement statement = connection.createStatement(); // Используем try-with-resources для автоматического закрытия statement после использования
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) { // Выполняем SQL-запрос для получения всех пользователей
            while (resultSet.next()) { // Перебираем результаты запроса
                User user = new User(); // Создаем новый объект пользователя
                user.setId(resultSet.getLong("id")); // Устанавливаем значения свойств пользователя из результатов запроса
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user); // Добавляем пользователя в список
            }
        } catch (SQLException e) { // Обрабатываем возможные исключения SQLException
            e.printStackTrace(); // Выводим информацию об ошибке
        }
        return users; // Возвращаем список пользователей
    }

    @Override
    public void cleanUsersTable() { // Переопределяем метод cleanUsersTable из интерфейса UserDao
        try (Statement statement = connection.createStatement()) { // Используем try-with-resources для автоматического закрытия statement после использования
            statement.executeUpdate("TRUNCATE TABLE users"); // Выполняем SQL-запрос для очистки таблицы пользователей
        } catch (SQLException e) { // Обрабатываем возможные исключения SQLException
            e.printStackTrace(); // Выводим информацию об ошибке
        }
    }
}
