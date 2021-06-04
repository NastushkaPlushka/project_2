package junit_test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getAllUsersFemale() {
        User user1 = new User("Ленка", 38, Sex.FEMALE);
        User user2 = new User("Алексей", 23, Sex.MALE);
        User user3 = new User("Маша", 19, Sex.FEMALE);

        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user3);
        // вызовет ошибку
        // actual.add(user2);

        List<User> expected = User.getAllUsers(Sex.FEMALE);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAllUsersMale() {
        User user1 = new User("Валерий", 38, Sex.MALE);
        User user2 = new User("Алексей", 23, Sex.MALE);
        User user3 = new User("Маша", 19, Sex.FEMALE);

        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        // вызовет ошибку
        // actual.add(user3);

        List<User> expected = User.getAllUsers(Sex.MALE);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAllUsers() {
        User user1 = new User("Наська", 18, Sex.FEMALE);
        User user2 = new User("Коля", 23, Sex.MALE);
        User user3 = new User("владимир", 21, Sex.MALE);

        // актуальное значение
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        actual.add(user3);

        // ожидаемое значение
        List<User> expected = User.getAllUsers();

        // проверка на их совпадение
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCount() {

        User user1 = new User("Андрей", 20, Sex.MALE);
        User user2 = new User("Иван", 27, Sex.MALE);
        User user3 = new User("Александра", 14, Sex.FEMALE);

        int actual = 3;
        int expected = User.getCount();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getCountMale() {

        User user1 = new User("Сергей", 45, Sex.MALE);
        User user2 = new User("Иван", 32, Sex.MALE);
        User user3 = new User("Александра", 16, Sex.FEMALE);

        int actual = 2;

        // для провала теста
        // int actual = 3;

        int expected = User.getCount(Sex.MALE);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getCountFemale() {

        User user1 = new User("Сергей", 45, Sex.MALE);
        User user2 = new User("Иван", 32, Sex.MALE);
        User user3 = new User("Александра", 16, Sex.FEMALE);

        int actual = 1;

        // для провала теста
        // int actual = 3;

        int expected = User.getCount(Sex.FEMALE);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEquals(){
        User user1 = new User("Сергей", 45, Sex.MALE);

        boolean actual = true;
        boolean expected = user1.equals(user1);

        Assert.assertEquals(expected, actual);
    }
}