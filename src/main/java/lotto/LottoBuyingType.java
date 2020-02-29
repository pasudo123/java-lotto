package lotto;

import static lotto.Constants.NUMBER_OF_ZERO;

public class LottoBuyingType {

    private Integer randomCount;
    private Integer passiveCount;
    private BuyingType buyingType;

    public enum BuyingType{
        RANDOM, PASSIVE, BOTH
    }

    LottoBuyingType(final int randomCount, final int passiveCount, final BuyingType buyingType) {
        this.randomCount = randomCount;
        this.passiveCount = passiveCount;
        this.buyingType = buyingType;
    }

    public static LottoBuyingType createBuyingTypeByCounts(final int totalCount, final int passiveCount){
        final int randomCount = totalCount - passiveCount;

        if(randomCount == NUMBER_OF_ZERO) {
            return new LottoBuyingType(NUMBER_OF_ZERO, passiveCount, BuyingType.PASSIVE);
        }

        if(passiveCount == NUMBER_OF_ZERO){
            return new LottoBuyingType(randomCount, NUMBER_OF_ZERO, BuyingType.RANDOM);
        }

        return new LottoBuyingType(randomCount, passiveCount, BuyingType.BOTH);
    }

    public static BuyingType[] values() {
        return BuyingType.values();
    }

    public Integer getRandomCount(){
        return randomCount;
    }

    public Integer getPassiveCount(){
        return passiveCount;
    }

    public BuyingType getType(){
        return buyingType;
    }
}
