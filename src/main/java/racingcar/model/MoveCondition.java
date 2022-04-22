package racingcar.model;

// TODO: 클래스명이 이상해
public final class MoveCondition {
    public static final int FORWARD = 4;
    public static final int STOP = FORWARD - 1;

    private final int condition;

    public MoveCondition(int condition) {
        this.condition = condition;
    }

    public boolean isForward() {
        return condition >= FORWARD;
    }
}
