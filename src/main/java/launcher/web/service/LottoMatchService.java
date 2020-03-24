package launcher.web.service;

import lotto.Money;
import lotto.dto.WinningLottoDto;
import lotto.model.Lottos;
import lotto.model.RankResults;
import lotto.model.WinningLotto;
import lotto.service.LottoResultService;

public class LottoMatchService {

    private final LottoResultService lottoResultService;

    public LottoMatchService(){
        lottoResultService = new LottoResultService();
    }

    public WinningLottoDto getMyWinningLottos(Money money, Lottos lottos, String winningLottos, Integer bonusNumber){
        final WinningLotto winningLotto = new WinningLotto(winningLottos, bonusNumber);
        final RankResults rankResults = winningLotto.getRankResults(lottos);

        return lottoResultService.getWinningLottoByResults(money, rankResults);
    }
}
