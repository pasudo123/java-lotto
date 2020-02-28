package lotto.service;

import lotto.dto.WinningLottoDto;
import lotto.model.RankResults;
import lotto.type.Rank;

public class LottoResultService {

    public WinningLottoDto getWinningLottoByResults(final RankResults rankResults){
        final double revenue = rankResults.getRevenue();
        return new WinningLottoDto(revenue, Rank.toCountOfRank(rankResults));
    }
}
