package jm.task.core.jdbc.dao; // Объявление пакета для класса

import jm.task.core.jdbc.model.User; // Импорт класса User из пакета model
import jm.task.core.jdbc.util.Util; // Импорт класса Util из пакета util

import org.hibernate.Session; // Импорт класса Session из пакета org.hibernate
import org.hibernate.Transaction; // Импорт класса Transaction из пакета org.hibernate

import java.util.List; // Импорт интерфейса List для управления списками

public class UserHibernateDaoImpl implements UserDao { // Объявление класса, реализующего интерфейс UserDao
    public UserHibernateDaoImpl() { // Конструктор класса
    }

    @Override
    public void createUsersTable() { // Реализация метода создания таблицы пользователей
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" + // SQL запрос на создание таблицы
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50)," +
                "lastName VARCHAR(50)," +
                "age SMALLINT" +
                ")";
        Session session = Util.getSessionFactory().openSession(); // Получение сессии Hibernate из Util
        Transaction transaction = session.beginTransaction(); // Начало транзакции
        session.createSQLQuery(createTableSQL).executeUpdate(); // Выполнение SQL запроса
        transaction.commit(); // Фиксация транзакции
        session.close(); // Закрытие сессии
    }

    @Override
    public void dropUsersTable() { // Реализация метода удаления таблицы пользователей
        String dropTableSQL = "DROP TABLE IF EXISTS users"; // SQL запрос на удаление таблицы
        Session session = Util.getSessionFactory().openSession(); // Получение сессии Hibernate из Util
        Transaction transaction = session.beginTransaction(); // Начало транзакции
        session.createSQLQuery(dropTableSQL).executeUpdate(); // Выполнение SQL запроса
        transaction.commit(); // Фиксация транзакции
        session.close(); // Закрытие сессии
    }

    @Override
    public void saveUser(String name, String lastName, byte age) { // Реализация метода сохранения пользователя
        Session session = Util.getSessionFactory().openSession(); // Получение сессии Hibernate из Util
        Transaction transaction = session.beginTransaction(); // Начало транзакции
        User user = new User(name, lastName, age); // Создание нового пользователя
        session.save(user); // Сохранение пользователя в базе данных
        transaction.commit(); // Фиксация транзакции
        session.close(); // Закрытие сессии
    }

    @Override
    public void removeUserById(long id) { // Реализация метода удаления пользователя по ID
        Session session = Util.getSessionFactory().openSession(); // Получение сессии Hibernate из Util
        Transaction transaction = session.beginTransaction(); // Начало транзакции
        User user = session.get(User.class, id); // Получение пользователя по ID
        if (user != null) { // Проверка, найден ли пользователь
            session.delete(user); // Удаление пользователя из базы данных
        }
        transaction.commit(); // Фиксация транзакции
        session.close(); // Закрытие сессии
    }

    @Override
    public List<User> getAllUsers() { // Реализация метода получения всех пользователей
        Session session = Util.getSessionFactory().openSession(); // Получение сессии Hibernate из Util
        List<User> users = session.createQuery("FROM User", User.class).list(); // Получение списка пользователей
        session.close(); // Закрытие сессии
        return users; // Возвращение списка пользователей
    }

    @Override
    public void cleanUsersTable() { // Реализация метода очистки таблицы пользователей
        String cleanTableSQL = "TRUNCATE TABLE users"; // SQL запрос на очистку таблицы
        Session session = Util.getSessionFactory().openSession(); // Получение сессии Hibernate из Util
        Transaction transaction = session.beginTransaction(); // Начало транзакции
        session.createSQLQuery(cleanTableSQL).executeUpdate(); // Выполнение SQL запроса
        transaction.commit(); // Фиксация транзакции
        session.close(); // Закрытие сессии
    }
}
