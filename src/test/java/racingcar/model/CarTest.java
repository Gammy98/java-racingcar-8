package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("성공적으로 생성")
    void create_car_success(){
        String validName = "pobi";

        assertThatCode(() -> new Car(validName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과했습니다")
    void create_car_fail_exceed5(){
        String longName = "pobipobi";

        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR : 자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @DisplayName("자동차 이름이 비어있거나 공백입니다")
    void create_car_fail_isblank(String blankName) {
        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ERROR : 자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("자동차는 생성 시 위치가 0에서 시작")
    void car_initial_position(){
        Car car = new Car("Pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("입력값이 4 이상일 경우 자동차는 1칸 전진한다.")
    void car_moves_if_number_is_4_or_more(int number) {
        Car car = new Car("pobi");
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("입력값이 4 미만일 경우 자동차는 멈춘다.")
    void car_stops_if_number_is_3_or_less(int number) {
        Car car = new Car("pobi");
        car.move(number); // <-- 숫자를 직접 주입
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
