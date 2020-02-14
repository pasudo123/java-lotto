package lotto.model;

import lotto.service.LottoResultAdapter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PrevWeekLotto {

    private static final String WHITE_SPACE = "\\s";
    private static final String SPACE = "";
    private static final String COMMA = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final int SIX = 6;

    private List<Integer> numbers;

    public PrevWeekLotto(final String line) {

        checkNull(line);
        checkLottoSize(line);

        final String newLine = removeWhiteSpace(line);
        toNumbers(newLine);

        checkOverLottoNumberRange();
        checkOverlap();
    }

    private String removeWhiteSpace(final String line) {
        return line.replaceAll(WHITE_SPACE, SPACE);
    }

    private void checkNull(final String line) {

        if(StringUtils.isEmpty(line)) {
            throw new IllegalArgumentException("지난 주 당첨 번호에 널 또는 공백이 입력되었습니다.");
        }
    }

    private void checkLottoSize(final String line) {

        if(line.split(COMMA).length != SIX){
            throw new IllegalArgumentException("지난 주 당첨 번호는 여섯개의 숫자가 입력되어야 합니다.");
        }
    }

    private void checkOverLottoNumberRange(){
        if(numbers.stream().anyMatch(integer -> MIN_NUMBER > integer || integer > MAX_NUMBER)){
            throw new IllegalArgumentException("지난 주 당첨 번호는 로또 범위를 벗어났습니다.");
        }
    }

    private void checkOverlap(){
        if(new HashSet<>(numbers).size() != SIX){
            throw new IllegalArgumentException("지난 주 당첨 번호에 동일한 숫자가 입력되었습니다.");
        }
    }

    private void toNumbers(final String line){
        numbers = Arrays.stream(line.split(COMMA))
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    LottoResultAdapter getWinnerLotto(final List<Integer> myNumbers){

        final int matchCount = (int)myNumbers.stream()
                .filter(numbers::contains)
                .count();

        return new LottoResultAdapter(matchCount, myNumbers);
    }
}
