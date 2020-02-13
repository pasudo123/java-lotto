package lotto.model;

import lotto.service.LottoResultAdapter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrevWeekLotto {

    private static final String WHITE_SPACE = "\\s";
    private static final String SPACE = "";
    private static final String COMMA = ",";
    private static final int SIX = 6;
    private final List<Integer> numbers;

    public PrevWeekLotto(final String line) {

        nullCheck(line);
        lottoSizeCheck(line);

        final String newLine = removeWhiteSpace(line);

        numbers = Arrays.stream(newLine.split(COMMA))
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    private String removeWhiteSpace(final String line) {
        return line.replaceAll(WHITE_SPACE, SPACE);
    }

    private void nullCheck(final String line) {

        if(StringUtils.isEmpty(line)) {
            throw new IllegalArgumentException("지난 주 당첨 번호에 널 또는 공백이 입력되었습니다.");
        }
    }

    private void lottoSizeCheck(final String line) {

        if(line.split(COMMA).length != SIX){
            throw new IllegalArgumentException("지난 주 당첨 번호는 여섯개의 숫자가 입력되어야 합니다.");
        }
    }

    LottoResultAdapter getWinnerLotto(final List<Integer> myNumbers){

        final int matchCount = (int)myNumbers.stream()
                .filter(numbers::contains)
                .count();

        return new LottoResultAdapter(matchCount, myNumbers);
    }
}
