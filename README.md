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
# Урок 4. Зависимости в тестах
Задание 1. Ответьте письменно на вопросы:  

1.Почему использование тестовых заглушек может быть полезным при написании модульных тестов?  
Использование тестовых заглушек может быть полезным при написании модульных тестов, так как они изолируют нашу систему от внешних связей, таки образом мы можем тестировать только функционал нашей системы, при этом увеличиваться скорость тестирования.

2.Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?  
Для реализации такового рода тестов хорошо подойдут шпионы или моки.

3.Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?  
Для реализации такового рода тестов хорошо подойдут стабы.

4.Какой тип тестовой заглушки вы бы использовали для имитации  взаимодействия с внешним API или базой данных?  
Для это го хорошо подойдут фейки т.к. они заменяют функциональность вызываемого компонента альтернативной реализацией.

Задание 2.
У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.

## Class BookTest
```java
package seminars.fourth.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {
    Book book;
    @BeforeEach
    void setUp(){
        book = new Book("1", "Название", "Автор");
    }

    @Test
    void constructorBookTest(){
        Book book1 = new Book("5");
        assertThat(book1.getId()).isEqualTo("5");
        assertThat(book1.getTitle()).isEqualTo(null);
        assertThat(book1.getAuthor()).isEqualTo(null);
    }

    @Test
    void getIdTest(){
        assertThat(book.getId()).isEqualTo("1");
    }

    @Test
    void getTitleTest(){
        assertThat(book.getTitle()).isEqualTo("Название");
    }

    @Test
    void getAuthor(){
        assertThat(book.getAuthor()).isEqualTo("Автор");
    }

    @Test
    void setIdTest(){
        book.setId("2");
        assertThat(book.getId()).isEqualTo("2");
    }
    @Test
    void setTitleTest(){
        book.setTitle("Название2");
        assertThat(book.getTitle()).isEqualTo("Название2");
    }
    @Test
    void setAuthor(){
        book.setAuthor("Автор2");
        assertThat(book.getAuthor()).isEqualTo("Автор2");
    }

}

```

## Class InMemoryBookRepositoryTest
```java
package seminars.fourth.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


public class InMemoryBookRepositoryTest {
    InMemoryBookRepository in;
    @BeforeEach
    void setUp(){
        in = new InMemoryBookRepository();
    }

    @Test
    void findByIdTest(){
        assertThat(in.findById("1").getAuthor()).isEqualTo("Author1");
    }

    @Test
    void findAllTest(){
        assertThat(in.findAll()).isNotEmpty().hasSize(2);
    }
}

```

## Class BookServiceTest
```java
package seminars.fourth.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    Book book;
    @BeforeEach
    void setUp(){
        book = new Book("1", "Book1", "Author1");
    }
    @Test
    void testBookServiceMethodFindBookById(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookService.findBookById("1")).thenReturn(book);
        Book bk = bookRepository.findById("1");
        verify(bookRepository, times(1)).findById("1");
        assertThat(bk).isEqualTo(book);
    }

    @Test
    void testBookServiceMethodFindAllBooks(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookService.findAllBooks()).thenReturn(Arrays.asList(book,book));
        List <Book> books = bookRepository.findAll();
        verify(bookRepository, times(1)).findAll();
        assertThat(books).isNotEmpty().hasSize(2).isEqualTo(Arrays.asList(book,book));
    }
}
```
# Урок 5. Другие виды тестирования.
*Задание 1. *Представьте, что вы работаете над разработкой простого приложения для записной книжки, которое позволяет пользователям добавлять, редактировать и удалять контакты.
Ваша задача - придумать как можно больше различных тестов (юнит-тесты, интеграционные тесты, сквозные тесты) для этого приложения. Напишите название каждого теста, его тип и краткое описание того, что этот тест проверяет.

## Unit-tests
1.     testCreatingBook(){  
       проверяет положительный сценарий создания объекта Book  
       }  

2.     testCreatingLoger(){  
       проверяет что объект Loger создается  
       }

3.     testCreatingRepository(){  
       проверяет что объект Repository создается  
       }

4.     testCreatingUser(String name, String tel, ...){  
       проверяет что объект User создается с переданными параметрами  
       }  

5.     testAddContact(User user) {  
       проверяет положительный сценарий добавления пользователя в записную книжку  
       }

6.     testFindContactPositive(String name) {  
       проверяет положительный сценарий поиска пользователя в записной книжке  
       }

7.     testFindContactNegative(String name) {  
       проверяет негативный сценарий поиска пользователя в записной книжке
       }

8.     testEditContactPositive(User user, Data data) {  
       проверяет положительный сценарий изменения записи в записной книжке
       }

9.     testEditContactNegative(User user, Data data) {  
       проверяет негативный сценарий изменения записи в записной книжке 
       }

10.     testDeleteContactPositive(User user, Data data) {  
        проверяет позитивный сценарий изменения записи в записной книжке       
        }

11.     testDeleteContactNegative(User user, Data data) {  
        проверяет позитивный сценарий изменения записи в записной книжке
        }

12.     testLoggerWrite(Data data) {
        проверяет позитивный сценарий записи логов 
        }

