package lotto.type;

import lotto.Money;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;
import lotto.service.impl.LottosBothGeneratorImpl;
import lotto.service.impl.LottosPassiveGeneratorImpl;
import lotto.service.impl.LottosRandomGeneratorImpl;

public enum GenerateType {
    RANDOM(new LottosRandomGeneratorImpl()){
        @Override
        public Lottos generateLottos(Money money) {
            return lottosGenerator.generate(money);
        }
    },
    PASSIVE(new LottosPassiveGeneratorImpl()){
        @Override
        public Lottos generateLottos(Money money) {
            return lottosGenerator.generate(money);
        }
    },
    BOTH(new LottosBothGeneratorImpl()){
        @Override
        public Lottos generateLottos(Money money) {
            return lottosGenerator.generate(money);
        }
    };

    LottosGenerator lottosGenerator;

    GenerateType(final LottosGenerator lottosGenerator){
        this.lottosGenerator = lottosGenerator;
    }

    public abstract Lottos generateLottos(Money money);
}