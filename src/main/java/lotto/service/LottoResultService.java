package lotto.service;

import lotto.dto.WinningLottoDto;
import lotto.model.LottoRankResult;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class LottoResultService {

    private static final Integer PERCENTS_OF_100 = 100;

    public static WinningLottoDto getWinningLottoByResult(final List<LottoRankResult> results){

        final int totalMoney = results.size() * LOTTO_PRICE;

        // 이등 당첨 반환.
        final List<LottoRankResult> winningResults = results.stream()
                .filter(LottoRankResult::isPrize)
                .collect(Collectors.toList());

        int rank = 5;
        final int[] countOfRanking = new int[7];    // 랭킹 카운팅

        for(int matchCount = LOTTO_MATCH_MIN_PRIZE; matchCount <= LOTTO_MAX_NUMBER; matchCount++){

            int finalMatchCount = matchCount;
            final long totalCountOfMatch = winningResults.stream()
                    .filter(lottoRankResult -> lottoRankResult.isEqualMatchCount(finalMatchCount))
                    .count();

            if(matchCount == LOTTO_MATCH_BONUS_PRIZE){

                final long secondPrizeCount = winningResults.stream()
                        .filter(LottoRankResult::isBonus)
                        .count();

                final long thirdPrizeCount = totalCountOfMatch - secondPrizeCount;

                countOfRanking[rank--] = Math.toIntExact(thirdPrizeCount);
                countOfRanking[rank--] = Math.toIntExact(secondPrizeCount);
            }

            countOfRanking[rank--] = Math.toIntExact(totalCountOfMatch);
        }

        final int winningSumMoney = winningResults.stream()
                .mapToInt(LottoRankResult::getWinningMoney)
                .sum();

        final double revenue = (double)(winningSumMoney / totalMoney) * PERCENTS_OF_100;

        return new WinningLottoDto(revenue, winningResults, countOfRanking);
    }
}
