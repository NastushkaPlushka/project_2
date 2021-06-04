package junit_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
//import java.util.Map;

public class User {

    private int id;
    private String name;
    private int age;
    private Sex sex;

    // Храним всех пользователей
    private static HashMap<Integer, User> allUsers;
    // Счетчик пользователей
    private static int countId = 0;

    // Конструктор
    public User(String name, int age, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.age = age;

        if (allUsers == null){
            allUsers = new HashMap<Integer, User>();
        }

        if (!hasUser()){
            this.id = ++countId;
            allUsers.put(id, this);
        }
    }

    // Для удобства поиска одинаковых объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                name.equals(user.name) &&
                sex == user.sex;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age, sex);
    }

    private boolean hasUser(){
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    // Вернуть список пользователей
    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    // Вернуть список пользователей по полу
    public static List<User> getAllUsers(Sex sex){
        List<User> listAllUsers = new ArrayList<>();
        for (User user: allUsers.values()){
            if (user.sex == sex){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    // Вернуть количество пользователей
    public static int getCount() {
        return allUsers.size();
    }

    // Вернуть количество пользователейпо полу
    public static int getCount(Sex sex) {
        return getAllUsers(sex).size();
    }

    public static int getSumAgeUsers() {
        int counter = 0;
        for (User user: allUsers.values()) {
            counter += user.age;
        }
        return counter;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
