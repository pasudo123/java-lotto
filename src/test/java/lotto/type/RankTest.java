package lotto.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 순위 enum 은")
class RankTest {

    @ParameterizedTest(name = "({0}, {1}) 인자 입력 -> {2}등, {3}원 당첨")
    @CsvSource({
        "6, true, 1, 200000000",
        "6, false, 1, 200000000",
        "5, true, 2, 30000000",
        "5, false, 3, 20000000",
        "4, true, 4, 50000",
        "4, false, 4, 50000",
        "3, true, 5, 10000",
        "3, false, 5, 10000",
        "2, true, 6, 0",
        "2, false, 6, 0",
        "1, true, 6, 0",
        "1, false, 6, 0",
        "0, true, 6, 0",
        "1, false, 6, 0",
    })
    @DisplayName("매칭 카운트, 보너스 여부에 따라서 순위를 반환합니다.")
    void ofTest(final int countOfMatch, final Boolean matchBonus, final int myRank, final int won) {

        // when
        Rank rank = Rank.findByMatchType(MatchType.of(countOfMatch, matchBonus));

        // then
        assertThat(rank.winningMoney()).isEqualTo(won);
    }

    @ParameterizedTest(name = "({0}, {1}) 인자 입력 -> 에러 발생")
    @CsvSource({
            "-1, false",
            "-2, true",
            "7, false",
            "8, false",
    })
    @DisplayName("매칭 카운트의 범위가 잘못되어서 Rank.MISS 를 반환합니다.")
    void ofExceptionTest(final int countOfMatch, final Boolean matchBonus){

        // when
        Rank rank = Rank.findByMatchType(MatchType.of(countOfMatch, matchBonus));

        // then
        assertThat(Rank.MISS).isEqualTo(rank);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("매치타입에 널을 입력합니다.")
    void ofExceptionTest(final MatchType matchType){
        assertThrows(AssertionError.class, () -> Rank.findByMatchType(matchType));
    }
}