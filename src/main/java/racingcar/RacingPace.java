package racingcar;

// TODO: RacingPace, MoveCondidtion 이상함
public class RacingPace {

    public static String racingPace(int forwardCount) {
        final String ONE_STEP = "-";
        String result = "";
        for (int i = 0; i < forwardCount; i++) {
            result += ONE_STEP;
        }
        return result;
    }
}
