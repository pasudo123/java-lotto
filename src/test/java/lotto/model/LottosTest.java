package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또는")
class LottosTest {

    @ParameterizedTest(name = "{0}개 생성되었습니다.")
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("생성되었습니다.")
    void createTest(final int count) {
        assertNotNull(Lottos.create(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("생성에 실패하였습니다.")
    void createExceptionTest(final int count) {

        Exception e = assertThrows(IllegalArgumentException.class, () -> Lottos.create(count));

        assertTrue(e.getMessage().contains("로또를 생성할 수 없습니다."));
    }

    @ParameterizedTest(name = "{0}개 생성 -> {1}개 반환")
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
    })
    @DisplayName("현재 내가 구입한 로또의 개수를 반환한다.")
    void getCountTest(final int count, final int expected) {

        // given & when
        final Lottos lottos = Lottos.create(count);

        // then
        assertThat(lottos.getCount()).isEqualTo(expected);
    }
}
