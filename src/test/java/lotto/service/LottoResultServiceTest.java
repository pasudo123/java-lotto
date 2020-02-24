package lotto.service;

import lotto.dto.WinningLottoDto;
import lotto.model.LottoRankResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 결과 서비스 레이어는")
class LottoResultServiceTest {

    @ParameterizedTest
    @MethodSource("provideLottoRankResults")
    @DisplayName("당첨로또를 반환한다.")
    void getWinningLottoByResult(List<LottoRankResult> results) {

        // when
        WinningLottoDto winningLottoDto = LottoResultService.getWinningLottoByResult(results);

        // then
        int[] countOfRanking = winningLottoDto.getCountOfRanking();

        assertAll("LottoRanking",
                () -> assertEquals(1, countOfRanking[1]),
                () -> assertEquals(2, countOfRanking[2]),
                () -> assertEquals(0, countOfRanking[3]),
                () -> assertEquals(2, countOfRanking[4]),
                () -> assertEquals(2, countOfRanking[5])
        );
    }

    static Stream<List<LottoRankResult>> provideLottoRankResults(){
        return Stream.of(
            new ArrayList<LottoRankResult>(){{
                add(new LottoRankResult(1, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(2, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(3, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(4, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(5, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(6, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(1, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(2, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(3, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(4, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
                add(new LottoRankResult(5, true, Arrays.asList(1, 2, 3, 4, 5, 6)));
            }}
        );
    }
}