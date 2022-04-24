package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // TODO: 여러개 되면 names로 변경
    public String inputCarName() {
        print("경주할 자동차 이름을 입력하세요.");
        return input();
    }

    public String inputMoveCount() {
        print("시도할 회수는 몇회인가요?");
        return input();
    }

    private String input() {
        return Console.readLine();
    }

    private void print(String message) {
        System.out.println(message);
    }
}
