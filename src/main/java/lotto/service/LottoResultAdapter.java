package lotto.service;

import java.util.List;

public class LottoResultAdapter implements Comparable<LottoResultAdapter>{

    private static final int THREE = 3;
    private final int matchCount;
    private final List<Integer> myLottos;

    public LottoResultAdapter(final int matchCount, final List<Integer> myLottos){
        this.matchCount = matchCount;
        this.myLottos = myLottos;
    }

    public boolean isPrize(){
        return this.matchCount >= THREE;
    }

    public boolean isEqualMatchCount(final int prize){
        return this.matchCount == prize;
    }

    @Override
    public int compareTo(LottoResultAdapter lottoResultAdapter) {
        return this.matchCount - lottoResultAdapter.matchCount;
    }
}
