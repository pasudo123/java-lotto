package lotto;

import lotto.type.GenerateType;

import static lotto.Constants.NUMBER_OF_ZERO;

public class LottoBuyingType {

    private Integer randomCount;
    private Integer passiveCount;
    private GenerateType generateType;

    LottoBuyingType(final int randomCount, final int passiveCount, final GenerateType generateType) {
        this.randomCount = randomCount;
        this.passiveCount = passiveCount;
        this.generateType = generateType;
    }

    public static LottoBuyingType createBuyingTypeByCounts(final int totalCount, final int passiveCount){
        final int randomCount = totalCount - passiveCount;

        if(randomCount == NUMBER_OF_ZERO) {
            return new LottoBuyingType(NUMBER_OF_ZERO, passiveCount, GenerateType.PASSIVE);
        }

        if(passiveCount == NUMBER_OF_ZERO){
            return new LottoBuyingType(randomCount, NUMBER_OF_ZERO, GenerateType.RANDOM);
        }

        return new LottoBuyingType(randomCount, passiveCount, GenerateType.BOTH);
    }

    public Integer getRandomCount(){
        return randomCount;
    }

    public Integer getPassiveCount(){
        return passiveCount;
    }

    public GenerateType getType(){
        return generateType;
    }
}
