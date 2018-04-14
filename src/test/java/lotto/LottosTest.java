package lotto;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottosTest {
    @Test
    public void 항목한개추가() {
        Lottos lottos = new Lottos();
        lottos.add( new Lotto("1, 2, 3, 4, 5, 6") );
        assertThat(lottos.getLottosCount()).isEqualTo(1);
    }

    @Test
    public void 랭킹맵초기화확인() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        lottos.add( lotto);
        WinLotto winLotto = new WinLotto(lotto, 15);
        Map<Rank,Integer> map = lottos.makeRankCountMap(winLotto);

        assertThat(map.size()).isEqualTo(6);
    }

    @Test
    public void 랭킴맵1등확인() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        lottos.add( lotto);
        WinLotto winLotto = new WinLotto(lotto, 15);
        Map<Rank,Integer> map = lottos.makeRankCountMap(winLotto);

        assertThat(map.get(Rank.FIRST)).isEqualTo(1);
    }
}
