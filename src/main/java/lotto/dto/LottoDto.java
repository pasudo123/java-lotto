package lotto.dto;

import lotto.Money;
import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDto {

    private final List<Lotto> lottos;
    private final Integer passiveCount;
    private final Integer randomCount;

    public LottoDto(final Lottos lottos, final Money won){
        this.lottos = new ArrayList<>(lottos.get());
        this.passiveCount = won.getBuyingType().getPassiveCount();
        this.randomCount = won.getBuyingType().getRandomCount();
    }

    public List<List<Integer>> getMyLottos(){
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public Integer getPassiveCount(){
        return this.passiveCount;
    }

    public Integer getRandomCount() {
        return this.randomCount;
    }
}
