package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

final class Lottos {

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
}
