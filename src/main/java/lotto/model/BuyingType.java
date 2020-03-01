package lotto.model;

import lotto.type.GenerateType;

import static lotto.Constants.NUMBER_OF_ZERO;

public class BuyingType {

    private Integer randomCount;
    private Integer passiveCount;
    private GenerateType generateType;

    BuyingType(final int randomCount, final int passiveCount, final GenerateType generateType) {
        this.randomCount = randomCount;
        this.passiveCount = passiveCount;
        this.generateType = generateType;
    }

    public static BuyingType createBuyingTypeByCounts(final int totalCount, final int passiveCount){
        final int randomCount = totalCount - passiveCount;

        if(randomCount == NUMBER_OF_ZERO) {
            return new BuyingType(NUMBER_OF_ZERO, passiveCount, GenerateType.PASSIVE);
        }

        if(passiveCount == NUMBER_OF_ZERO){
            return new BuyingType(randomCount, NUMBER_OF_ZERO, GenerateType.RANDOM);
        }

        return new BuyingType(randomCount, passiveCount, GenerateType.BOTH);
    }

    public Integer getRandomCount(){
        return randomCount;
    }

    public Integer getPassiveCount(){
        return passiveCount;
    }

    public GenerateType getGenerateType(){
        return generateType;
    }

    public Lottos toLottos(final BuyingPocket pocket){
        return generateType.generateLottos(pocket);
    }
}
