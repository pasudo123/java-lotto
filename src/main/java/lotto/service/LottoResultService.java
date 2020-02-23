package lotto.service;

import lotto.dto.WinningLottoDto;
import lotto.model.LottoRankResult;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.LOTTO_PRICE;

public class LottoResultService {

    private static final Integer PERCENTS_OF_100 = 100;

    public static WinningLottoDto getWinningLottoByResult(final List<LottoRankResult> results){

        final int totalMoney = results.size() * LOTTO_PRICE;

        final List<LottoRankResult> winningResults = results.stream()
                .filter(LottoRankResult::isPrize)
                .sorted(LottoRankResult::compareTo)
                .collect(Collectors.toList());

        final int[] countsOfRankings = new int[7]; // 1 ~ 6 등을 사용
        winningResults.forEach(lottoRankResult -> countsOfRankings[lottoRankResult.getRanking()]++);

        final int winningSumMoney = winningResults.stream()
                .mapToInt(LottoRankResult::getWinningMoney)
                .sum();

        final double revenue = (double)(winningSumMoney / totalMoney) * PERCENTS_OF_100;

        return new WinningLottoDto(revenue, winningResults, countsOfRankings);
    }
}
