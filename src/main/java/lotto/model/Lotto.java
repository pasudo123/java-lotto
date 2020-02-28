package lotto.model;

import lotto.service.LottoRandomMachine;

import java.util.Collections;
import java.util.List;

public final class Lotto {

    private final List<Integer> numbers;

    private Lotto() {
        this.numbers = LottoRandomMachine.generate();
    }

    public static Lotto create() {
        return new Lotto();
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
