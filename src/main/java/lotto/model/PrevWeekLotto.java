package lotto.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrevWeekLotto {

    private static final String COMMA = ",";
    private static final int SIX = 6;
    private static final int MINIMUM_MATCH_COUNT = 3;
    private final List<Integer> numbers;

    public PrevWeekLotto(final String line) {

        nullCheck(line);
        lottoSizeCheck(line);

        numbers = Arrays.stream(line.split(COMMA))
                .map(Integer::new)
                .collect(Collectors.toList());
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

    public boolean isPrize(final List<Integer> myNumbers){

        final long matchCount = myNumbers.stream().filter(numbers::contains).count();

        return matchCount >= MINIMUM_MATCH_COUNT;
    }
}
