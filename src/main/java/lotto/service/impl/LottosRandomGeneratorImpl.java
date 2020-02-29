package lotto.service.impl;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;

import static lotto.Constants.LOTTO_ONE_PRICE;

public class LottosRandomGeneratorImpl implements LottosGenerator {

    @Override
    public Lottos generate(final Money money) {
        return Lottos.createByRandom(money.getBuyingType().getRandomCount());
    }

    private static int getCountByMoney(final Money money){
        return (money.get() / LOTTO_ONE_PRICE);
    }
}
