package launcher;

import launcher.console.ResultView;
import lotto.Money;
import launcher.console.InputView;
import lotto.middleware.LottoResult;
import lotto.model.Lottos;
import lotto.middleware.LottoAdapter;
import lotto.model.WinningLotto;
import lotto.service.LottoGenerator;
import lotto.service.impl.LottoWonGeneratorImpl;

public class LottoConsoleLauncher {

    public static void main(String[] args) {

        final Money money = InputView.inputMoney();

        final LottoGenerator lottoGenerator = new LottoWonGeneratorImpl();
        final Lottos lottos = lottoGenerator.generate(money);
        final LottoAdapter lottoAdapter = lottos.getLottoAdapter();

        ResultView.printMyLottoCount(lottoAdapter);
        ResultView.printMyLottoList(lottoAdapter);

        final String line = InputView.inputPrevWeekLottoNumber();
        final Integer bonusNumber = InputView.inputPrevWeekBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(line, bonusNumber);

        final LottoResult lottoResult = new LottoResult(lottos.getResultLottery(winningLotto));

        ResultView.printResult(lottoResult);
    }
}
