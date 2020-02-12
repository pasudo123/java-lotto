package lotto.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrevWeekLotto {

    private static final String COMMA = ",";
    private static final int SIX = 6;
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
            throw new IllegalArgumentException("지난 주 당첨 번호에 여섯자리 숫자가 입력되지 않았습니다.");
        }
    }
}
