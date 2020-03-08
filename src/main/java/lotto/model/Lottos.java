package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public final class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos (final BuyingPocket pocket) {
        assert pocket != null;
        addManualLottos(pocket);
        addAutoLottos(pocket);
    }

    private void addAutoLottos(final BuyingPocket pocket){
        final int count = pocket.getAutoLottoCount();
        IntStream.rangeClosed(1, count)
                .forEach(i -> lottos.add(Lotto.create()));
    }

    private void addManualLottos(final BuyingPocket pocket) {
        final List<String> manualLottoPapers = pocket.getManualLottoPapers();
        IntStream.range(0, manualLottoPapers.size())
                .forEach(i -> lottos.add(Lotto.from(manualLottoPapers.get(i))));
    }

    public static Lottos create(final BuyingPocket buyingPocket){
        validate(buyingPocket);
        return new Lottos(buyingPocket);
    }

    private static void validate(final BuyingPocket buyingPocket) {
        if(buyingPocket == null) {
            throw new IllegalArgumentException("현재 로또를 생성할 주머니가 널입니다.");
        }
    }

    public int getCount(){
        return lottos.size();
    }

    public List<Lotto> get(){
        return Collections.unmodifiableList(lottos);
    }
}
