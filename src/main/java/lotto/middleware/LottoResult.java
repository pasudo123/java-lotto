package lotto.middleware;

import lotto.service.LottoResultAdapter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int[] MATCH_COMPENSATION = new int[]{0, 0, 0, 5000, 50000, 1500000, 2000000000};

    private static final int MINIMUM_MATCH_PRIZE = 3;
    private static final int MAXIMUM_MATCH_PRIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private final Integer purchaseWon;
    private final List<LottoResultAdapter> winnerLotto;
    private Integer revenue;

    public LottoResult(final List<LottoResultAdapter> adapterList){

        validate(adapterList);

        this.purchaseWon = adapterList.size() * LOTTO_PRICE;

        this.winnerLotto = adapterList.stream()
                .filter(LottoResultAdapter::isPrize)
                .collect(Collectors.toList());

        Collections.sort(winnerLotto);

        this.initRevenue();
    }

    public int getMoneyOnRate(final Integer rate) {
        return MATCH_COMPENSATION[rate];
    }

    public int getWinnerCountOnRate(final Integer rate){

        return (int) winnerLotto.stream()
                .filter(winnerLotto -> winnerLotto.isRateByRate(rate))
                .count();
    }

    private void initRevenue(){

        int revenue = 0;

        for(int p = MINIMUM_MATCH_PRIZE; p <= MAXIMUM_MATCH_PRIZE; p++){
            revenue += (this.getWinnerCountOnRate(p) * this.getMoneyOnRate(p));
        }

        this.revenue = (revenue / purchaseWon);
    }

    public int getRevenue(){
        return revenue;
    }

    private void validate(final List<LottoResultAdapter> adapterList){
        if(adapterList == null || adapterList.size() == 0){
            throw new IllegalArgumentException("구입한 로또가 존재하지 않습니다.");
        }
    }
}
