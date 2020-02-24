package lotto.model;

import lotto.type.Rank;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.LOTTO_MATCH_MIN_PRIZE;

public class LottoRankResult implements Comparable<LottoRankResult>{

    private final int matchCount;
    private List<Integer> numbers;
    private Rank rank;

    public LottoRankResult(final int matchCount,
                           final boolean isMatchBonus,
                           final List<Integer> numbers){
        this.matchCount = matchCount;
        this.numbers = new ArrayList<>(numbers);
        rank = Rank.of(matchCount, isMatchBonus);
    }

    public boolean isPrize(){
        return this.matchCount >= LOTTO_MATCH_MIN_PRIZE;
    }

    public int getWinningMoney(){
        return rank.getWinningMoney();
    }

    public Rank getRank(){
        return rank;
    }

    @Override
    public int compareTo(LottoRankResult lottoRankResult) {
        return this.matchCount - lottoRankResult.matchCount;
    }
}
