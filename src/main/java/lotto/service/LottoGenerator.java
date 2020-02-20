package lotto.service;

import lotto.Money;
import lotto.model.Lottos;

public interface LottoGenerator {

    public Lottos generate(final Money money);
}
