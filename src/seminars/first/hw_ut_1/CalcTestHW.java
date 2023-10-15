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
