package lotto.model;

import lotto.LottoBuyingType;
import lotto.Money;
import lotto.service.LottosGenerator;
import lotto.service.impl.LottosPassiveGeneratorImpl;
import lotto.service.impl.LottosRandomGeneratorImpl;

public class LottoStore {

    private static LottosGenerator lottosPassiveGenerator;
    private static LottosGenerator lottosRandomGenerator;

    static{
        lottosPassiveGenerator = new LottosPassiveGeneratorImpl();
        lottosRandomGenerator = new LottosRandomGeneratorImpl();
    }

    public static Lottos getMyLottos(final Money myMoney){

        final LottoBuyingType lottoBuyingType = myMoney.getBuyingType();

//        if(lottoBuyingType.getType() == LottoBuyingType.BuyingType.RANDOM){
//            lottosRandomGenerator.generate(myMoney);
//        }
//
//        if(lottoBuyingType.getType() == LottoBuyingType.BuyingType.PASSIVE){
//            lottosPassiveGenerator.generate(myMoney);
//        }

        return null;
    }

}
