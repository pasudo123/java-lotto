package lotto;

import static lotto.Constants.NUMBER_OF_ZERO;

public final class Won implements Money {
    private static final Integer LOTTO_ONE_PRICE = 1000;
    private Integer won;

    private Won(final Integer won) {
        this.won = won;
    }

    public static Won from(final Integer won){
        validate(won);
        return new Won(won);
    }

    private static void validate(final Integer won){
        if(won < NUMBER_OF_ZERO) {
            throw new IllegalArgumentException("들어온 금액이 음수입니다.");
        }

        if(won % LOTTO_ONE_PRICE != NUMBER_OF_ZERO){
            throw new IllegalArgumentException("들어온 금액이 1000원 단위가 아닙니다.");
        }
    }

    @Override
    public int get() {
        return won;
    }

    @Override
    public String toString(){
        return String.valueOf(won);
    }

    @Override
    public int getLottoOnePrice(){
        return LOTTO_ONE_PRICE;
    }
}
