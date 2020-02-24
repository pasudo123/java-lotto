package lotto.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(1, 6, 200000000),
    SECOND(2,5, 30000000),
    THIRD(3,5, 20000000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 10000),
    MISS(6, 0, 0);

    private int ranking;
    private int countOfMatch;
    private int winningMoney;

    Rank(final int ranking, final int countOfMatch, final int winningMoney){
        this.ranking = ranking;
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getRanking(){
        return ranking;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch(){
        return countOfMatch;
    }

    public static Rank of(final int ranking){
        final Rank[]ranks = values();
        return Arrays.stream(ranks)
                .filter(rank -> rank.getRanking() == ranking)
                .findFirst()
                .orElseGet(() -> Rank.MISS);
    }

    public static Rank of(final int countOfMatch, final Boolean matchBonus){
        validate(countOfMatch);

        final Rank[]ranks = values();
        final List<Rank> myRank = Arrays.stream(ranks)
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .collect(Collectors.toList());

        if(myRank.size() == 0){
            return Rank.MISS;
        }

        if(myRank.size() == 1) {
            return myRank.get(0);
        }

        if(matchBonus){
            return Rank.SECOND;
        }

        return Rank.THIRD;
    }

    private static void validate(final int countOfMatch){
        if(countOfMatch < 0 || countOfMatch > 6) {
            throw new IllegalArgumentException("로또번호와 매칭되는 개수가 음수 또는 여섯개를 초과하였습니다.");
        }
    }
}
