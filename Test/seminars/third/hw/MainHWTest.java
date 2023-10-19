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



