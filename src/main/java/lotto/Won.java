package lotto;

import org.apache.commons.lang3.StringUtils;

public final class Won implements Money {

    private int won;

    public Won(final String money) {
        this.validate(money);

        this.won = Integer.parseInt(money);
    }

    @Override
    public int get() {
        return won;
    }

    private void validate(final String money) {
        this.nullOrEmptyCheck(money);
        this.negativeCheck(money);
    }

    private void nullOrEmptyCheck(final String money) {
        if(StringUtils.isEmpty(money)) {
            throw new IllegalArgumentException("로또 구입 금액은 널 또는 공백이 될 수 없습니다.");
        }
    }

    private void negativeCheck(final String money) {
        if(Integer.parseInt(money) < 0) {
            throw new IllegalArgumentException("들어온 금액이 음수 입니다.");
        }
    }

    @Override
    public String toString(){
        return String.valueOf(won);
    }
}
