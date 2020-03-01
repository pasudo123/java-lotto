package lotto.service;

import lotto.model.BuyingPocket;
import lotto.model.Lottos;

public class LottoStore {
    public static Lottos getMyLottosByMoney(final BuyingPocket pocket){
        return pocket.toLottos();
    }
}
