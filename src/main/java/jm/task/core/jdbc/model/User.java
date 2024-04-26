package jm.task.core.jdbc.model; // Объявляем пакет jm.task.core.jdbc.model

import javax.persistence.Column; // Импортируем аннотацию Column из пакета javax.persistence
import javax.persistence.Id; // Импортируем аннотацию Id из пакета javax.persistence
import javax.persistence.Table; // Импортируем аннотацию Table из пакета javax.persistence

@Table // Объявляем класс как сущность, которая будет сопоставлена с таблицей в базе данных
public class User { // Объявляем класс User

    @Id // Указываем поле id как первичный ключ
    private Long id; // Поле для хранения идентификатора пользователя

    @Column // Указываем, что поле name будет отображаться в столбце таблицы
    private String name; // Поле для хранения имени пользователя

    @Column // Указываем, что поле lastName будет отображаться в столбце таблицы
    private String lastName; // Поле для хранения фамилии пользователя

    @Column // Указываем, что поле age будет отображаться в столбце таблицы
    private Byte age; // Поле для хранения возраста пользователя

    public User() { // Конструктор по умолчанию
    }

    public User(String name, String lastName, Byte age) { // Конструктор с параметрами
        this.name = name; // Инициализация поля name
        this.lastName = lastName; // Инициализация поля lastName
        this.age = age; // Инициализация поля age
    }

    public Long getId() { // Геттер для получения значения поля id
        return id; // Возвращаем значение поля id
    }

    public void setId(Long id) { // Сеттер для установки значения поля id
        this.id = id; // Устанавливаем значение поля id
    }

    public String getName() { // Геттер для получения значения поля name
        return name; // Возвращаем значение поля name
    }

    public void setName(String name) { // Сеттер для установки значения поля name
        this.name = name; // Устанавливаем значение поля name
    }

    public String getLastName() { // Геттер для получения значения поля lastName
        return lastName; // Возвращаем значение поля lastName
    }

    public void setLastName(String lastName) { // Сеттер для установки значения поля lastName
        this.lastName = lastName; // Устанавливаем значение поля lastName
    }

    public Byte getAge() { // Геттер для получения значения поля age
        return age; // Возвращаем значение поля age
    }

    public void setAge(Byte age) { // Сеттер для установки значения поля age
        this.age = age; // Устанавливаем значение поля age
    }

    @Override
    public String toString() { // Переопределяем метод toString() для получения строкового представления объекта
        return "Пользователь: " + // Возвращаем строку с информацией о пользователе
                "id = " + id + // Добавляем идентификатор пользователя
                ", имя = " + name + // Добавляем имя пользователя
                ", фамилия = " + lastName +// Добавляем фамилию пользователя
                ", возраст = " + age;// Добавляем возраст пользователя
    }
}
