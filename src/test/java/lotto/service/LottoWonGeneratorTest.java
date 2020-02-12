package lotto.service;

import lotto.dto.Money;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 생성기는")
class LottoGeneratorTest {

    @ParameterizedTest(name = "{0}원 입력 -> {1}개 로또 생성")
    @MethodSource("provideMoney")
    @DisplayName("로또를 생성한다.")
    public void generateTest(final Money money, final int lottoCount){

        // given

        // when
        final Lottos lottos = LottoGenerator.generate(money);

        // then
        assertThat(lottos.getCount()).isEqualTo(lottoCount);
    }

    static Stream<Arguments> provideMoney(){

        return Stream.of(
            Arguments.of(new Money("1"), 0),
            Arguments.of(new Money("999"), 0),
            Arguments.of(new Money("1000"), 1),
            Arguments.of(new Money("1001"), 1),
            Arguments.of(new Money("5000"), 5),
            Arguments.of(new Money("10000"), 10)
        );
    }
}