package racingcar.model;

// TODO: 클래스명이 이상해
public final class MoveCondition {

    public Move checkBy(int condition) {
        final int FORWARD = 4;
        if (condition >= FORWARD) {
            return Move.FORWARD;
        }
        return Move.STOP;
    }
}
