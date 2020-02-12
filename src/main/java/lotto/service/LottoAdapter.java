package lotto.service;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LottoAdapter {

    private static final String COMMA = ", ";
    private static final String OpenBracket = "[";
    private static final String CloseBracket = "]";
    private static final String NEW_LINE = "\n";

    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoAdapter(final List<Lotto> lottoList){
        this.nullOrSizeZeroCheck(lottoList);
        this.lottoList.addAll(lottoList);
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }

    public int getLottoCount(){
        return lottoList.size();
    }

    public String getConsoleLottos(){

        final StringBuilder sb = new StringBuilder();

        for(Lotto lotto : lottoList) {

            final StringJoiner joiner = new StringJoiner(COMMA, OpenBracket, CloseBracket);
            final int[] numbers = lotto.getNumbers();

            for(int number : numbers) {
                joiner.add(String.valueOf(number));
            }

            sb.append(joiner.toString());
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }

    private void nullOrSizeZeroCheck(final List<Lotto> lottoList) {
        if(lottoList == null || lottoList.size() == 0) {
            throw new IllegalArgumentException("현재 내가 구입한 로또가 없습니다.");
        }
    }
}
