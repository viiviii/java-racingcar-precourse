package racingcar.model;

public class MoveResult {
    private final ForwardCount forwardCount;

    public MoveResult(ForwardCount forwardCount) {
        this.forwardCount = forwardCount;
    }

    public ForwardCount forwardCount() {
        return forwardCount;
    }
}
