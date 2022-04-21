package racingcar;

// TODO: RacingPace, MoveCondidtion 이상함
public class RacingPace {

    public static String racingPace(MoveCondition moveCondition) {
        final String FORWARD = "-";
        final String STOP = "";
        if (moveCondition.isStop()) {
            return STOP;
        }
        return FORWARD;
    }
}
