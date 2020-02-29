package lotto.model;

import lotto.LottoBuyingType;
import lotto.Money;

import java.util.List;

import static lotto.Constants.NUMBER_OF_ZERO;

public class BuyingPocket {

    private Money money;
    private List<String> passiveLottoPapers;
    private LottoBuyingType lottoBuyingType;

    private BuyingPocket(final Money money, final Integer totalCount, final List<String> passiveLottoPapers) {
        this.money = money;
        this.passiveLottoPapers = passiveLottoPapers;
        this.lottoBuyingType = LottoBuyingType.createBuyingTypeByCounts(totalCount, passiveLottoPapers.size());
    }

    public static BuyingPocket of(final Money money, final List<String> passiveLottoPapers){
        validate(money, passiveLottoPapers.size());
        return new BuyingPocket(money, (money.get() / money.getLottoOnePrice()), passiveLottoPapers);
    }

    private static void validate(final Money money, final Integer passiveBuyingLottoCount) {
        if(passiveBuyingLottoCount < NUMBER_OF_ZERO) {
            throw new IllegalArgumentException("수동 구매의 로또 개수가 음수입니다.");
        }

        if(passiveBuyingLottoCount * money.getLottoOnePrice() > money.get()) {
            throw new IllegalArgumentException("수동 로또의 개수가 구매 금액을 초과합니다.");
        }
    }

    public Integer getBuyingLottoCount() {
        return (lottoBuyingType.getPassiveCount() + lottoBuyingType.getRandomCount()) * money.getLottoOnePrice();
    }

    public List<String> getPassiveLottoPapers() {
        return passiveLottoPapers;
    }

    public LottoBuyingType getBuyingType() {
        return lottoBuyingType;
    }
}
