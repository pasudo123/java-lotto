package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Constants.LOTTO_MAX_NUMBER;
import static lotto.Constants.LOTTO_MIN_NUMBER;

public class LottoRandomMachine {

    private static List<Integer> numbers;
    private static final int START_INCLUDE_INDEX = 0;
    private static final int END_EXCLUDE_INDEX = 6;

    static {
        numbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generate(){
        Collections.shuffle(numbers);
        List<Integer> generatedNumbers = new ArrayList<>(numbers.subList(START_INCLUDE_INDEX, END_EXCLUDE_INDEX));
        Collections.sort(generatedNumbers);
        return Collections.unmodifiableList(generatedNumbers);
    }
}
