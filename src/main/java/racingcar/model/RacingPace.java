package racingcar.model;

// TODO: RacingPace, MoveCondidtion 이상함
public class RacingPace {

    public static String racingPace(Position position) {
        final String ONE_STEP = "-";
        String result = "";
        for (int i = 0; i < position.get(); i++) {
            result += ONE_STEP;
        }
        return result;
    }
}
