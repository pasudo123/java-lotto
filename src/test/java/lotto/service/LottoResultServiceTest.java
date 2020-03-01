package lotto.service;

import lotto.Money;
import lotto.Won;
import lotto.dto.WinningLottoDto;
import lotto.model.RankResult;
import lotto.model.RankResults;
import lotto.type.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 결과 서비스 레이어는")
class LottoResultServiceTest {

    @ParameterizedTest
    @MethodSource("provideLottoRankResults")
    @DisplayName("당첨로또를 반환한다.")
    void getWinningLottoByResult(Money money, RankResults results) {

        LottoResultService lottoResultService = new LottoResultService();

        // when
        WinningLottoDto winningLottoDto = lottoResultService.getWinningLottoByResults(money, results);

        // then
        Map<Rank, Long> ranks = winningLottoDto.getRanks();

        assertAll("LottoRanking",
                () -> assertEquals(ranks.get(Rank.FIRST), 1),
                () -> assertEquals(ranks.get(Rank.SECOND), 2),
                () -> assertEquals(ranks.get(Rank.THIRD), 0),
                () -> assertEquals(ranks.get(Rank.FOURTH), 2),
                () -> assertEquals(ranks.get(Rank.FIFTH), 2)
        );
    }

    static Stream<Arguments> provideLottoRankResults() {
        return Stream.of(Arguments.of(
                Won.from(10000),
                new RankResults(
                        new ArrayList<RankResult>() {{
                            add(new RankResult(1, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(2, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(3, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(4, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(5, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(6, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(1, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(2, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(3, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(4, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                            add(new RankResult(5, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                        }}
                ))
        );
    }
}