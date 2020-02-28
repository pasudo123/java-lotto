package lotto.type;

import lotto.Money;
import lotto.Won;
import lotto.model.RankResults;

import java.util.*;

public enum Rank {

    FIRST(1, MatchType.of(6, false), new Won("200000000")),
    SECOND(2, MatchType.of( 5, true), new Won("30000000")),
    THIRD(3, MatchType.of(5, false), new Won("20000000")),
    FOURTH(4, MatchType.of(4, false), new Won("50000")),
    FIFTH(5, MatchType.of(3, false), new Won("10000")),
    MISS(6, MatchType.of(0, false), new Won("0"));

    private Integer ranking;
    private MatchType matchType;
    private Money money;

    static class RankComparator implements Comparator<Rank> {
        @Override
        public int compare(Rank o1, Rank o2) {
            return o2.getRanking().compareTo(o1.getRanking());
        }
    }

    Rank(final int ranking, final MatchType matchType, final Money money){
        this.ranking = ranking;
        this.matchType = matchType;
        this.money = money;
    }

    public Integer getRanking(){
        return ranking;
    }

    public int countOfMatch(){
        return matchType.countOfMatch();
    }

    public MatchType.BonusMatch bonusMatch(){
        return matchType.bonusMatch();
    }

    public int winningMoney() {
        return money.get();
    }

    public static Rank findByMatchType(final MatchType matchType){
        assert matchType != null;

        return Arrays.stream(values())
                .filter(rank ->
                        rank.countOfMatch() == matchType.countOfMatch()
                        && rank.bonusMatch() == matchType.bonusMatch())
                .findAny()
                .orElseGet(() -> Rank.MISS);
    }

    public static Map<Rank, Long> toCountOfRank(RankResults rankResults) {

        final Map<Rank, Long> myRanksCount = new LinkedHashMap<>();

        final Rank[] ranks = values();
        Arrays.sort(ranks, new RankComparator());

        for(Rank rank : values()){
            myRanksCount.put(rank, rankResults.countOfRank(rank));
        }

        return Collections.unmodifiableMap(myRanksCount);
    }
}
