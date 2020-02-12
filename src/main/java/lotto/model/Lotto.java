package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

final class Lotto {

    private final List<Number> lotto = new ArrayList<>();

    private Lotto(){
        IntStream.range(0, 7)
                .forEach(i -> lotto.add(new Number()));
        Collections.shuffle(lotto);
    }

    public static Lotto create(){
        return new Lotto();
    }
}
