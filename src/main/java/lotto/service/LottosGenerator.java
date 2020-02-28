package lotto.service;

import lotto.Money;
import lotto.model.Lottos;

public interface LottosGenerator {

    public Lottos generate(final Money money);
}
