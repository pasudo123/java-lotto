package lotto.dto;

public class WinningLottoDto {

    private double revenue;
    private int[] countOfRanking;

    public WinningLottoDto(final double revenue, final int[] countOfRanking){
        this.revenue = revenue;
        this.countOfRanking = countOfRanking;
    }

    public double getRevenue(){
        return revenue;
    }

    public int[] getCountOfRanking(){
        return countOfRanking;
    }
}
