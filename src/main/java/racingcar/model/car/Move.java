package racingcar.model.car;

enum Move {
    FORWARD, STOP;

    boolean isForward() {
        return this == FORWARD;
    }

    boolean isStop() {
        return this == STOP;
    }
}
