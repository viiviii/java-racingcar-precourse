package racingcar.model;

// TODO: RacingPace, MoveCondidtion 이상함
public class RacingPace {

    public static String racingPace(ForwardCount forwardCount) {
        final String ONE_STEP = "-";
        String result = "";
        for (int i = 0; i < forwardCount.get(); i++) {
            result += ONE_STEP;
        }
        return result;
    }
}
