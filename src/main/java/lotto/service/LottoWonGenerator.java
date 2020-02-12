package lotto.service;

import lotto.Money;
import lotto.model.Lottos;

public class LottoWonGenerator {

    private static final int LOTTO_PRICE = 1000;

    private LottoWonGenerator(){}

    public static Lottos generate(final Money money) {
        return Lottos.create(getCountByMoney(money));
    }

    private static int getCountByMoney(final Money money){
        return (money.get() / LOTTO_PRICE);
    }
}
