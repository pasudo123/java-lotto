package lotto.middleware;

import lotto.model.LottoRankResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class LottoResult {

    private static final int[] MATCH_COMPENSATION = new int[]{0, 0, 0, 5000, 50000, 1500000, 2000000000};

    private final Integer purchaseWon;
    private final List<LottoRankResult> winnerLotto;
    private Integer revenue;

    public LottoResult(final List<LottoRankResult> adapterList){

        validate(adapterList);

        this.purchaseWon = adapterList.size() * LOTTO_PRICE;

        this.winnerLotto = adapterList.stream()
                .filter(LottoRankResult::isPrize)
                .collect(Collectors.toList());

        Collections.sort(winnerLotto);

        this.initRevenue();
    }

    public int getMoneyByPrize(final Integer prize) {
        return MATCH_COMPENSATION[prize];
    }

    private void initRevenue(){

        int revenue = 0;

        for(int prize = LOTTO_MATCH_MIN_PRIZE; prize <= LOTTO_MATCH_MAX_PRIZE; prize++){
            revenue += (this.getWinnerCountByPrize(prize) * this.getMoneyByPrize(prize));
        }

        this.revenue = (revenue / purchaseWon);
    }

    public int getRevenue(){
        return revenue;
    }

    private void validate(final List<LottoRankResult> adapterList){
        if(adapterList == null || adapterList.size() == 0){
            throw new IllegalArgumentException("구입한 로또가 존재하지 않습니다.");
        }
    }
}
