package lotto.model;

import lotto.Money;
import lotto.exception.BuyingPocketException;

import java.util.List;

public class BuyingPocket {

    private List<String> passiveLottoPapers;
    private BuyingType buyingType;

    private BuyingPocket(final Integer totalCount, final List<String> passiveLottoPapers) {
        this.passiveLottoPapers = passiveLottoPapers;
        this.buyingType = BuyingType.createBuyingTypeByCounts(totalCount, passiveLottoPapers.size());
    }

    public static BuyingPocket of(final Money money, final List<String> passiveLottoPapers){
        validate(money, passiveLottoPapers);
        return new BuyingPocket((money.get() / money.getLottoOnePrice()), passiveLottoPapers);
    }

    private static void validate(final Money money, final List<String> passiveLottoPapers) {
        if(passiveLottoPapers == null) {
            throw new BuyingPocketException("수동로또의 개수가 없습니다.");
        }

        if(passiveLottoPapers.size() * money.getLottoOnePrice() > money.get()) {
            throw new BuyingPocketException("수동로또의 개수가 구매 금액을 초과합니다.");
        }
    }

    public List<String> getPassiveLottoPapers() {
        return passiveLottoPapers;
    }

    public BuyingType getBuyingType(){
        return buyingType;
    }

    public Lottos toLottos() {
        return buyingType.toLottos(this);
    }
}
