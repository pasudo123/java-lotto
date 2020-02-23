package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Constants.LOTTO_MAX_NUMBER;
import static lotto.Constants.LOTTO_MIN_NUMBER;

public final class Lotto {

  private final List<Integer> numbers;

    private Lotto(){

        final List<Integer> numbers =  IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        this.numbers = IntStream.rangeClosed(1, 6)
                .map(numbers::get)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(numbers);
    }

    public static Lotto create(){
        return new Lotto();
    }

    public List<Integer> getNumbers(){
        return new ArrayList<>(numbers);
    }

    public int getMatchCountByWinningNumbers(final List<Integer> winningNumbers){
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean isBonusMatch(final Integer bonusNumber){
        return numbers.contains(bonusNumber);
    }
}
