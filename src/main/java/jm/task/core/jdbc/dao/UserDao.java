package jm.task.core.jdbc.dao; // Объявляем пакет jm.task.core.jdbc.dao

import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета model
import java.util.List; // Импортируем интерфейс List из пакета java.util

public interface UserDao { // Объявляем интерфейс UserDao

    void createUsersTable(); // Метод для создания таблицы пользователей

    void dropUsersTable(); // Метод для удаления таблицы пользователей

    void saveUser(String name, String lastName, byte age); // Метод для сохранения пользователя

    void removeUserById(long id); // Метод для удаления пользователя по его идентификатору

    List<User> getAllUsers(); // Метод для получения всех пользователей

    void cleanUsersTable(); // Метод для удаления всех записей из таблицы пользователей
}
