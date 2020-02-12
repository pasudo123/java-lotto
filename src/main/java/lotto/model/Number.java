package lotto.model;

import java.util.concurrent.ThreadLocalRandom;

final class Number {

    private static final int INCLUDE_FROM_NUMBER = 0;
    private static final int EXCLUDE_TO_NUMBER = 46;

    private final int number;

    Number(){
        this.number = ThreadLocalRandom.current()
                .nextInt(INCLUDE_FROM_NUMBER, EXCLUDE_TO_NUMBER);
    }

    public int get(){
        return number;
    }
}
