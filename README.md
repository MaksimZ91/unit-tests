# Урок 1. Цели и смысл тестирования
Задание 1. В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.  
Ваша задача - проверить этот метод с использованием библиотеки AssertJ. Если метод calculateDiscount получает недопустимые аргументы,  
он должен выбрасывать исключение ArithmeticException. Не забудьте написать тесты для проверки этого поведения.  

## Class CalcTestHW
```java
package seminars.first.hw_ut_1;
import seminars.first.Calculator.Calculator;
import static org.assertj.core.api.Assertions.*;

public class CalcTestHW {
    public static void main(String[] args) {

        //Дефолтное поведение
        assertThat(Calculator.calculatingDiscount(100, 15)).isEqualTo(85);

        //Стоимость == 0
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(0, 15))
                .isInstanceOf(ArithmeticException.class);

        //Стоимость < 0
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-1, 15))
                .isInstanceOf(ArithmeticException.class);

        //Скидка == 0
        assertThat(Calculator.calculatingDiscount(100, 0)).isEqualTo(100);

        //Скидка < 0
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(ArithmeticException.class);

        //Скидка == 100 %
        assertThat(Calculator.calculatingDiscount(100, 100)).isEqualTo(0);

        //Скидка > 100 %
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-1, 15))
                .isInstanceOf(ArithmeticException.class);
    }
}
```

# Урок 2. Знакомство с тестовыми фреймворками
Задание 1.
  Проект Vehicle. Написать следующие тесты с использованием JUnit5:
- Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
- Проверить, что объект Car создается с 4-мя колесами.
- Проверить, что объект Motorcycle создается с 2-мя колесами.
- Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
- Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
- Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).  
- Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).  
  В этом проекте, вы будете работать с проектом ""Vehicle"", который представляет собой иерархию классов, включающую абстрактный базовый класс ""Vehicle"" и два его подкласса ""Car"" и ""Motorcycle"".
  Базовый класс ""Vehicle"" содержит абстрактные методы ""testDrive()"" и ""park()"", а также поля ""company"", ""model"", ""yearRelease"", ""numWheels"" и ""speed"".
  Класс ""Car"" расширяет ""Vehicle"" и реализует его абстрактные методы. При создании объекта ""Car"", число колес устанавливается в 4, а скорость в 0. В методе ""testDrive()"" скорость устанавливается на 60, а в методе ""park()"" - обратно в 0.  
  Класс ""Motorcycle"" также расширяет ""Vehicle"" и реализует его абстрактные методы. При создании объекта ""Motorcycle"", число колес устанавливается в 2, а скорость в 0. В методе ""testDrive()"" скорость устанавливается на 75, а в методе ""park()"" - обратно в 0.
  ## Class VehicleTest
  
 ```java
package seminars.second.hw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle moto;

    @BeforeEach
    void setUp(){
         car = new Car("Dodge", "Ram", 2010);
         moto = new Motorcycle("Honda", "СBR650R", 2020);
    }

    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void testCarWheel(){
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    public void testMotorcycleWheel(){
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    @Test
    public void testCarSpeed(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    public void tesMotorcycleSpeed(){
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    @Test
    public void testCarParking(){
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    public void testMotorcycleParking(){
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}
```

# Урок 3. Качество тестов.

Задание 1.
Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли переданное число четным или нечетным. (код приложен в презентации)
Задание 2.
Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли переданное число в интервал (25;100). (код приложен в презентации)

## Class MainHW 

```java
package seminars.third.hw;

public class MainHW {

    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).

   public boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }

    // HW 3.2. Нужно написать метод, который проверяет,
    // попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%

    public  boolean numberInInterval(int n){
        return  n > 25 && n < 100;
    }
}
```
## Class MainHWTest
```java
package seminars.third.hw;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setUp(){
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints={6,12,8,2,4,0})
    void evenOddPositiveNumberReturnTrue(int input){
        assertTrue(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints={3,5,7,13,9})
    void evenOddPositiveNumberReturnFalse(int input){
        assertFalse(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints={-6,-12,-8,-2,-4})
    void evenOddNegativeNumberReturnTrue(int input){
        assertTrue(mainHW.evenOddNumber(input));

    }
    @ParameterizedTest
    @ValueSource(ints={-3,-5,-7,-13,-9})
    void evenOddNegativeNumberReturnFalse(int input){
        assertFalse(mainHW.evenOddNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints={26,50,85,99})
    void numberInIntervalNumberReturnTrue(int input){
        assertTrue(mainHW.numberInInterval(input));
    }
    @ParameterizedTest
    @ValueSource(ints={-3,25,24,100,101,15})
    void numberInIntervalNumberReturnFalse(int input){
        assertFalse(mainHW.numberInInterval(input));
    }
}
```
Задание 3.  (необязательное)
Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов. Для этого, вам потребуется расширить класс User новым свойством, указывающим, обладает ли пользователь админскими правами. Протестируйте данную функцию.
## Class User
```java
package seminars.third.tdd;

import java.util.Objects;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    boolean isAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        isAuthenticate = Objects.equals(this.name, name) &&  Objects.equals(this.password, password);
        return isAuthenticate;
    }
}
```

## Class UserRepository
```java
package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       if(!user.isAuthenticate) return;
       data.add(user);
    }

    public  void logOut(){
        data.removeIf(user -> !user.isAdmin);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }
}
```
## Class UserTest
```java
package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;
    @BeforeAll
    static void setUp(){
        repository = new UserRepository();
    }

    /*Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
      Для этого, вам потребуется расширить класс User новым свойством, указывающим, обладает ли пользователь админскими правами.
     Протестируйте данную функцию. */

    @Test
    void checkRepositoryAddAdminUserPositive(){
        String name = "name";
        String password = "password";
        String nameAdmin = "nameAdmin";
        String passwordAdmin = "passwordAdmin";

        User user = new User(name, password, false);
        User admin = new User(nameAdmin, passwordAdmin, true);
        user.authenticate(name, password);
        admin.authenticate(nameAdmin, passwordAdmin);
        repository.addUser(user);
        repository.addUser(admin);

        assertTrue(repository.data.get(1).isAdmin);
    }

    @Test
    void checkRepositoryAddNotAdminUserPositive(){
        String name = "name";
        String password = "password";
        String nameAdmin = "nameAdmin";
        String passwordAdmin = "passwordAdmin";

        User user = new User(name, password, false);
        User admin = new User(nameAdmin, passwordAdmin, false);
        user.authenticate(name, password);
        admin.authenticate(nameAdmin, passwordAdmin);
        repository.addUser(user);
        repository.addUser(admin);

        assertFalse(repository.data.get(1).isAdmin);
    }

    @Test
    void checkRepositoryLogOutUser(){
        String name = "name";
        String password = "password";
        String nameAdmin = "nameAdmin";
        String passwordAdmin = "passwordAdmin";

        User user = new User(name, password, false);
        User admin = new User(nameAdmin, passwordAdmin, true);
        user.authenticate(name, password);
        admin.authenticate(nameAdmin, passwordAdmin);
        repository.addUser(user);
        int currentCount = repository.data.size();
        repository.addUser(admin);
        repository.logOut();

        assertThat(repository.data.size())
                .isEqualTo(currentCount);
    }

}
```

