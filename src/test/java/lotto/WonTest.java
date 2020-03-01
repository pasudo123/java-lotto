package lotto;

import lotto.exception.WonConstructorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("돈은")
class WonTest {


    @ParameterizedTest
    @NullSource
    @DisplayName("널이 될 수 없습니다.")
    void moneyConstructorNullOrEmptyCheckTest(final Integer money){
        assertThrows(WonConstructorException.class, () -> Won.from(money));
    }

    @ParameterizedTest(name = "{0}원 금액 입력")
    @ValueSource(strings = {"0", "-1", "-2", "-3"})
    @DisplayName("음수가 들어올 수 없습니다.")
    void moneyConstructorNegativeCheckTest(final Integer money) {
        assertThrows(WonConstructorException.class, () -> Won.from(money));
    }

    @ParameterizedTest(name = "{0}원 금액 입력")
    @ValueSource(strings = {"1001", "1010", "1100", "11100"})
    @DisplayName("1000 원 단위로만 들어올 수 있습니다.")
    void moneyConstructorDivingCheckTest(final Integer money) {
        assertThrows(WonConstructorException.class, () -> Won.from(money));
    }

    @CsvSource({
            "1000, 1000",
            "5000, 5000",
    })
    @ParameterizedTest(name = "{0}원으로 {1}원 생성")
    @DisplayName("생성이 완료되었습니다.")
    void getWonTest(final Integer money, final Integer expectedWon) {

        final Won won = Won.from(money);

        assertThat(won.get()).isEqualTo(expectedWon);
    }
}
