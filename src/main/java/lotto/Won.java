package lotto;

import java.util.List;

import static lotto.Constants.LOTTO_ONE_PRICE;

public final class Won implements Money {
    private int won;
    private List<String> passiveLottoPapers;
    private LottoBuyingType lottoBuyingType;

    public Won(final Integer money, final Integer totalCount, final List<String> passiveLottoPapers) {
        this.won = money;
        this.passiveLottoPapers = passiveLottoPapers;
        this.lottoBuyingType = LottoBuyingType.createBuyingTypeByCounts(totalCount, passiveLottoPapers.size());
    }

    public static Won of(final Integer money, final List<String> passiveLottoPapers){
        validate(money, passiveLottoPapers.size());
        return new Won(money, (money / LOTTO_ONE_PRICE), passiveLottoPapers);
    }

    @Override
    public int get() {
        return won;
    }

    @Override
    public List<String> getPassiveLottoPapers() {
        return passiveLottoPapers;
    }

    @Override
    public LottoBuyingType getBuyingType() {
        return lottoBuyingType;
    }

    private static void validate(final Integer money, final Integer passiveBuyingLottoCount) {
        if(money < 0) {
            throw new IllegalArgumentException("들어온 금액이 음수입니다.");
        }

        if(money % LOTTO_ONE_PRICE != 0){
            throw new IllegalArgumentException("들어온 금액이 1000원 단위가 아닙니다.");
        }

        if(passiveBuyingLottoCount < 0) {
            throw new IllegalArgumentException("수동 구매의 로또 개수가 음수입니다.");
        }

        if(passiveBuyingLottoCount * LOTTO_ONE_PRICE > money) {
            throw new IllegalArgumentException("현재 금액으로는 수동번호로 로또를 구매하지 못합니다.");
        }
    }

    @Override
    public String toString(){
        return String.valueOf(won);
    }
}
