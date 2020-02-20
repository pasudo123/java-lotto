package launcher;

import launcher.console.ResultView;
import lotto.Money;
import launcher.console.InputView;
import lotto.middleware.LottoResult;
import lotto.model.Lottos;
import lotto.middleware.LottoAdapter;
import lotto.model.PrevWeekLotto;
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

        final PrevWeekLotto prevWeekLotto = InputView.inputPrevWeekLottoNumber();

        final LottoResult lottoResult = new LottoResult(lottos.getResultLottery(prevWeekLotto));

        ResultView.printResult(lottoResult);
    }
}
