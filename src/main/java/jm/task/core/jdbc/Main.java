package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр UserService
        UserService userService = new UserServiceImpl();

        // Создаем таблицу пользователей
        userService.createUsersTable();

        // Сохраняем несколько пользователей
        userService.saveUser("Полина", "Тучкова", (byte) 20);
        userService.saveUser("Екатерина", "Громова", (byte) 35);
        userService.saveUser("Анастасия", "Гроза", (byte) 10);
        userService.saveUser("Илья", "Молния", (byte) 37);

        // Получаем список всех пользователей и выводим их
        List<User> users = userService.getAllUsers();
        System.out.println("Список пользователей:");
        for (User user : users) {
            System.out.println(user);
        }

        // Очищаем таблицу пользователей
        userService.cleanUsersTable();
        System.out.println("Таблица пользователей очищена");

        // Удаляем таблицу пользователей
        userService.dropUsersTable();
        System.out.println("Таблица пользователей удалена");
    }
}
