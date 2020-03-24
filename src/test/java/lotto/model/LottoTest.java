package lotto.model;

import lotto.exception.LottoCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또는")
class LottoTest {

    @Test
    @DisplayName("로또번호를 자동으로 생성하고 여섯자리 번호를 반환한다.")
    void createTest() {
        // when
        Lotto lotto = Lotto.create();

        // then
        assertThat(lotto.getNumbers().size()).isNotZero();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource({
        "'1, 2, 3, 4, 5, 6', '[1, 2, 3, 4, 5, 6]'",
        "'1, 10, 15, 20, 25, 30', '[1, 10, 15, 20, 25, 30]'",
    })
    @DisplayName("로또번호를 수동으로 생성한다.")
    void fromTest(final String line, final String expectedLine){
        // when
        Lotto lotto = Lotto.from(line);

        // then
        assertThat(Arrays.toString(
                lotto.getNumbers().toArray()
        )).isEqualTo(expectedLine);
    }

    @ParameterizedTest
    @CsvSource({
        "'1, 1, 2, 3, 4, 5'",
    })
    @DisplayName("수동입력한 로또번호가 중복되면 에러가 발생한다.")
    void fromExceptionTestOnOverlap(final String line) {
        // when & then
        assertThatThrownBy(() -> Lotto.from(line))
                .isInstanceOf(LottoCreateException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "'1, 2, 3, 4, 5'",
    })
    @DisplayName("수동입력한 로또번호의 개수가 부족하면 에러가 발생한다.")
    void fromExceptionTestOnSize(final String line) {
        // when & then
        assertThatThrownBy(() -> Lotto.from(line))
                .isInstanceOf(LottoCreateException.class);
    }
}
