package launcher;

import launcher.console.InputView;
import launcher.console.ResultView;
import lotto.Money;
import lotto.dto.LottoDto;
import lotto.dto.WinningLottoDto;
import lotto.model.*;
import lotto.service.LottoResultService;

import java.util.List;

public class LottoConsoleLauncher {

    private static final LottoResultService lottoResultService;

    static {
        lottoResultService = new LottoResultService();
    }

    public static void main(String[] args) {

        final Money money = InputView.inputMoney();
        final Integer passiveCount = InputView.inputPassiveLottoCount();
        final List<String> passiveLottoPapers = InputView.inputPassiveLotto(passiveCount);

        final BuyingPocket pocket = BuyingPocket.of(money, passiveLottoPapers);

        final Lottos lottos = LottoStore.getMyLottosByMoney(pocket);
        final LottoDto lottoDto = new LottoDto(lottos, pocket);

        ResultView.printMyLottoCount(lottoDto);
        ResultView.printMyLottoList(lottoDto);

        final String line = InputView.inputPrevWeekLottoNumber();
        final Integer bonusNumber = InputView.inputPrevWeekBonusNumber();

        final WinningLotto winningLotto = new WinningLotto(line, bonusNumber);
        final RankResults rankResults = winningLotto.getRankResults(lottos);
        final WinningLottoDto winningLottoDto = lottoResultService.getWinningLottoByResults(money, rankResults);

        ResultView.printWinning(winningLottoDto);
    }
}
