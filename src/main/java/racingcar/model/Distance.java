package racingcar.model;

public final class Distance {
    private static final String ONE_STEP = "-";

    private final String value;

    private Distance(String value) {
        this.value = value;
    }

    public static Distance from(Position position) {
        final String distance = appendStepToDistanceAs(position);
        return new Distance(distance);
    }

    private static String appendStepToDistanceAs(Position position) {
        final StringBuilder distance = new StringBuilder();
        for (int i = 0; i < position.get(); i++) {
            distance.append(ONE_STEP);
        }
        return distance.toString();
    }

    public String get() {
        return value;
    }
}
