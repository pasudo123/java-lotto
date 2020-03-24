package lotto.model;

import lotto.exception.BuyingPocketException;

import java.util.Collections;
import java.util.List;

public class BuyingPocket {

    private BuyingInfo buyingInfo;
    private ManualLottoPapers manualLottoPapers;

    private BuyingPocket(final BuyingInfo buyingInfo, final ManualLottoPapers manualLottoPapers) {
        assert buyingInfo != null;
        assert manualLottoPapers != null;
        this.buyingInfo = buyingInfo;
        this.manualLottoPapers = manualLottoPapers;
    }

    public static BuyingPocket of(final BuyingInfo buyingInfo, final ManualLottoPapers manualLottoPapers){
        validate(buyingInfo, manualLottoPapers);
        return new BuyingPocket(buyingInfo, manualLottoPapers);
    }

    private static void validate(final BuyingInfo buyingInfo, final ManualLottoPapers manualLottoPapers) {
        if(buyingInfo == null || manualLottoPapers == null) {
            throw new BuyingPocketException("현재 주머니에는 널값으로 아무것도 없습니다.");
        }
    }

    public List<String> getManualLottoPapers(){
        return Collections.unmodifiableList(manualLottoPapers.getManualLottoPapers());
    }

    public int getAutoLottoCount(){
        return buyingInfo.getAutoLottoBuyingCount();
    }
}
