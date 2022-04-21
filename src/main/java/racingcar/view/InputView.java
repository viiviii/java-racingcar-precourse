package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // TODO: 여러개 되면 names로 변경
    public String inputCarName() {
        return input();
    }

    public String inputMoveCount() {
        return input();
    }

    private String input() {
        return Console.readLine();
    }
}
