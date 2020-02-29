package lotto.model;

import lotto.LottoBuyingType;
import lotto.Money;

public class LottoStore {
    public static Lottos getMyLottosByMoney(final Money myMoney){
        final LottoBuyingType lottoBuyingType = myMoney.getBuyingType();
        return lottoBuyingType.getType().generateLottos();
    }
}
