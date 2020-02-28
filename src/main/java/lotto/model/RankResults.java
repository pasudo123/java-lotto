package lotto.model;

import lotto.type.Rank;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.LOTTO_PRICE;

public class RankResults {

    private static final Integer PERCENTS_OF_100 = 100;
    private List<RankResult> rankResults = null;
    private List<RankResult> winningResults = null;

    public RankResults(final List<RankResult> rankResults) {
        this.rankResults = rankResults;
        this.winningResults = getWinningResults();
    }
    private List<RankResult> getWinningResults(){
        return this.rankResults.stream()
                .filter(RankResult::isPrize)
                .collect(Collectors.toList());
    }
    public double getRevenue(){
        return ((double)totalMoneyBuyLottos() / (double)winningMoney()) * PERCENTS_OF_100;
    }

    public long countOfRank(final Rank rank){
        return winningResults.stream()
                .filter(winningResult -> winningResult.getRank() == rank)
                .count();
    }

    private int totalMoneyBuyLottos(){
        return rankResults.size() * LOTTO_PRICE;
    }

    private int winningMoney(){
        return winningResults.stream()
                .mapToInt(RankResult::getWinningMoney)
                .sum();
    }
}
