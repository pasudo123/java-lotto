package lotto.service;

import static lotto.Constants.LOTTO_MATCH_MIN_PRIZE;

public class LottoResultAdapter implements Comparable<LottoResultAdapter>{

    private final int matchCount;

    public LottoResultAdapter(final int matchCount){
        this.matchCount = matchCount;
    }

    public boolean isPrize(){
        return this.matchCount >= LOTTO_MATCH_MIN_PRIZE;
    }

    public boolean isEqualMatchCount(final int prize){
        return this.matchCount == prize;
    }

    @Override
    public int compareTo(LottoResultAdapter lottoResultAdapter) {
        return this.matchCount - lottoResultAdapter.matchCount;
    }
}
