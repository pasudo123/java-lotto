package lotto.model;

import lotto.Money;

public class LottoStore {
    public static Lottos getMyLottosByMoney(final Money myMoney){
        return myMoney.getBuyingType()
                .getType()
                .generateLottos(myMoney);
    }
}
