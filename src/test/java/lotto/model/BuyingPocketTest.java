package lotto.model;

import lotto.Money;
import lotto.Won;
import lotto.exception.BuyingPocketException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또를 구매한 주머니는")
class BuyingPocketTest {

    @ParameterizedTest
    @MethodSource("providePocketData")
    @DisplayName("생성된다.")
    public void ofTest(final Money money, final List<String> passiveLottoPapers){

        // when
        BuyingPocket buyingPocket = BuyingPocket.of(money, passiveLottoPapers);

        // then
        assertThat(buyingPocket).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("providePoorPocketData")
    @DisplayName("생성 중에 에러가 발생한다.")
    public void ofExceptionTest(final Money money, final List<String> passiveLottoPapers){

        // when & then
        assertThatThrownBy(() -> BuyingPocket.of(money, passiveLottoPapers))
                .isInstanceOf(BuyingPocketException.class)
                .hasMessageContaining("수동로또의");
    }

    static Stream<Arguments> providePocketData() {
        return Stream.of(
                Arguments.of(Won.from(5000), Arrays.asList("1, 2, 3, 4, 5, 6", "10, 20, 30, 40, 15, 25")),
                Arguments.of(Won.from(10000), Arrays.asList("11, 12, 13, 14, 25, 26", "10, 20, 30, 40, 15, 25"))
        );
    }

    static Stream<Arguments> providePoorPocketData() {
        return Stream.of(
                Arguments.of(Won.from(1000), Arrays.asList("1, 2, 3, 4, 5, 6", "10, 20, 30, 40, 15, 25")),
                Arguments.of(Won.from(10000), null)
        );
    }
}