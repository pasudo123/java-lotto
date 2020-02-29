package launcher;

import launcher.console.InputView;
import launcher.console.ResultView;
import lotto.Money;
import lotto.Won;
import lotto.dto.LottoDto;
import lotto.dto.WinningLottoDto;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.RankResults;
import lotto.model.WinningLotto;
import lotto.service.LottoResultService;
import lotto.service.LottosGenerator;
import lotto.service.impl.LottosRandomGeneratorImpl;

import java.util.List;

public class LottoConsoleLauncher {

    private static final LottoResultService lottoResultService;
    private static final LottosGenerator lottosGenerator;

    static {
        lottoResultService = new LottoResultService();
        lottosGenerator = new LottosRandomGeneratorImpl();
    }

    public static void main(String[] args) {

        final Integer moneys = InputView.inputMoney();
        final Integer passiveCount = InputView.inputPassiveLottoCount();
        final List<String> passiveLottoPapers = InputView.inputPassiveLotto(passiveCount);

        final Money won = Won.of(moneys, passiveLottoPapers);

        final Lottos lottos = LottoStore.getMyLottosByMoney(won);
        final LottoDto lottoDto = new LottoDto(lottos);

        ResultView.printMyLottoCount(lottoDto);
        ResultView.printMyLottoList(lottoDto);

        final String line = InputView.inputPrevWeekLottoNumber();
        final Integer bonusNumber = InputView.inputPrevWeekBonusNumber();

        final WinningLotto winningLotto = new WinningLotto(line, bonusNumber);
        final RankResults rankResults = winningLotto.getRankResults(lottos);
        final WinningLottoDto winningLottoDto = lottoResultService.getWinningLottoByResults(rankResults);

        ResultView.printWinning(winningLottoDto);
    }
}
