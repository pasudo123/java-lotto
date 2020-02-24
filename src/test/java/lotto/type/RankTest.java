package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("로또 순위 enum 은")
class RankTest {

    @ParameterizedTest(name = "({0}, {1}) 인자 입력 -> {2}등, {3}원 당첨")
    @CsvSource({
        "6, false, 1, 200000000",
        "5, true, 2, 30000000",
        "5, false, 3, 20000000",
        "4, false, 4, 50000",
        "4, true, 4, 50000",
        "3, false, 5, 10000",
        "3, true, 5, 10000",
        "2, false, 6, 0",
        "2, true, 6, 0",
        "1, false, 6, 0",
        "1, true, 6, 0",
        "0, false, 6, 0",
        "1, true, 6, 0",
    })
    @DisplayName("매칭 카운트, 보너스 여부에 따라서 순위를 반환합니다.")
    void ofTest(final int countOfMatch, final Boolean matchBonus, final int myRank, final int won) {

        // when
        Rank rank = Rank.of(countOfMatch, matchBonus);

        // then
        assertThat(rank.getWinningMoney()).isEqualTo(won);
    }

    @ParameterizedTest(name = "({0}, {1}) 인자 입력 -> 에러 발생")
    @CsvSource({
            "-1, false",
            "-2, true",
            "7, false",
            "8, false",
    })
    @DisplayName("매칭 카운트의 범위가 잘못되어서 에러가 발생합니다.")
    void ofExceptionTest(final int countOfMatch, final Boolean matchBonus){

        // when
        Exception e = assertThrows(IllegalArgumentException.class, () -> Rank.of(countOfMatch, matchBonus));

        // then
        assertTrue(e.getMessage().contains("로또번호와 매칭되는 개수가 음수 또는 여섯개를 초과하였습니다."));
    }
}