package view;

import lotto.middleware.LottoResult;

public class ResultView {

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
}