13.     testWriteRepositoryPositive(Data data){  
        проверяет позитивный сценарий обращения к бд с целью записи
        }

14.     testReadRepositoryPositive(Data data){  
        проверяет позитивный сценарий обращения к бд с целью чтения
        }

15.     testWriteRepositoryNegative(Data data){  
        проверяет негативный сценарий обращения к бд с целью записи
        }

16.     testReadRepositoryNegative(Data data){  
        проверяет негативный сценарий обращения к бд с целью чтения
        }

17.     testParsingDataPositive(Data data){  
        проверяет позитвный сценарий парсинг данных
        }

18.     testParsingDataNegative(Data data){  
        проверяет негативный ценарий парсинг данных
        }

19.     testGetMessageFromFront(){  
        проверяет сценарий получения данных с фронта
        }

20.     testSendingMessageЕщFront(){  
        проверяет сценария получения данных с фронта
        }


## Integration testing

1.     testAddContactToDbPositiv(User user){
        проверяет позитивный сценарий добавления контакта в бд
        }

2.     testAddContactToDbNeagtiv(User user){
        проверяет негативный сценарий добавления контакта в бд
        }

3.     testEditContactToDbPositiv(User user){
        проверяет позитивный сценарий измения контакта  в бд
        }

4.     testEditContactToDbNegativ(User user){
       проверяет негативный сценарий измения контакта в бд
       }

5.     testDeleteContactToDbPositiv(User user){
        проверяет позитивный сценарий удаления контакта из дб
        }

6.     testDeleteContactToDbNegativ(User user){
       проверяет негативный сценарий удаления контакта из дб
       }

7.     testFindeContactToDbPositiv(User user){
        проверяет позитивный сценарий поиска контакта дб
       }

8.     testFindeContactToDbNegativ(User user){
       проверяет негативный сценарий поиска контакта дб
       }

9.     testLogerWriteToFilePositiv(User user){
       проверяет позитивный сценарий записи логов в файл
       }

10.     testFindeContactToDbNegativ(User user){
        проверяет негативный сценарий записи логов в файл      
        }

11.     testMessageToFrontPositiv(Data data){
        проверка позитивного сценария отправки данных на фронт   
        }

12.     testMessageToFrontNegativ(Data data){
        проверка негативного сценария отправки данных на фронт   
        }

13.     testMessageFromFront(){
        проверка позитивного сценария получения данных с фронта  
        }

14.     testMessageFromFront(){
        проверка негативного сценария получения данных с фронта  
        }


## E2E testing

1.      testAddNewContact(){
        Проверка на создание новог пользователя в книжке
        открыть страницу создание контакта-> заполнить форму -> отправить данные->
        предаем данные с фронта -> получаем/парсим данны-> логируем->
        создаем нового пользователя -> логируем ->передаем данныв в бд ->
        логируем-> получаем ответ от бд -> отправляем ответ на фронт.   
        }

2.      testFindeContact(){
        Проверка поиска контакта
        открыть страницу поиска контакта -> заполнить форму поиска контакта-> отправить данные->
        предаем данные с фронта -> получаем/парсим данны-> логируем -> передаем запрос в бд
        логируем-> получаем ответ от бд -> логируем -> отправляем ответ на фронт.
        }

3.      testDeleteContact(){
        Проверка удаления контакта
        открыть страницу удаления контакта -> заполнить форму удаления контакта-> отправить данные->
        предаем данные с фронта -> получаем/парсим данны-> логируем -> передаем запрос на удаление в бд ->
        логируем -> получаем ответ от бд -> логируем -> отправляем ответ на фронт 
        }

4.     testEditContact(){
        Проверка изменения контакта
        открыть страницу изменения контакта -> заполнить форму -> отправить данные->
        предаем данные с фронта -> получаем/парсим данны-> логируем -> передаем запрос на изменение в бд ->
        логируем -> получаем ответ от бд -> логируем -> отправляем ответ на фронт 
        }

*Задание 2. *Ниже список тестовых сценариев. Ваша задача - определить тип каждого теста (юнит-тест, интеграционный тест, сквозной тест) и объяснить, почему вы так решили.
- Проверка того, что функция addContact корректно добавляет новый контакт в список контактов.
- Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов.
- Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление.

1. Проверка того, что функция addContact корректно добавляет новый контакт в список контактов - это Юнит-тест.  
В данном тесте проверяется только одна конкретная функция - addContact. Юнит-тесты предназначены для проверки отдельных компонентов, функций или методов программы независимо от других частей системы.
2. Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов. - это интеграционный тест.  
В данном тесте проверяется взаимодействие нескольких компонентов системы - пользовательского интерфейса и списка контактов.
Интеграционные тесты предназначены для проверки совместной работы разных частей системы, чтобы убедиться, что они корректно взаимодействуют друг с другом.
3. Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление. - это сквозной тест.  
В данном тесте проверяется полный цикл работы с контактом - создание, редактирование и удаление. 
Сквозные тесты предназначены для проверки функциональности системы в целом, включая множество компонентов и взаимодействие между ними. 



 

