package racingcar;

public class RacingPace {

    public static String racingPace(MoveCondition moveCondition) {
        if (moveCondition.isStop()) {
            return "";
        }
        return "-";
    }
}
