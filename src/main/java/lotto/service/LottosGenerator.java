package lotto.service;

import lotto.model.BuyingPocket;
import lotto.model.Lottos;

public interface LottosGenerator {

    public Lottos generate(final BuyingPocket pocket);
}
