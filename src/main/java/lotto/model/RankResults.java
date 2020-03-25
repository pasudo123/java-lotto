package lotto.model;

import lotto.Money;
import lotto.type.Rank;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
    public String getRevenue(final Money money){
        double value = ((double)totalMoneyBuyLottos(money) / (double)winningMoney()) * PERCENTS_OF_100;
        return BigDecimal.valueOf(value).toPlainString();
    }

    public long countOfRank(final Rank rank){
        return winningResults.stream()
                .filter(winningResult -> winningResult.getRank() == rank)
                .count();
    }

    private int totalMoneyBuyLottos(final Money money){
        return rankResults.size() * money.getLottoOnePrice();
    }

    private int winningMoney(){
        return winningResults.stream()
                .mapToInt(RankResult::getWinningMoney)
                .sum();
    }
}
