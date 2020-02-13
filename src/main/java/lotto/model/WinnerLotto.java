package lotto.model;

import java.util.List;

public class WinnerLotto {

    private final int matchCount;
    private final List<Integer> winnerLotto;

    WinnerLotto(final int matchCount, final List<Integer> winnerLotto){
        this.matchCount = matchCount;
        this.winnerLotto = winnerLotto;
    }
}
