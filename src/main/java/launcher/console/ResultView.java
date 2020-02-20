package launcher.console;

import lotto.middleware.LottoAdapter;
import lotto.middleware.LottoResult;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String MATCH_FORMAT = "%d개 일치 (%d원) - %d개";

    public static void printResult(final LottoResult lottoResult){

        System.out.println();
        System.out.println("당첨통계");
        System.out.println("=============================================");

        for(int rate = 3; rate <= 6; rate++){
            System.out.println(String.format(MATCH_FORMAT,
                    rate,
                    lottoResult.getMoneyByPrize(rate),
                    lottoResult.getWinnerCountByPrize(rate)));
        }

        System.out.println("총 수익률은 " + lottoResult.getRevenue() + "% 입니다.");
    }

    public static void printMyLottoCount(final LottoAdapter adapter) {
        System.out.println(adapter.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printMyLottoList(final LottoAdapter adapter){

        final List<List<Integer>> myLottoList = adapter.getMyLottoList();

        final StringBuilder sb = new StringBuilder();

        for(List<Integer> integers : myLottoList) {
            sb.append(Arrays.toString(integers.toArray()));
            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
