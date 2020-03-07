//package lotto.type;
//
//import lotto.Won;
//import lotto.model.BuyingPocket;
//import lotto.model.Lottos;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DisplayName("로또 생성 유형은")
//class GenerateTypeTest {
//
//    @ParameterizedTest
//    @MethodSource("providePocketWillReturnRandomTypeLotto")
//    @DisplayName("랜덤유형으로 로또를 생성한다.")
//    void generateRandomLottosTest(final BuyingPocket pocket, final int expectedLottoCounts) {
//        // when
//        final Lottos lottos = GenerateType.RANDOM.generateLottos(pocket);
//
//        // then
//        assertThat(lottos.getCount()).isEqualTo(expectedLottoCounts);
//    }
//
//    @ParameterizedTest
//    @MethodSource("providePocketWillReturnPassiveTypeLotto")
//    @DisplayName("수동유형으로 로또를 생성한다.")
//    void generatePassiveLottosTest(final BuyingPocket pocket, final int expectedLottoCounts){
//        // when
//        final Lottos lottos = GenerateType.MANUAL.generateLottos(pocket);
//
//        // then
//        assertThat(lottos.getCount()).isEqualTo(expectedLottoCounts);
//    }
//
//    @ParameterizedTest
//    @MethodSource("providePocketWillReturnBothTypeLotto")
//    @DisplayName("랜덤과 수동유형으로 로또를 생성한다.")
//    void generateBothLottosTest(final BuyingPocket pocket, final int expectedLottoCounts) {
//        // when
//        final Lottos lottos = GenerateType.BOTH.generateLottos(pocket);
//
//        // then
//        assertThat(lottos.getCount()).isEqualTo(expectedLottoCounts);
//    }
//
//    static Stream<Arguments> providePocketWillReturnRandomTypeLotto() {
//        return Stream.of(
//                Arguments.of(BuyingPocket.of(Won.from(5000), Collections.EMPTY_LIST), 5),
//                Arguments.of(BuyingPocket.of(Won.from(10000), Collections.EMPTY_LIST), 10)
//        );
//    }
//
//    static Stream<Arguments> providePocketWillReturnPassiveTypeLotto() {
//        return Stream.of(
//                Arguments.of(BuyingPocket.of(Won.from(1000), Collections.singletonList("1, 2, 3, 4, 5, 6")), 1)
//        );
//    }
//
//    static Stream<Arguments> providePocketWillReturnBothTypeLotto() {
//        return Stream.of(
//                Arguments.of(BuyingPocket.of(Won.from(5000), Collections.singletonList("1, 2, 3, 4, 5, 6")), 5),
//                Arguments.of(BuyingPocket.of(Won.from(10000), Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7")), 10)
//        );
//    }
//}