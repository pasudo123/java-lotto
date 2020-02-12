package lotto.dto;

import org.apache.commons.lang3.StringUtils;

public class Money {

    private int money;

    public Money(final String money) {

        this.nullOrEmptyCheck(money);
        this.negativeCheck(money);

        this.money = Integer.parseInt(money);
    }

    int get() {
        return money;
    }

    private void nullOrEmptyCheck(final String money) {
        if(StringUtils.isEmpty(money)) {
            throw new IllegalArgumentException("로또 구입 금액은 널 또는 공백이 될 수 없습니다.");
        }
    }

    private void negativeCheck(final String money) {

        if(Integer.parseInt(money) < 0) {
            throw new IllegalArgumentException("로또 구입 금액은 음수가 될 수 없습니다.");
        }

    }
}
