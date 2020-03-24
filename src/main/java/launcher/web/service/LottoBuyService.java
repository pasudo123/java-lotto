package launcher.web.service;

import lotto.Money;
import lotto.dto.LottoDto;
import lotto.model.BuyingInfo;
import lotto.model.BuyingPocket;
import lotto.model.Lottos;
import lotto.model.ManualLottoPapers;

public class LottoBuyService {

    public LottoDto getMyLottos(Money money, ManualLottoPapers manualLottoPapers){

        final BuyingInfo buyingInfo = BuyingInfo.of(money, manualLottoPapers.getManualLottoPapers().size());
        final BuyingPocket pocket = BuyingPocket.of(buyingInfo, manualLottoPapers);

        return new LottoDto(Lottos.create(pocket), pocket);
    }
}
