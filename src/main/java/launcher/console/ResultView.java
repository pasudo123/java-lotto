package launcher.console;

import lotto.dto.LottoDto;
import lotto.dto.WinningLottoDto;
import lotto.type.Rank;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String MATCH_FORMAT = "%d개 일치%s(%d원) - %d개";

    public static void printWinning(final WinningLottoDto winningLottoDto){
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("=============================================");

        final int[] countOfRanking = winningLottoDto.getCountOfRanking();

        // 5등 -> 1등 순
        for(int rank = 5; rank >= 1; rank--){
            System.out.println(String.format(MATCH_FORMAT,
                    Rank.of(rank).getCountOfMatch(),
                    (rank == 2) ? "보너스볼 일치" : "",
                    Rank.of(rank).getWinningMoney(),
                    countOfRanking[rank]));
        }

        System.out.println("총 수익률은 " + winningLottoDto.getRevenue() + "% 입니다.");
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
