package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lotto {

    private static final int IN_START_NUMBER = 0;
    private static final int IN_END_NUMBER = 6;

    private final List<Number> lotto = new ArrayList<>();

    private Lotto(){

        // TODO 동일번호 들어왔을 경우 체크.

        IntStream.range(IN_START_NUMBER, IN_END_NUMBER)
                .forEach(i -> lotto.add(new Number()));
        Collections.shuffle(lotto);
    }

    public static Lotto create(){
        return new Lotto();
    }

    public List<Integer> getNumbers(){
        return lotto.stream()
                .map(Number::get)
                .collect(Collectors.toList());
    }
}
