package launcher.console;

import lotto.dto.LottoDto;
import lotto.dto.WinningLottoDto;
import lotto.model.LottoRankResult;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String MATCH_FORMAT = "%d개 일치%s(%d원) - %d개";

//    public static void printResult(final LottoResult lottoResult){
//        System.out.println();
//        System.out.println("당첨통계");
//        System.out.println("=============================================");
//
//        for(int rate = 3; rate <= 6; rate++){
//            System.out.println(String.format(MATCH_FORMAT,
//                    rate,
//                    "",
//                    lottoResult.getMoneyByPrize(rate),
//                    lottoResult.getWinnerCountByPrize(rate)));
//        }
//
//        System.out.println("총 수익률은 " + lottoResult.getRevenue() + "% 입니다.");
//    }

    public static void printWinning(final WinningLottoDto winningLottoDto){
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("=============================================");

        final List<LottoRankResult> winningResults = winningLottoDto.getWinningResults();

//        for(LottoRankResult result : winningResults){
//            System.out.println(String.format(MATCH_FORMAT,
//                    result.getCountOfMatch(),
//                    "",
//                    result.getWinningMoney(),
//                    winningLottoDto.getCountOfRanking(result.getRanking())))
//        }
    }

    public static void printMyLottoCount(final LottoDto adapter) {
        System.out.println(adapter.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printMyLottoList(final LottoDto adapter){

        final List<List<Integer>> myLottoList = adapter.getMyLottoList();

        final StringBuilder sb = new StringBuilder();

        for(List<Integer> integers : myLottoList) {
            sb.append(Arrays.toString(integers.toArray()));
            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
