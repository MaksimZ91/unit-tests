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
