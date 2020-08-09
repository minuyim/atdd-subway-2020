package wooteco.subway.maps.map.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceFareTest {
    @CsvSource(value = {"10,1250", "20,1450", "50,2050", "58,2150"})
    @ParameterizedTest
    void calculate(int distance, int expected) {
        int calculate = DistanceFare.calculate(distance);
        assertThat(calculate).isEqualTo(expected);
    }
}