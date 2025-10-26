package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT = "시도할 횟수는 몇 회인가요?";

    public static String readCarName(){
        System.out.println(CAR_NAME_INPUT);
        return Console.readLine();
    }

    public static String readTryCount(){
        System.out.println(TRY_COUNT_INPUT);
        return Console.readLine();
    }
}
