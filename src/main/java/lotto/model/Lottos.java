package lotto.model;

import lotto.service.LottoAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(final int count){
        IntStream.rangeClosed(1, count)
                .forEach(i -> lottos.add(Lotto.create()));
    }

    public static Lottos create(final int count){
        return new Lottos(count);
    }

    public int getCount(){
        return lottos.size();
    }

    public LottoAdapter getLottoAdapter(){
        return new LottoAdapter(lottos);
    }
}
