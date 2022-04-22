package racingcar.model;

public final class Distance {

    public static String from(Position position) {
        final String ONE_STEP = "-";
        String result = "";
        for (int i = 0; i < position.get(); i++) {
            result += ONE_STEP;
        }
        return result;
    }
}
