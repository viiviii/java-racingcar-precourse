package racingcar;

public class Car {

    public static final String run(int i) {
        if(i < 4) {
            return "멈춤";
        }
        return "전진";
    }
}
