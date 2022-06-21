package racingcar;

public interface RaceResult {
    int moveTimes();

    Record recordOf(int moveTime); // TODO: 이동시간이냐 이름이 뭐 이럼
}
