package lotto.model;

import lotto.type.MatchType;
import lotto.type.Rank;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.LOTTO_MATCH_MIN_PRIZE;

public class RankResult implements Comparable<RankResult>{

    private final Integer matchCount;
    private List<Integer> numbers;
    private Rank rank;

    public RankResult(final int matchCount,
                      final boolean isMatchBonus,
                      final List<Integer> numbers){
        this.matchCount = matchCount;
        this.numbers = new ArrayList<>(numbers);
        this.rank = Rank.findByMatchType(MatchType.of(matchCount, isMatchBonus));
    }

    public boolean isPrize(){
        return this.matchCount >= LOTTO_MATCH_MIN_PRIZE;
    }

    public int getWinningMoney(){
        return rank.winningMoney();
    }

    public Rank getRank(){
        return rank;
    }

    @Override
    public int compareTo(RankResult rankResult) {
        return this.matchCount.compareTo(rankResult.matchCount);
    }
}
