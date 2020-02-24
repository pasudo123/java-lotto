package lotto.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class WinningLotto {

    private static final String WHITE_SPACE = "\\s";
    private static final String SPACE = "";
    private static final String COMMA = ",";

    private List<Integer> numbers;
    private Integer bonusNumber;

    public WinningLotto(final String line, final Integer bonusNumber) {

        preValidateCheck(line, bonusNumber);

        final String newLine = line.replaceAll(WHITE_SPACE, SPACE);
        initNumbers(newLine);
        initBonusNumber(bonusNumber);

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

    private void initNumbers(final String line){
        numbers = Arrays.stream(line.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void initBonusNumber(final Integer bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    /**
     * 지난주 당첨 번호와 보너스 번호를 통해서, 내 로또 번호들의 결과를 반환.
     */
    public List<LottoRankResult> getResultByMine(final Lottos lottos) {

        final List<LottoRankResult> lottoRankResults = new ArrayList<>();

        final List<Lotto> myLottoList = lottos.get();

        for(Lotto lotto : myLottoList){
            final int matchCount = lotto.getMatchCountByWinningNumbers(numbers);
            final boolean isMatchBonus = lotto.isBonusMatch(bonusNumber);
            final List<Integer> myNumbers = lotto.getNumbers();

            lottoRankResults.add(new LottoRankResult(matchCount, isMatchBonus, myNumbers));
        }

        return lottoRankResults;
    }
}
