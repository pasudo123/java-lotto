package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public final class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(final int count){
        IntStream.rangeClosed(1, count)
                .forEach(i -> lottos.add(Lotto.create()));
    }

    private Lottos(final List<String> lines) {
        IntStream.range(0, lines.size())
                .forEach(i -> lottos.add(Lotto.from(lines.get(i))));
    }

    private Lottos(final List<Lotto> preLottos, final List<Lotto> postLottos) {
        lottos.addAll(preLottos);
        lottos.addAll(postLottos);
    }

    public static Lottos createByRandom(final int count){
        validateCount(count);
        return new Lottos(count);
    }

    public static Lottos createByPassive(final List<String> lines){
        validateLines(lines);
        return new Lottos(lines);

    }

    public static Lottos createByBoth(final List<Lotto> preLottos, final List<Lotto> postLottos){
        assert preLottos != null;
        assert postLottos != null;
        return new Lottos(preLottos, postLottos);
    }

    private static void validateCount(final int count) {
        if(count <= 0) {
            throw new IllegalArgumentException("로또를 생성할 수 없습니다.");
        }
    }

    private static void validateLines(final List<String> lines) {
        if(lines == null || lines.size() <= 0) {
            throw new IllegalArgumentException("로또를 생성할 수 없습니다.");
        }
    }

    public int getCount(){
        return lottos.size();
    }

    public List<Lotto> get(){
        return Collections.unmodifiableList(lottos);
    }
}
