package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT_HEADER = "\n실행결과";
    private static final String POSITION_BAR = "-";
    private static final String CAR_NAME_SEPARATOR = " : ";
    private static final String WINNER_HEADER = "최종 우승자 : ";
    private static final String WINNER_NAME_SEPARATOR=", ";

    public void printExecutionResultHeader(){
        System.out.println(EXECUTION_RESULT_HEADER);
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()){
            System.out.println(buildCarPosition(car));
        }
        System.out.println();
    }

    private String buildCarPosition(Car car) {
        String positions = POSITION_BAR.repeat(car.getPosition());
        return car.getName() + CAR_NAME_SEPARATOR + positions;
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(WINNER_NAME_SEPARATOR , winners);
        System.out.println(WINNER_HEADER + winnerNames);
    }
}
