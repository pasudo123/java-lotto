package lotto.model;

import lotto.type.GenerateType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("내가 구매한 로또 유형은")
class BuyingTypeTest {

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "10, 10",
        "15, 15"
    })
    @DisplayName("수동로또만 구매한 유형이다.")
    public void createBuyingPassiveTypeTest(final int totalCount, final int passiveCount){

        // when
        final BuyingType buyingType = BuyingType.createBuyingTypeByCounts(totalCount, passiveCount);

        // then
        assertThat(buyingType.getGenerateType()).isEqualTo(GenerateType.PASSIVE);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0",
        "10, 0",
        "15, 0"

    })
    @DisplayName("랜덤로또만 구매한 유형이다.")
    public void createBuyingRandomTypeTest(final int totalCount, final int passiveCount) {

        // when
        final BuyingType buyingType = BuyingType.createBuyingTypeByCounts(totalCount, passiveCount);

        // then
        assertThat(buyingType.getGenerateType()).isEqualTo(GenerateType.RANDOM);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1",
        "10, 5",
        "15, 8"
    })
    @DisplayName("수동과 랜덤로또 둘 다 구매한 유형이다.")
    public void createBuyingBothTypeTest(final int totalCount, final int passiveCount) {

        // when
        final BuyingType buyingType = BuyingType.createBuyingTypeByCounts(totalCount, passiveCount);

        // then
        assertThat(buyingType.getGenerateType()).isEqualTo(GenerateType.BOTH);
    }
}