package lotto.service.impl;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;

public class LottosPassiveGeneratorImpl implements LottosGenerator {

    @Override
    public Lottos generate(final Money money) {
        return Lottos.createByPassive(money.getPassiveLottoPapers());
    }
}
