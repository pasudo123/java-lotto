package launcher.web.dto;

import lotto.type.Rank;

public class WebWinningLottoDto {

    private boolean bonus;
    private int matchCount;
    private int money;
    private long count;

    public WebWinningLottoDto(Rank rank, long count){
        this.bonus = (rank.name().equalsIgnoreCase("SECOND"));
        this.matchCount = rank.countOfMatch();
        this.money = rank.winningMoney();
        this.count = count;
    }

    public boolean getBonus(){
        return this.bonus;
    }

    public int getMatchCount(){
        return this.matchCount;
    }

    public int getMoney(){
        return money;
    }

    public long getCount(){
        return count;
    }
}
