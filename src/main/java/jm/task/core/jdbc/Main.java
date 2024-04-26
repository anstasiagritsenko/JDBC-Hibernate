package jm.task.core.jdbc; // Объявление пакета jm.task.core.jdbc

import jm.task.core.jdbc.dao.UserDao; // Импорт интерфейса UserDao из пакета dao
import jm.task.core.jdbc.dao.UserDaoJDBCImpl; // Импорт класса UserDaoJDBCImpl из пакета dao
import jm.task.core.jdbc.model.User; // Импорт класса User из пакета model
import jm.task.core.jdbc.service.UserService; // Импорт интерфейса UserService из пакета service
import jm.task.core.jdbc.service.UserServiceImpl; // Импорт класса UserServiceImpl из пакета service

import java.util.List; // Импорт класса List из пакета java.util

public class Main { // Объявление класса Main
    public static void main(String[] args) { // Объявление метода main
        UserService userService = new UserServiceImpl(); // Создание объекта userService типа UserServiceImpl

        userService.createUsersTable(); // Вызов метода createUsersTable() у объекта userService

        userService.saveUser("Мария", "Зотова", (byte) 36); // Вызов метода saveUser() у объекта userService с передачей аргументов
        userService.saveUser("Роман", "Дыбенко", (byte) 66); // Вызов метода saveUser() у объекта userService с передачей аргументов
        userService.saveUser("Кузьм", "Прошков", (byte) 7); // Вызов метода saveUser() у объекта userService с передачей аргументов
        userService.saveUser("Юлия", "Цветкова", (byte) 23); // Вызов метода saveUser() у объекта userService с передачей аргументов

        List<User> users = userService.getAllUsers(); // Вызов метода getAllUsers() у объекта userService и сохранение результата в переменную users
        System.out.println("Список пользователей:"); // Вывод сообщения о начале списка пользователей
        for (User user : users) { // Итерация по списку пользователей
            System.out.println(user); // Вывод информации о каждом пользователе
        }

        userService.cleanUsersTable(); // Вызов метода cleanUsersTable() у объекта userService
        System.out.println("Таблица пользователей очищена"); // Вывод сообщения об очистке таблицы пользователей

        userService.dropUsersTable(); // Вызов метода dropUsersTable() у объекта userService
        System.out.println("Таблица пользователей удалена"); // Вывод сообщения об удалении таблицы пользователей
    }
}
