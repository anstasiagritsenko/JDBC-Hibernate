package jm.task.core.jdbc.service; // Объявляем пакет jm.task.core.jdbc.service

import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета model

import java.util.List; // Импортируем класс List из пакета java.util

public interface UserService { // Объявляем интерфейс UserService

    // Методы для работы с пользователями

    void createUsersTable(); // Метод для создания таблицы пользователей

    void dropUsersTable(); // Метод для удаления таблицы пользователей

    void saveUser(String name, String lastName, byte age); // Метод для сохранения пользователя

    void removeUserById(long id); // Метод для удаления пользователя по его идентификатору

    List<User> getAllUsers(); // Метод для получения списка всех пользователей

    void cleanUsersTable(); // Метод для очистки таблицы пользователей
}
