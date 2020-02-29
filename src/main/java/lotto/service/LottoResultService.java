package lotto.service;

import lotto.Money;
import lotto.dto.WinningLottoDto;
import lotto.model.RankResults;
import lotto.type.Rank;

public class LottoResultService {

    public WinningLottoDto getWinningLottoByResults(final Money money, final RankResults rankResults){
        final double revenue = rankResults.getRevenue(money);
        return new WinningLottoDto(revenue, Rank.toCountOfRank(rankResults));
    }
}
