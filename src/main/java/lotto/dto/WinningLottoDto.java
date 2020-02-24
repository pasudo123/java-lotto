package lotto.dto;

import lotto.model.LottoRankResult;

import java.util.List;

public class WinningLottoDto {

    private double revenue;
    private List<LottoRankResult> winningResults;
    private int[] countOfRanking;

    public WinningLottoDto(final double revenue, final List<LottoRankResult> winningResults, final int[] countOfRanking){
        this.revenue = revenue;
        this.winningResults = winningResults;
        this.countOfRanking = countOfRanking;
    }

    public double getRevenue(){
        return revenue;
    }

    public List<LottoRankResult> getWinningResults(){
        return winningResults;
    }

    public int[] getCountOfRanking(){
        return countOfRanking;
    }
}
