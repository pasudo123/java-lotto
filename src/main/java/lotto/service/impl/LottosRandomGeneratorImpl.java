package lotto.service.impl;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;

public class LottosRandomGeneratorImpl implements LottosGenerator {

    @Override
    public Lottos generate(final Money money) {
        return Lottos.createByRandom(money.getBuyingType().getRandomCount());
    }
}
