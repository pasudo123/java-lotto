package lotto.dto;

public class WinningLottoDto {

    private double revenue;
    private int[] countsOfRanking;

    public WinningLottoDto(final double revenue, final int[] countsOfRanking){
        this.revenue = revenue;
        this.countsOfRanking = countsOfRanking;
    }

    public double getRevenue(){
        return revenue;
    }

    public int[] getCountOfRanking(){
        return countsOfRanking;
    }
}
