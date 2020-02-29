package lotto.type;

import lotto.model.Lottos;
import lotto.service.LottosGenerator;
import lotto.service.impl.LottosBothGeneratorImpl;
import lotto.service.impl.LottosPassiveGeneratorImpl;
import lotto.service.impl.LottosRandomGeneratorImpl;

public enum BuyingType{
    RANDOM(new LottosRandomGeneratorImpl()){
        @Override
        public Lottos generateLottos() {
            return lottosGenerator.generate(null);
        }
    },
    PASSIVE(new LottosPassiveGeneratorImpl()){
        @Override
        public Lottos generateLottos() {
            return lottosGenerator.generate(null);
        }
    },
    BOTH(new LottosBothGeneratorImpl()){
        @Override
        public Lottos generateLottos() {
            return lottosGenerator.generate(null);
        }
    };

    LottosGenerator lottosGenerator;

    BuyingType(final LottosGenerator lottosGenerator){
        this.lottosGenerator = lottosGenerator;
    }

    public abstract Lottos generateLottos();
}