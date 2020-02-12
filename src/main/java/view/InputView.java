package view;

import lotto.dto.Money;

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
        return new Money(line);
    }
}
