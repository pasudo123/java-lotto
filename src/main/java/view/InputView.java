package view;

import lotto.middleware.LottoResult;
import lotto.model.Lottos;
import lotto.model.PrevWeekLotto;
import lotto.Won;
import lotto.service.LottoAdapter;
import lotto.service.LottoWonGenerator;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class InputView {

    private static final String COMMA = ", ";
    private static final String OpenBracket = "[";
    private static final String CloseBracket = "]";
    private static final String NEW_LINE = "\n";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView(){}

    public static LottoResult listen(){
        return new InputView().process();
    }

    private LottoResult process(){

        final Won won = askPurchaseMoney();
        final Lottos lottos = LottoWonGenerator.generate(won);
        final LottoAdapter lottoAdapter = lottos.getLottoAdapter();

        printMyLottoCount(lottoAdapter);
        printMyLottoList(lottoAdapter);

        final PrevWeekLotto prevWeekLotto = askPrevWeekLottoNumber();

        return new LottoResult(lottos.getResultLottery(prevWeekLotto));
    }

    private Won askPurchaseMoney(){
        System.out.println("구입금액을 입력해주세요.");
        return new Won(SCANNER.nextLine());
    }

    private void printMyLottoCount(final LottoAdapter adapter) {
        System.out.println(adapter.getLottoCount() + "개를 구매했습니다.");
    }

    private void printMyLottoList(final LottoAdapter adapter){

        final List<List<Integer>> myLottoList = adapter.getMyLottoList();

        final StringBuilder sb = new StringBuilder();

        for(List<Integer> integers : myLottoList) {

            final StringJoiner joiner = new StringJoiner(COMMA, OpenBracket, CloseBracket);

            integers.forEach(integer -> joiner.add(String.valueOf(integer)));

            sb.append(joiner.toString());
            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private PrevWeekLotto askPrevWeekLottoNumber(){
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return new PrevWeekLotto(SCANNER.nextLine());
    }
}
