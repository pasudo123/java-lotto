package lotto.type;

import lotto.model.BuyingPocket;
import lotto.model.Lottos;
import lotto.service.LottosGenerator;
import lotto.service.impl.LottosBothGeneratorImpl;
import lotto.service.impl.LottosPassiveGeneratorImpl;
import lotto.service.impl.LottosRandomGeneratorImpl;

public enum GenerateType {
    RANDOM(new LottosRandomGeneratorImpl()){
        @Override
        public Lottos generateLottos(BuyingPocket pocket) {
            return lottosGenerator.generate(pocket);
        }
    },
    PASSIVE(new LottosPassiveGeneratorImpl()){
        @Override
        public Lottos generateLottos(BuyingPocket pocket) {
            return lottosGenerator.generate(pocket);
        }
    },
    BOTH(new LottosBothGeneratorImpl()){
        @Override
        public Lottos generateLottos(BuyingPocket pocket) {
            return lottosGenerator.generate(pocket);
        }
    };

    LottosGenerator lottosGenerator;

    GenerateType(final LottosGenerator lottosGenerator){
        this.lottosGenerator = lottosGenerator;
    }

    public abstract Lottos generateLottos(BuyingPocket pocket);
}