package lotto.model;

public class BuyingCount {

    private Integer randomCount;
    private Integer manualCount;

    BuyingCount(final int randomCount, final int manualCount) {
        this.randomCount = randomCount;
        this.manualCount = manualCount;
    }

    public static BuyingCount createBuyingTypeByCounts(final int totalCount, final int manualCount) {
        final int randomCount = totalCount - manualCount;
        return new BuyingCount(randomCount, manualCount);
    }

    public Integer getRandomCount() {
        return randomCount;
    }

    public Integer getManualCount() {
        return manualCount;
    }
}
