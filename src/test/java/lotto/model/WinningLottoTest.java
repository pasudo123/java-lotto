package lotto.model;

import lotto.exception.LottoCreateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("지난주 당첨 번호는")
class WinningLottoTest {


    @ParameterizedTest(name = "[{0}] 번호 입력, 보너스 번호[{1}]")
    @CsvSource({
        "'1, 2, 3, 4, 5, 6', 8",
        "'10, 20, 30, 40, 45, 5', 33"
    })
    @DisplayName("정상적으로 생성되었습니다.")
    void constructorTest(final String line, final Integer bonusNumber) {

        // when
        final WinningLotto winningLotto = new WinningLotto(line, bonusNumber);

        // then
        assertNotNull(winningLotto);
    }

    @ParameterizedTest(name = "[{0}] 입력")
    @NullAndEmptySource
    @DisplayName("널 또는 공백이 입력되어서 에러가 발생하였습니다.")
    void constructorNullAndEmptyExceptionTest(final String line) {
        assertThrows(LottoCreateException.class, () -> new WinningLotto(line, 5));
    }

    @ParameterizedTest(name = "[{0}] + [{1}] -> {2}개")
    @CsvSource({
        "'1, 2, 3, 4, 5, 6, 7', 9, 8",
        "'1, 2, 3, 4, 5, 6, 8', 9, 8",
        "'1, 2, 3, 4, 5, 6, 9', 10, 8",
        "'1, 2, 3, 4, 5, 6, 10', 11, 8",
    })
    @DisplayName("더 많은 로또번호 개수가 입력되어서 에러가 발생하였습니다.")
    void constructorLottoSizeExceptionTest(final String line, final Integer bonusNumber, final Integer size) {
       assertThrows(LottoCreateException.class, () -> new WinningLotto(line, bonusNumber));
    }

    @ParameterizedTest(name = "[{0}] 입력, 보너스 번호[{1}], {2} 발견")
    @CsvSource({
        "'1, 2, 3, 4, 5, 46', 7, 46",
        "'0, 1, 2 ,3, 4, 5', 7, 0",
        "'-1, 1, 2 ,3, 4, 5', 7, -1"
    })
    @DisplayName("로또번호의 범위를 벗어났기 때문에 에러가 발생하였습니다.")

    void constructorLottoRangeExceptionTest(final String line, final Integer bonusNumber, final Integer notLottoNumber) {
        assertThrows(LottoCreateException.class, () -> new WinningLotto(line, bonusNumber));
    }

    @ParameterizedTest(name = "[{0}] 입력, 보너스 번호[{1}], {1} 중복")
    @CsvSource({
        "'1, 1, 2, 3, 4, 5', 10, 1",
        "'1, 2, 2, 3, 4, 5', 10, 2",
        "'8, 11, 2, 3, 8, 1', 10, 8"
    })
    @DisplayName("로또번호에 동일한 숫자가 입력되었기 때문에 에러가 발생하였습니다.")
    void constructorOverlapExceptionTest(final String line, final Integer bonusNumber, final Integer overlapNumber){
        assertThrows(LottoCreateException.class, () -> new WinningLotto(line, bonusNumber));
    }

    @ParameterizedTest(name = "보너스 번호[{1}] 입력이후 에러발생")
    @CsvSource({
        "'1, 2, 3, 4, 5, 6', 0",
        "'1, 2, 3, 4, 5, 6', -1",
        "'1, 2, 3, 4, 5, 6', 46"
    })
    @DisplayName("보너스 번호가 로또 범위를 벗어났기 때문에 에러가 발생하였습니다.")
    void constructorBonusNumberNegativeExceptionTest(final String line, final Integer bonusNumber){
        assertThrows(LottoCreateException.class, () -> new WinningLotto(line, bonusNumber));
    }

    @ParameterizedTest(name = "[{0}] 입력, 보너스 번호[{1}] -> {2} 번호 일치")
    @CsvSource({
        "'1, 2, 3, 4, 5, 6', 1, 1",
        "'1, 2, 3, 4, 5, 6', 2, 2",
        "'1, 2, 3, 4, 5, 6', 3, 3"
    })
    @DisplayName("로또 번호와 보너스 번호가 중복되기 때문에 에러가 발생하였습니다.")
    void constructorBonumNumberOverlapExceptionTest(final String line, final Integer bonusNumber, final Integer overlapNumber) {
        assertThrows(LottoCreateException.class, () -> new WinningLotto(line, bonusNumber));
    }
}
