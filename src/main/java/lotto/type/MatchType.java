package lotto.type;

public class MatchType {

    private static final int FIVE_MATCH = 5;
    private Integer countOfMatch;
    private Boolean isMatchBonus;
    private BonusMatch bonusMatch;

    enum BonusMatch {
        OK, NOT_MATTERS
    }

    private MatchType(final int countOfMatch,
                      final boolean isMatchBonus){

        this.countOfMatch = countOfMatch;
        this.isMatchBonus = isMatchBonus;
        this.bonusMatch = isSecond() ? BonusMatch.OK : BonusMatch.NOT_MATTERS;
    }

    public static MatchType of(final int countOfMatch, final boolean isMatchBonus){
        return new MatchType(countOfMatch, isMatchBonus);
    }

    private boolean isSecond(){
        return (FIVE_MATCH == countOfMatch && isMatchBonus);
    }

    public int countOfMatch(){
        return this.countOfMatch;
    }

    public boolean isMatchBonus(){
        return isMatchBonus;
    }

    public BonusMatch bonusMatch(){
        return bonusMatch;
    }
}
