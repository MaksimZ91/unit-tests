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
