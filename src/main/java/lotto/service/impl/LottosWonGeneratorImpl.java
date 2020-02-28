package lotto.service.impl;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;

import static lotto.Constants.LOTTO_PRICE;

public class LottosWonGeneratorImpl implements LottosGenerator {

    @Override
    public Lottos generate(final Money money) {
        final int lottoCount = getCountByMoney(money);
        return Lottos.create(lottoCount);
    }

    private static int getCountByMoney(final Money money){
        return (money.get() / LOTTO_PRICE);
    }
}
