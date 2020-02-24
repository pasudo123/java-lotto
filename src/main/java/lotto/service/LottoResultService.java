package lotto.service;

import lotto.dto.WinningLottoDto;
import lotto.model.LottoRankResult;
import lotto.type.Rank;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.LOTTO_PRICE;

public class LottoResultService {

    private static final Integer PERCENTS_OF_100 = 100;

    /**
     *
     * @param results 내가 가진 로또의 결과들에서 당첨된 로또들만 추린다.
     * @return 당첨된 로또
     */
    public static WinningLottoDto getWinningLottoByResult(final List<LottoRankResult> results){

        // 구매 금액
        final int totalPurchaseMoney = results.size() * LOTTO_PRICE;

        // 당첨 로또들
        final List<LottoRankResult> winningResults = results.stream()
                .filter(LottoRankResult::isPrize)
                .collect(Collectors.toList());

        // 당첨금 총합
        final int winningSumMoney = winningResults.stream()
                .mapToInt(LottoRankResult::getWinningMoney)
                .sum();

        // 랭킹별 로또 개수
        final int[] countOfRanking = new int[7]; // 0 ~ 6

        final Rank[]ranks = Rank.values();
        for(Rank rank : ranks) {

            final long rankCount = winningResults.stream()
                    .filter(lottoRankResult -> lottoRankResult.getRank() == rank)
                    .count();

            countOfRanking[rank.getRanking()] = Math.toIntExact(rankCount);
        }

        final double revenue = (double)(winningSumMoney / totalPurchaseMoney) * PERCENTS_OF_100;

        return new WinningLottoDto(revenue, countOfRanking);
    }
}
