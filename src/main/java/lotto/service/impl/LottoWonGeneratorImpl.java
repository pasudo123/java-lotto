package lotto.service.impl;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;

import static lotto.Constants.LOTTO_PRICE;

public class LottoWonGeneratorImpl implements LottoGenerator {

    @Override
    public Lottos generate(final Money money) {
        return Lottos.create(getCountByMoney(money));
    }

    private static int getCountByMoney(final Money money){
        return (money.get() / LOTTO_PRICE);
    }
}
