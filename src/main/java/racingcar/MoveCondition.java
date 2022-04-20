package racingcar;

public final class MoveCondition {
    private final int condition;

    public MoveCondition(int condition) {
        this.condition = condition;
    }

    public boolean isMove() {
        final int MIN_MOVE_CONDITION = 4;
        return condition >= MIN_MOVE_CONDITION;
    }

    public boolean isStop() {
        return !isMove();
    }
}
