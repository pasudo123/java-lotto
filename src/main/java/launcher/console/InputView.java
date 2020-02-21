package launcher.console;

import lotto.Money;
import lotto.Won;
import lotto.model.PrevWeekLotto;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Money inputMoney(){
        return askPurchaseMoney();
    }

    private static Won askPurchaseMoney(){
        System.out.println("구입금액을 입력해주세요.");
        return new Won(SCANNER.nextLine());
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
