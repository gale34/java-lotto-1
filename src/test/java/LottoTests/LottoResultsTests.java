package LottoTests;

import lotto.model.LottoResult;
import lotto.model.LottoResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 테스트")
public class LottoResultsTests {

    @DisplayName("로또 수익률 테스트")
    @ParameterizedTest
    @MethodSource("profitTestCases")
    public void profitTest(LottoResults lottoResults, Double expectedProfit) {
        assertThat(lottoResults.profit()).isEqualTo(expectedProfit);
    }

    private static Stream<Arguments> profitTestCases() {
        return Stream.of(
                Arguments.of(LottoResults.create(Arrays.asList(LottoResult.SIX, LottoResult.THREE, LottoResult.FOUR, LottoResult.FIVE, LottoResult.TWO)), 400311.0),
                Arguments.of(LottoResults.create(Arrays.asList(LottoResult.ONE, LottoResult.NONE, LottoResult.FOUR, LottoResult.ONE, LottoResult.TWO)), 10.0),
                Arguments.of(LottoResults.create(Arrays.asList(LottoResult.FIVE, LottoResult.NONE, LottoResult.ONE)), 500.0),
                Arguments.of(LottoResults.create(
                        Arrays.asList(LottoResult.ONE, LottoResult.NONE, LottoResult.THREE, LottoResult.ONE, LottoResult.TWO,
                                LottoResult.ONE, LottoResult.NONE, LottoResult.NONE, LottoResult.ONE, LottoResult.TWO)), 0.5),
                Arguments.of(LottoResults.create(Collections.singletonList(LottoResult.ONE)), 0.0));
    }
}
