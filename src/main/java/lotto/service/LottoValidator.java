package lotto.service;

import lotto.exception.LottoCreateException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;

import static lotto.Constants.*;

public class LottoValidator {

    public static void checkNull(final String line) {
        if(StringUtils.isEmpty(line)) {
            throw new LottoCreateException("당첨번호는 널 또는 공백이 입력되면 안됩니다.");
        }
    }

    public static void checkBonusNumber(final Integer bonusNumber){
        assert bonusNumber != null;
        if(bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new LottoCreateException("보너스번호는 로또 범위를 벗어났습니다.");
        }
    }

    public static void checkNumbers(final List<Integer> numbers){
        assert numbers != null;

        if(numbers.size() != LOTTO_COUNT){
            throw new LottoCreateException("당첨번호는 여섯개의 숫자가 입력되어야 합니다.");
        }

        if(numbers.stream().anyMatch(number -> LOTTO_MIN_NUMBER > number || number > LOTTO_MAX_NUMBER)){
            throw new LottoCreateException("당첨번호는 로또 범위를 벗어났습니다.");
        }

        if(new HashSet<>(numbers).size() != LOTTO_COUNT){
            throw new LottoCreateException("당첨번호는 서로 다른 숫자가 입력되어야 합니다.");
        }
    }

    public static void checkOverlap(final List<Integer> numbers, final Integer bonusNumber){
        assert numbers != null;
        assert bonusNumber != null;
        if(new HashSet<>(numbers).contains(bonusNumber)){
            throw new LottoCreateException("당첨번호는 보너스 번호를 포함해서는 안됩니다.");
        }
    }
}
