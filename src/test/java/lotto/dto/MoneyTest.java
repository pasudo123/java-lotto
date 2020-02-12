package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("돈은")
class MoneyTest {


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("널 또는 공백이 될 수 없습니다.")
    void moneyConstructorNullOrEmptyCheckTest(final String money){

        Exception e = assertThrows(IllegalArgumentException.class, () -> new Money(money));

        assertTrue(e.getMessage().contains("로또 구입 금액은 널 또는 공백이 될 수 없습니다."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    @DisplayName("음수가 들어올 수 없습니다.")
    void moneyConstructorNegativeCheckTest(final String money) {

        Exception e = assertThrows(IllegalArgumentException.class, () -> new Money(money));

        assertTrue(e.getMessage().contains("로또 구입 금액은 음수가 될 수 없습니다."));
    }


    @CsvSource({
            "0, 0",
            "1, 1",
            "100, 100",
            "5000, 5000",
    })
    @ParameterizedTest(name = "{0}원으로 {1}원 생성")
    @DisplayName("생성이 완료되었습니다.")
    void getMoneyTest(final String line, final Integer expectedMoney) {

        final Money money = new Money(line);

        assertThat(money.get()).isEqualTo(expectedMoney);
    }
}