package wooteco.subway.maps.map.domain;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public enum DistanceFare {
    LONG(distance -> distance > 50, distance -> calculateFarePerUnit(distance, 50, 8)),
    MIDDLE(distance -> distance > 10, distance -> calculateFarePerUnit(distance, 10, 50, 5)),
    SHORT(distance -> distance > 0, distance -> 1_250);

    private static final int UNIT_FARE = 100;

    private final Predicate<Integer> match;
    private final UnaryOperator<Integer> calculator;

    DistanceFare(Predicate<Integer> match, UnaryOperator<Integer> calculator) {
        this.match = match;
        this.calculator = calculator;
    }

    public static int calculate(int distance) {
        return Arrays.stream(values())
                .filter(distanceFare -> distanceFare.match.test(distance))
                .mapToInt(distanceFare -> distanceFare.calculator.apply(distance))
                .sum();
    }

    private static int calculateFarePerUnit(int totalDistance, int deduceDistance, int unitDistance) {
        int calculatedDistance = totalDistance - deduceDistance;
        int unit = calculatedDistance / unitDistance;
        if (calculatedDistance * -unit * unitDistance > 0) {
            return unit * UNIT_FARE + 1;
        }
        return unit * UNIT_FARE;
    }

    private static int calculateFarePerUnit(int totalDistance, int deduceDistance, int maxDistance, int unitDistance) {
        int calculatedDistance = totalDistance - deduceDistance;
        if (calculatedDistance > maxDistance) {
            calculatedDistance = maxDistance;
        }
        int unit = calculatedDistance / unitDistance;
        if (calculatedDistance * -unit * unitDistance > 0) {
            return unit * UNIT_FARE + 1;
        }
        return unit * UNIT_FARE;
    }
}
