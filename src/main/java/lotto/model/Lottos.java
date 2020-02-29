package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(final int count){
        IntStream.rangeClosed(1, count)
                .forEach(i -> lottos.add(Lotto.create()));
    }

    private Lottos(final List<String> lines) {

    }

    public static Lottos createByRandom(final int count){
        validateCount(count);
        return new Lottos(count);
    }

    private static void validateCount(final int count) {
        if(count <= 0) {
            throw new IllegalArgumentException("로또를 생성할 수 없습니다.");
        }
    }

    public static Lottos createByPassive(List<String> lines){
        validateLines()
    }

    public int getCount(){
        return lottos.size();
    }

    public List<Lotto> get(){
        return new ArrayList<>(lottos);
    }
}
