package lotto;

import lotto.exception.WonConstructorException;

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
        if(won == null){
            throw new WonConstructorException("들어온 금액이 널입니다.");
        }

        if(won <= NUMBER_OF_ZERO) {
            throw new WonConstructorException("들어온 금액이 음수 또는 0 입니다.");
        }

        if(won % LOTTO_ONE_PRICE != NUMBER_OF_ZERO){
            throw new WonConstructorException("들어온 금액이 1000원 단위가 아니기 때문에 로또를 구매할 수 없습니다.");
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
