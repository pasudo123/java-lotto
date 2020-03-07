package launcher.console;

import lotto.Money;
import lotto.Won;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Money inputMoney(){
        return askPurchaseMoney();
    }

    public static Integer inputPassiveLottoCount() {
        return askPurchasePassiveLottoCount();
    }

    public static List<String> inputPassiveLotto(final int count) {
        return askPurchasePassiveLotto(count);
    }

    private static Money askPurchaseMoney(){
        System.out.println("구입금액을 입력해주세요.");
        return Won.from(SCANNER.nextInt());
    }

    private static Integer askPurchasePassiveLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        final int count = SCANNER.nextInt();
        SCANNER.nextLine();
        return count;
    }

    private static List<String> askPurchasePassiveLotto(final int count){
        if(count == 0) { return Collections.emptyList();}
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> SCANNER.nextLine())
                .collect(Collectors.toList());
    }

    public static String inputPrevWeekLottoNumber(){
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return SCANNER.nextLine();
    }

    public static Integer inputPrevWeekBonusNumber(){
        System.out.println("보너스 볼을 입력해주세요.");
        return SCANNER.nextInt();
    }
}
