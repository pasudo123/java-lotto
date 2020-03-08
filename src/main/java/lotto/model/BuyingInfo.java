package lotto.model;

import lotto.Money;

public class BuyingInfo {
    private final Money money;
    private final int manualLottoCount;

    private BuyingInfo(final Money money, final int manualLottoCount) {
        this.money = money;
        this.manualLottoCount = manualLottoCount;
    }

    public static BuyingInfo of(final Money money, final int manualLottoCount) {
        validate(money, manualLottoCount);
        return new BuyingInfo(money, manualLottoCount);
    }

    private static void validate(final Money money, final int manualLottoCount){
        if(money == null){
            throw new IllegalArgumentException("로또를 구매하기 위한 금액이 널입니다.");
        }

        if(manualLottoCount < 0) {
            throw new IllegalArgumentException("수동로또를 구매하기 위한 개수가 음수입니다.");
        }

        if(money.get() < manualLottoCount * money.getLottoOnePrice()){
            throw new IllegalArgumentException("수동로또의 개수가 구매 금액을 초과합니다.");
        }
    }

    public int getAutoLottoBuyingCount(){
        return (money.get() / money.getLottoOnePrice()) - getManualLottoBuyingCount();
    }

    public int getManualLottoBuyingCount(){
        return manualLottoCount;
    }
}
