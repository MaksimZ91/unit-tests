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
