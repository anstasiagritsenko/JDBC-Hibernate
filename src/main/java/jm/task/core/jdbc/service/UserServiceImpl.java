package jm.task.core.jdbc.service; // Объявляем пакет jm.task.core.jdbc.service

import jm.task.core.jdbc.dao.UserDao; // Импортируем интерфейс UserDao из пакета dao
import jm.task.core.jdbc.dao.UserHibernateDaoImpl; // Импортируем класс UserHibernateDaoImpl из пакета dao
import jm.task.core.jdbc.model.User; // Импортируем класс User из пакета model

import java.util.List; // Импортируем класс List из пакета java.util

public class UserServiceImpl implements UserService { // Объявляем класс UserServiceImpl, который реализует интерфейс UserService
    private final UserDao userDaoHibernate = new UserHibernateDaoImpl(); // Создаем и инициализируем объект userDaoHibernate, используя класс UserHibernateDaoImpl

    @Override
    public void createUsersTable() { // Переопределяем метод создания таблицы пользователей
        userDaoHibernate.createUsersTable(); // Вызываем метод создания таблицы пользователей из userDaoHibernate
    }

    @Override
    public void dropUsersTable() { // Переопределяем метод удаления таблицы пользователей
        userDaoHibernate.dropUsersTable(); // Вызываем метод удаления таблицы пользователей из userDaoHibernate
    }

    @Override
    public void saveUser(String name, String lastName, byte age) { // Переопределяем метод сохранения пользователя
        userDaoHibernate.saveUser(name, lastName, age); // Вызываем метод сохранения пользователя из userDaoHibernate
        System.out.println("Пользователь " + name + " " + lastName + " добавлен в базу данных"); // Выводим сообщение об успешном добавлении пользователя
    }

    @Override
    public void removeUserById(long id) { // Переопределяем метод удаления пользователя по идентификатору
        userDaoHibernate.removeUserById(id); // Вызываем метод удаления пользователя по идентификатору из userDaoHibernate
    }

    @Override
    public List<User> getAllUsers() { // Переопределяем метод получения всех пользователей
        return userDaoHibernate.getAllUsers(); // Возвращаем список всех пользователей, полученный из userDaoHibernate
    }

    @Override
    public void cleanUsersTable() { // Переопределяем метод очистки таблицы пользователей
        userDaoHibernate.cleanUsersTable(); // Вызываем метод очистки таблицы пользователей из userDaoHibernate
    }
}
