package racingcar;

public class MoveCount {
    private final int count;

    private MoveCount(int count) {
        this.count = count;
    }

    public static MoveCount fromInteger(int count) {
        return new MoveCount(count);
    }

    // TODO: 명확한 예외 처리
    public static MoveCount fromString(String count) {
        int i = Integer.parseInt(count);
        return new MoveCount(i);
    }
}
