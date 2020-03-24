package launcher.web.service;

import launcher.web.dto.WebWinningLottoDto;
import lotto.Money;
import lotto.dto.WinningLottoDto;
import lotto.model.Lottos;
import lotto.model.RankResults;
import lotto.model.WinningLotto;
import lotto.service.LottoResultService;
import lotto.type.Rank;

import java.util.*;

public class LottoMatchService {

    private final LottoResultService lottoResultService;

    public LottoMatchService(){
        lottoResultService = new LottoResultService();
    }

    public Map<String, Object> getMyWinningLottos(Money money, Lottos lottos, String winningLottos, Integer bonusNumber){
        final WinningLotto winningLotto = new WinningLotto(winningLottos, bonusNumber);
        final RankResults rankResults = winningLotto.getRankResults(lottos);

        Map<String, Object> model = new HashMap<>();
        WinningLottoDto winningLottoDto = lottoResultService.getWinningLottoByResults(money, rankResults);

        List<WebWinningLottoDto> webWinningLottoDtos = new ArrayList<>();

        final Map<Rank, Long> ranks = winningLottoDto.getRanks();
        for(Rank rank : ranks.keySet()){
            webWinningLottoDtos.add(new WebWinningLottoDto(rank, ranks.get(rank)));
        }

        model.put("ranks", webWinningLottoDtos);
        model.put("revenue", winningLottoDto.getRevenue());

        return model;
    }
}
