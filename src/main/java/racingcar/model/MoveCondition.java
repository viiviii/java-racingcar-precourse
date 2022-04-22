package racingcar.model;

// TODO: 클래스명이 이상해
public final class MoveCondition {
    public static final int MIN_FORWARD_CONDITION = 4;
    public static final int MAX_STOP_CONDITION = MIN_FORWARD_CONDITION - 1;

    private final int condition;

    public MoveCondition(int condition) {
        this.condition = condition;
    }

    public boolean isForward() {
        return condition >= MIN_FORWARD_CONDITION;
    }

    public boolean isStop() {
        return !isForward();
    }
}
