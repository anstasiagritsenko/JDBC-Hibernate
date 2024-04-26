package jm.task.core.jdbc.dao; // Объявляем пакет jm.task.core.jdbc.dao

import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета jm.task.core.jdbc.model

import java.util.List; // Импортируем класс List из пакета java.util

public interface UserDao { // Объявляем интерфейс UserDao
    void createUsersTable(); // Определяем метод createUsersTable без возвращаемого значения

    void dropUsersTable(); // Определяем метод dropUsersTable без возвращаемого значения

    void saveUser(String name, String lastName, byte age); // Определяем метод saveUser с параметрами name, lastName и age, без возвращаемого значения

    void removeUserById(long id); // Определяем метод removeUserById с параметром id, без возвращаемого значения

    List<User> getAllUsers(); // Определяем метод getAllUsers с возвращаемым значением List<User>

    void cleanUsersTable(); // Определяем метод cleanUsersTable без возвращаемого значения
}
