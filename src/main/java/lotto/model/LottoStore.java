package lotto.model;

public class LottoStore {
    public static Lottos getMyLottosByMoney(final BuyingPocket pocket){
        return pocket.toLottos();
    }
}
