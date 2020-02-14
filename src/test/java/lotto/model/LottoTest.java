package lotto.model;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또는")
class LottoTest {

    private Lotto lotto = null;

    @BeforeEach
    void initLotto(){
        this.lotto = Lotto.create();
    }

    @Test
    @DisplayName("로또번호를 생성한다")
    void createTest() {
        assertThat(lotto.getNumbers().size()).isNotZero();
    }

    @Test
    @DisplayName("여섯자리 로또번호를 반환횐다")
    void getNumbersTest() {
        // when & then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @RepeatedTest(value = 500, name ="중복로또는 생성하지 않음 : {currentRepetition}/{totalRepetitions}")
    @DisplayName("중복된 로또번호는 생성하지 않는다.")
    void doNotOverlapCreateTest(){
        assertThat(new HashSet<>(lotto.getNumbers()).size()).isEqualTo(6);
    }
}
