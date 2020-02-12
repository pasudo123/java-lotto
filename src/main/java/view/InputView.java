package view;

import lotto.Money;
import lotto.model.Won;
import lotto.service.LottoAdapter;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView(){}

    public static Money listen(){
        return new InputView().process();
    }

    private Money process(){
        System.out.println("구입금액을 입력해주세요.");
        final String line = SCANNER.nextLine();
        return new Won(line);
    }

    public static void printLottoDetails(final LottoAdapter adapter){
        System.out.println(adapter.getLottoCount() + "개를 구매했습니다.");
        System.out.println(adapter.getConsoleLottos());
    }
}