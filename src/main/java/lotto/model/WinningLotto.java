package lotto.model;

import lotto.service.LottoValidator;

import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(final String line, final Integer bonusNumber) {
        preValidateCheck(line, bonusNumber);
        this.lotto = Lotto.from(line);
        this.bonusNumber = bonusNumber;
        postValidateCheck();
    }

    private void preValidateCheck(final String line, final Integer bonusNumber){
        LottoValidator.checkNull(line);
        LottoValidator.checkBonusNumber(bonusNumber);
    }

    private void postValidateCheck(){
        LottoValidator.checkNumbers(lotto.getNumbers());
        LottoValidator.checkOverlap(lotto.getNumbers(), bonusNumber);
    }

    public RankResults getRankResults(final Lottos lottos) {
        return new RankResults(lottos.get().stream()
                .map(lotto -> lotto.toRankResult(lotto.getNumbers(), bonusNumber))
                .collect(Collectors.toList()));
    }
}
