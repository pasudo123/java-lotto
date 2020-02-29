package lotto.model;

import lotto.service.LottoRandomMachine;
import lotto.service.LottoValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public final class Lotto {

    private final List<Integer> numbers;

    private Lotto() {
        this.numbers = LottoRandomMachine.generate();
    }

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create() {
        return new Lotto();
    }

    public static Lotto from(final String line){
        final List<Integer> numbers = Arrays.stream(
                line.replaceAll(WHITE_SPACE, SPACE).split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        LottoValidator.checkNumbers(numbers);
        return new Lotto(numbers);
    }

    private int getMatchCountByWinningNumbers(final List<Integer> winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }

    private boolean isBonusMatch(final Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public RankResult toRankResult(final List<Integer> winningNumbers, final Integer bonusNumber){
        final int matchCount = getMatchCountByWinningNumbers(winningNumbers);
        final boolean isMatchBonus = isBonusMatch(bonusNumber);
        return new RankResult(matchCount, isMatchBonus, numbers);
    }
}
