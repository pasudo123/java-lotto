package lotto.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, 200000000),
    SECOND(5, 30000000),
    THIRD(5, 20000000),
    FOURTH(4, 50000),
    FIFTH(3, 10000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(final int countOfMatch, final int winningMoney){
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
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

            if(matchBonus == Boolean.TRUE){
                throw new IllegalArgumentException("보너스번호와 매칭되는 당첨에 문제가 발생하였습니다.");
            }

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
