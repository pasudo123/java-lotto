package lotto.middleware;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAdapter {

    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoAdapter(final List<Lotto> lottoList){
        this.nullOrSizeZeroCheck(lottoList);
        this.lottoList.addAll(lottoList);
    }

    public int getLottoCount(){
        return lottoList.size();
    }

    public List<List<Integer>> getMyLottoList(){
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    private void nullOrSizeZeroCheck(final List<Lotto> lottoList) {
        if(lottoList == null || lottoList.size() == 0) {
            throw new IllegalArgumentException("현재 내가 구입한 로또가 없습니다.");
        }
    }
}
