package lotto.service.impl;

import lotto.model.BuyingPocket;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;

public class LottosRandomGeneratorImpl implements LottosGenerator {

    @Override
    public Lottos generate(final BuyingPocket pocket) {
        return Lottos.createByRandom(pocket.getBuyingType().getRandomCount());
    }
}
