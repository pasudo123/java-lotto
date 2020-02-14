package launcher;

import lotto.middleware.LottoResult;
import view.InputView;
import view.ResultView;

public class LottoLauncher {

    public static void main(String[] args) {

        final LottoResult lottoResult = InputView.listen();

        ResultView.printResult(lottoResult);
    }
}
