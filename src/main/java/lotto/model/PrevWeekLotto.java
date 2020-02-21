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
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final int LOTTO_COUNT = 6;

    private List<Integer> numbers;
    private Integer bonusNumber;

    public PrevWeekLotto(final String line, final Integer bonusNumber) {

        preValidateCheck(line, bonusNumber);

        final String newLine = line.replaceAll(WHITE_SPACE, SPACE);
        initNumbers(newLine);
        initBonumNumber(bonusNumber);

        postValidateCheck();
    }

    private void preValidateCheck(final String line, final Integer bonusNumber){
        checkNull(line);
        checkBonusNumber(bonusNumber);
    }

    private void postValidateCheck(){
        checkLottoSize();
        checkOverLottoNumberRange();
        checkOverlap();
    }

    private void initNumbers(final String line){
        numbers = Arrays.stream(line.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void initBonumNumber(final Integer bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    LottoResultAdapter getWinnerLotto(final List<Integer> myNumbers){

        final int matchCount = (int)myNumbers.stream()
                .filter(numbers::contains)
                .count();

        return new LottoResultAdapter(matchCount);
    }

    private void checkNull(final String line) {

        if(StringUtils.isEmpty(line)) {
            throw new IllegalArgumentException("지난 주 당첨 번호에 널 또는 공백이 입력되었습니다.");
        }
    }

    private void checkBonusNumber(final Integer bonusNumber){
        if(bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 로또 범위를 벗어났습니다.");
        }
    }

    private void checkLottoSize() {
        if(numbers.size() != LOTTO_COUNT){
            throw new IllegalArgumentException("지난 주 당첨 번호는 여섯개의 숫자가 입력되어야 합니다.");
        }
    }

    private void checkOverLottoNumberRange(){
        if(numbers.stream().anyMatch(number -> LOTTO_MIN_NUMBER > number || number > LOTTO_MAX_NUMBER)){
            throw new IllegalArgumentException("지난 주 당첨 번호는 로또 범위를 벗어났습니다.");
        }
    }

    private void checkOverlap(){

        final HashSet<Integer> numSets = new HashSet<>(numbers);

        if(numSets.size() != LOTTO_COUNT){
            throw new IllegalArgumentException("지난 주 당첨 번호에 동일한 숫자가 입력되었습니다.");
        }

        if(numSets.contains(bonusNumber)){
            throw new IllegalArgumentException("로또 번호안에 보너스 번호가 한개 더 있습니다. 확인해주시길 바랍니다.");
        }
    }
}
