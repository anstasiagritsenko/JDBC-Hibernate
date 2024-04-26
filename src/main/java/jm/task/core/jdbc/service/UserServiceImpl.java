package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl; // Импортируем класс UserDaoJDBCImpl из пакета dao
import jm.task.core.jdbc.dao.UserDao; // Импортируем интерфейс UserDao из пакета dao
import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета model

import java.util.List; // Импортируем класс List из пакета java.util

public class UserServiceImpl implements UserService { // Объявляем класс UserServiceImpl, который реализует интерфейс UserService
    private final UserDao userDaoJDBC = new UserDaoJDBCImpl(); // Создаем экземпляр класса UserDaoJDBCImpl и присваиваем его полю userDaoJDBC

    public void createUsersTable() { // Определяем метод createUsersTable() без возвращаемого значения
        userDaoJDBC.createUsersTable(); // Вызываем метод createUsersTable() у объекта userDaoJDBC
    }

    public void dropUsersTable() { // Определяем метод dropUsersTable() без возвращаемого значения
        userDaoJDBC.dropUsersTable(); // Вызываем метод dropUsersTable() у объекта userDaoJDBC
    }

    public void saveUser(String name, String lastName, byte age) { // Определяем метод saveUser() с параметрами name, lastName и age
        userDaoJDBC.saveUser(name, lastName, age); // Вызываем метод saveUser() у объекта userDaoJDBC с передачей параметров name, lastName и age
        System.out.println("Пользователь" + name + " " + lastName + " добавлен в базу данных"); // Выводим сообщение об успешном добавлении пользователя
    }

    public void removeUserById(long id) { // Определяем метод removeUserById() с параметром id
        userDaoJDBC.removeUserById(id); // Вызываем метод removeUserById() у объекта userDaoJDBC с передачей параметра id
    }

    public List<User> getAllUsers() { // Определяем метод getAllUsers() с возвращаемым значением List<User>
        return userDaoJDBC.getAllUsers(); // Возвращаем результат вызова метода getAllUsers() у объекта userDaoJDBC
    }

    public void cleanUsersTable() { // Определяем метод cleanUsersTable() без возвращаемого значения
        userDaoJDBC.cleanUsersTable(); // Вызываем метод cleanUsersTable() у объекта userDaoJDBC
    }
}
