package lotto.dto;

import lotto.type.Rank;

import java.util.Map;

public class WinningLottoDto {

    private String revenue;
    private Map<Rank, Long> ranks;

    public WinningLottoDto(final String revenue, final Map<Rank, Long> ranks){
        this.revenue = revenue;
        this.ranks = ranks;
    }

    public String getRevenue(){
        return revenue;
    }

    public Map<Rank, Long> getRanks(){
        return ranks;
    }
}
