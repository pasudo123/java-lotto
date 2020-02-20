package lotto.service.impl;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;

public class LottoWonGeneratorImpl implements LottoGenerator {

    private static final int LOTTO_PRICE = 1000;

    @Override
    public Lottos generate(final Money money) {
        return Lottos.create(getCountByMoney(money));
    }

    private static int getCountByMoney(final Money money){
        return (money.get() / LOTTO_PRICE);
    }
}
