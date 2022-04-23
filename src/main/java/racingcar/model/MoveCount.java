package racingcar.model;

// TODO: 위치 이상함
public class MoveCount {
    private final int moveCount;

    private MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    // TODO: 명확한 예외 처리
    public static MoveCount fromString(String input) {
        final int count = Integer.parseInt(input);
        return new MoveCount(count);
    }

    public int get() {
        return moveCount;
    }
}
