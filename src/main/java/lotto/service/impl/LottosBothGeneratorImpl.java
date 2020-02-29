package lotto.service.impl;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;

public class LottosBothGeneratorImpl implements LottosGenerator {

    private static LottosGenerator lottosPassiveGenerator;
    private static LottosGenerator lottosRandomGenerator;

    static{
        lottosPassiveGenerator = new LottosPassiveGeneratorImpl();
        lottosRandomGenerator = new LottosRandomGeneratorImpl();
    }

    @Override
    public Lottos generate(Money money) {
        return Lottos.createByBoth(
                lottosPassiveGenerator.generate(money).get(),
                lottosRandomGenerator.generate(money).get());
    }
}
