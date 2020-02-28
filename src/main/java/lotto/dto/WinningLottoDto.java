package lotto.dto;

import lotto.type.Rank;

import java.util.Map;

public class WinningLottoDto {

    private double revenue;
    private Map<Rank, Long> ranks;

    public WinningLottoDto(final double revenue, final Map<Rank, Long> ranks){
        this.revenue = revenue;
        this.ranks = ranks;
    }

    public double getRevenue(){
        return revenue;
    }

    public Map<Rank, Long> getRanks(){
        return ranks;
    }
}
