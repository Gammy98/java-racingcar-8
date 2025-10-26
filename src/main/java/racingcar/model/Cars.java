package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String inputNames) {
        this.cars = parseCarNames(inputNames);
    }

    private List<Car> parseCarNames(String inputNames) {
        //쉼표로 구분짓고 좌우 공백제거후 car객체 생성후 List로 수집
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars(){
        return cars;
    }
}
