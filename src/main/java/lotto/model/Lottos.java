package lotto.model;

import lotto.service.LottoResultAdapter;
import lotto.middleware.LottoAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(final int count){
        countCheck(count);
        IntStream.rangeClosed(1, count)
                .forEach(i -> lottos.add(Lotto.create()));
    }

    public static Lottos create(final int count){
        return new Lottos(count);
    }

    private void countCheck(final int count) {
        if(count <= 0) {
            throw new IllegalArgumentException("로또를 생성할 수 없습니다.");
        }
    }

    public int getCount(){
        return lottos.size();
    }

    public LottoAdapter getLottoAdapter(){
        return new LottoAdapter(lottos);
    }

    public List<LottoResultAdapter> getResultLottery(final WinningLotto winningLotto){

        this.nullCheck(winningLotto);

        return lottos.stream()
                .map(lotto -> winningLotto.getWinnerLotto(lotto.getNumbers()))
                .collect(Collectors.toList());
    }

    private void nullCheck(final WinningLotto winningLotto) {
        if(winningLotto == null){
            throw new NullPointerException("지난주 로또 번호가 널로 입력되었습니다.");
        }
    }
}
