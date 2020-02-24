package lotto.model;

import lotto.type.Rank;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.LOTTO_MATCH_MIN_PRIZE;

public class LottoRankResult implements Comparable<LottoRankResult>{

    private final int matchCount;
    private boolean isMatchBonus;
    private List<Integer> numbers;
    private Rank rank;

    public LottoRankResult(final int matchCount,
                           final boolean isMatchBonus,
                           final List<Integer> numbers){
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.numbers = new ArrayList<>(numbers);
        initRank();
    }

    private void initRank(){
        rank = Rank.of(matchCount, isMatchBonus);
    }

    public boolean isPrize(){
        return this.matchCount >= LOTTO_MATCH_MIN_PRIZE;
    }

    public boolean isBonus(){
        return this.isMatchBonus;
    }

    public boolean isEqualMatchCount(final int matchCount) {
        return (this.matchCount == matchCount);
    }

    public int getWinningMoney(){
        return rank.getWinningMoney();
    }

    public int getCountOfMatch(){
        return rank.getCountOfMatch();
    }

    public int getRanking(){
        return rank.getRanking();
    }

    @Override
    public int compareTo(LottoRankResult lottoRankResult) {
        return this.matchCount - lottoRankResult.matchCount;
    }
}
