package lotto.service.impl;

import lotto.Won;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 생성기는")
class LottoWonGeneratorTest {

    @ParameterizedTest(name = "{0}원 입력 -> {1}개 로또 생성")
    @MethodSource("provideWon")
    @DisplayName("로또를 생성한다.")
    public void generateTest(final Won won, final int lottoCount){

        // given
        LottosGenerator lottosGenerator = new LottosWonGeneratorImpl();

        // when
        final Lottos lottos = lottosGenerator.generate(won);

        // then
        assertThat(lottos.getCount()).isEqualTo(lottoCount);
    }

    static Stream<Arguments> provideWon(){

        return Stream.of(
            Arguments.of(new Won("1000"), 1),
            Arguments.of(new Won("1001"), 1),
            Arguments.of(new Won("5000"), 5),
            Arguments.of(new Won("10000"), 10)
        );
    }
}
