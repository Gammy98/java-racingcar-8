package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("자동차 1대가 가장 앞에 있는 경우 이름 반환")
    void single_winner(){
        Cars cars = new Cars("pobi,woni,jun");
        List<Car> carList = cars.getCars();

        carList.get(0).move(5);
        carList.get(0).move(6);
        carList.get(1).move(3);
        carList.get(2).move(2);

        List<String> winners = cars.findWinners();
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("자동차 여러대가 같은 거리만큼 이동한 경우 공동우승처리 하고 이름 모두 반환")
    void many_winner(){
        Cars cars = new Cars("pobi,woni,jun");
        List<Car> carList = cars.getCars();

        carList.get(0).move(2);
        carList.get(0).move(5);
        carList.get(1).move(2);
        carList.get(2).move(5);
        carList.get(2).move(3);

        List<String> winners = cars.findWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}
