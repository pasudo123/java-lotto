package lotto.service;

public class LottoResultAdapter implements Comparable<LottoResultAdapter>{

    private static final int MINIMUM_PRIZE_COUNT = 3;
    private final int matchCount;

    public LottoResultAdapter(final int matchCount){
        this.matchCount = matchCount;
    }

    public boolean isPrize(){
        return this.matchCount >= MINIMUM_PRIZE_COUNT;
    }

    public boolean isEqualMatchCount(final int prize){
        return this.matchCount == prize;
    }

    @Override
    public int compareTo(LottoResultAdapter lottoResultAdapter) {
        return this.matchCount - lottoResultAdapter.matchCount;
    }
}
