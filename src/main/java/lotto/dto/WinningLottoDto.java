package lotto.dto;

import lotto.model.LottoRankResult;

import java.util.List;

public class WinningLottoDto {

    private double revenue;
    private List<LottoRankResult> winningResults;
    private int[] countsOfRanking;

    public WinningLottoDto(final double revenue, final List<LottoRankResult> winningResults, final int[] countsOfRanking){
        this.revenue = revenue;
        this.winningResults = winningResults;
        this.countsOfRanking = countsOfRanking;
    }

    public double getRevenue(){
        return revenue;
    }

    public List<LottoRankResult> getWinningResults(){
        return winningResults;
    }

    public int getCountOfRanking(final int ranking){
        return countsOfRanking[ranking];
    }
}
