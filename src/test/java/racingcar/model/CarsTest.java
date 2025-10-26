package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("쉽표로 구분된 문자열로 Cars객채를 성공적으로 생성")
    void create_cars_success(){
        String input = "pobi,woni,jun";

        Cars cars = new Cars(input);

        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("pobi");
        assertThat(carList.get(1).getName()).isEqualTo("woni");
        assertThat(carList.get(2).getName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("자동차 이름 중 5자를 초과하는 이름이 있으면 예외 발생")
    void create_cars_fail_exceed5(){
        String inputInvalidName = "pobi,woniwoni,woni";

        assertThatThrownBy(() -> new Cars(inputInvalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 중 공백 이름이 있으면 예외를 발생.")
    void create_cars_fail_isblank() {
        // given
        String inputWithBlankName = "pobi,,woni"; // 쉼표 사이에 이름이 없음

        // when & then
        assertThatThrownBy(() -> new Cars(inputWithBlankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어 있을 수 없습니다.");
    }
}
