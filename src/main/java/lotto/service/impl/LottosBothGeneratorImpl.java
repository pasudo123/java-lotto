//package lotto.service.impl;
//
//import lotto.model.BuyingPocket;
//import lotto.model.Lottos;
//import lotto.service.LottosGenerator;
//
//public class LottosBothGeneratorImpl implements LottosGenerator {
//
//    private static LottosGenerator lottosPassiveGenerator;
//    private static LottosGenerator lottosRandomGenerator;
//
//    static{
//        lottosPassiveGenerator = new LottosManualGeneratorImpl();
//        lottosRandomGenerator = new LottosRandomGeneratorImpl();
//    }
//
//    @Override
//    public Lottos generate(BuyingPocket pocket) {
//        return Lottos.createByBoth(
//                lottosPassiveGenerator.generate(pocket),
//                lottosRandomGenerator.generate(pocket));
//    }
//}
