package lotto.service;

import lotto.dto.Money;
import lotto.model.Lottos;

public class LottoGenerator {

    private static final int LOTTO_PRICE = 1000;

    private LottoGenerator(){}

    public static Lottos generate(final Money money) {
        return Lottos.create(getCountByMoney(money));
    }

    private static int getCountByMoney(final Money money){
        return (money.get() / LOTTO_PRICE);
    }
}
