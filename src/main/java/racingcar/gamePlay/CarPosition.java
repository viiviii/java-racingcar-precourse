package racingcar.gamePlay;

import java.util.Objects;

public final class CarPosition {
    private final String carName;
    private final int position;

    public CarPosition(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String carName() {
        return carName;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarPosition)) return false;
        CarPosition result = (CarPosition) o;
        return position == result.position && carName.equals(result.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
