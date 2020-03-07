//package lotto.type;
//
//import lotto.model.BuyingPocket;
//import lotto.model.Lottos;
//import lotto.service.LottosGenerator;
//import lotto.service.impl.LottosBothGeneratorImpl;
//import lotto.service.impl.LottosManualGeneratorImpl;
//import lotto.service.impl.LottosRandomGeneratorImpl;
//
//public enum GenerateType {
//    RANDOM(new LottosRandomGeneratorImpl()),
//    MANUAL(new LottosManualGeneratorImpl()),
//    BOTH(new LottosBothGeneratorImpl());
//
//    LottosGenerator lottosGenerator;
//
//    GenerateType(final LottosGenerator lottosGenerator){
//        this.lottosGenerator = lottosGenerator;
//    }
//
//    public Lottos generateLottos(BuyingPocket pocket){
//        return lottosGenerator.generate(pocket);
//    }
//}