package launcher.console;

import lotto.dto.LottoDto;
import lotto.dto.WinningLottoDto;
import lotto.type.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String MATCH_FORMAT = "%d개 일치%s(%d원) - %d개";

    public static void printWinning(final WinningLottoDto winningLottoDto){
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("=============================================");

        final Map<Rank, Long> ranks = winningLottoDto.getRanks();
        for(Rank rank : ranks.keySet()){
            printRankResultInConsole(ranks, rank);
        }

        System.out.println("총 수익률은 " + winningLottoDto.getRevenue() + "% 입니다.");
    }

    private static void printRankResultInConsole(final Map<Rank, Long> ranks, final Rank rank) {
        if(rank == Rank.MISS){
            return;
        }

        System.out.println(String.format(MATCH_FORMAT,
                rank.countOfMatch(),
                (rank.getRanking() == 2) ? ", 보너스볼 일치" : "",
                rank.winningMoney(),
                ranks.get(rank)));
    }

    public static void printMyLottoCount(final LottoDto lottoDto) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.",
                lottoDto.getPassiveCount(),
                lottoDto.getRandomCount()));
    }

    public static void printMyLottoList(final LottoDto adapter){

        final List<List<Integer>> myLottoList = adapter.getMyLottos();

        final StringBuilder sb = new StringBuilder();

        for(List<Integer> integers : myLottoList) {
            sb.append(Arrays.toString(integers.toArray()));
            sb.append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
