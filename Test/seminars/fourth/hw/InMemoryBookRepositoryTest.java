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
