package launcher;

import launcher.console.InputView;
import launcher.console.ResultView;
import lotto.Money;
import lotto.dto.LottoDto;
import lotto.dto.WinningLottoDto;
import lotto.model.LottoRankResult;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultService;
import lotto.service.impl.LottoWonGeneratorImpl;

import java.util.List;

public class LottoConsoleLauncher {

    public static void main(String[] args) {

        final Money money = InputView.inputMoney();

        final LottoGenerator lottoGenerator = new LottoWonGeneratorImpl();
        final Lottos lottos = lottoGenerator.generate(money);
        final LottoDto lottoDto = new LottoDto(lottos);

        ResultView.printMyLottoCount(lottoDto);
        ResultView.printMyLottoList(lottoDto);

        final String line = InputView.inputPrevWeekLottoNumber();
        final Integer bonusNumber = InputView.inputPrevWeekBonusNumber();

        final WinningLotto winningLotto = new WinningLotto(line, bonusNumber);
        final List<LottoRankResult> lottoRankResults = winningLotto.getResultByMine(lottos);
        final WinningLottoDto winningLottoDto = LottoResultService.getWinningLottoByResult(lottoRankResults);

        ResultView.printWinning(winningLottoDto);
    }
}
