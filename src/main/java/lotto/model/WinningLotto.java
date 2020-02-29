package lotto.model;

import lotto.service.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class WinningLotto {

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
        LottoValidator.checkNull(line);
        LottoValidator.checkBonusNumber(bonusNumber);
    }

    private void postValidateCheck(){
        LottoValidator.checkNumbers(numbers);
        LottoValidator.checkOverlap(numbers, bonusNumber);
    }

    private void initNumbers(final String line){
        numbers = Arrays.stream(line.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void initBonusNumber(final Integer bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public RankResults getRankResults(final Lottos lottos) {
        return new RankResults(lottos.get().stream()
                .map(lotto -> lotto.toRankResult(numbers, bonusNumber))
                .collect(Collectors.toList()));
    }
}
