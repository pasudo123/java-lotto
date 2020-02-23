package lotto.dto;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

    private final List<Lotto> lottoList;

    public LottoDto(final Lottos lottos){
        lottoList = new ArrayList<>(lottos.get());
    }

    public int getLottoCount(){
        return lottoList.size();
    }

    public List<List<Integer>> getMyLottoList(){
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
