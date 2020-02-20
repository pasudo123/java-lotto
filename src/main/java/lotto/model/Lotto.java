package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lotto {

    private static final int ZERO = 0;
    private static final int SIX = 6;

    private final List<Number> lotto = new ArrayList<>();

    private Lotto(){

        generateRandomLottoNumber();

        while(isOverlap()){
            lotto.clear();
            generateRandomLottoNumber();
        }
    }

    public static Lotto create(){
        return new Lotto();
    }

    public List<Integer> getNumbers(){
        return lotto.stream()
                .map(Number::get)
                .collect(Collectors.toList());
    }

    private void generateRandomLottoNumber(){
        IntStream.range(ZERO, SIX)
                .forEach(i -> lotto.add(new Number()));
    }

    private boolean isOverlap(){

        return SIX != lotto.stream()
                .map(Number::get)
                .collect(Collectors.toSet())
                .size();
    }
}
