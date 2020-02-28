package lotto.dto;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

    private final List<Lotto> lottos;

    public LottoDto(final Lottos lottos){
        this.lottos = new ArrayList<>(lottos.get());
    }

    public int getLottoCount(){
        return lottos.size();
    }

    public List<List<Integer>> getMyLottos(){
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
