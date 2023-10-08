package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertAll;


@DisplayName("Bridge 클래스")
class BridgeTest {

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

    @Nested
    @DisplayName("Bridge 생성 테스트")
    class BridgeConstructorTest {


        @Nested
        @DisplayName("Bridge 생성 테스트")
        class ConstructorTest {
            @Test
            @DisplayName("Bridge 생성 테스트-1")
            void constructorTest() {
                BridgeNumberGenerator numberGenerator = new BridgeTest.TestNumberGenerator(newArrayList(1, 0, 0));
                BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
                Bridge bridge = new Bridge(3, bridgeMaker);

                assertAll(
                        () -> assertThat(bridge.getLength()).isEqualTo(3),
                        () -> assertThat(bridge.getLayout()).containsExactly("U", "D", "D")
                );
            }

            @Test
            @DisplayName("Bridge 생성 테스트-2")
            void constructorTest2() {
                BridgeNumberGenerator numberGenerator = new BridgeTest.TestNumberGenerator(newArrayList(1, 0, 1, 1, 0));
                BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
                Bridge bridge = new Bridge(5, bridgeMaker);

                assertAll(
                        () -> assertThat(bridge.getLength()).isEqualTo(5),
                        () -> assertThat(bridge.getLayout()).containsExactly("U", "D", "U", "U", "D")
                );
            }
        }
    }

    @Nested
    @DisplayName("Bridge 범위 테스트")
    class BridgeRangeTest {

        @DisplayName("Bridge 3보다 작을 경우")
        @Test
        void bridgeRangeTest1() {
            assertThatThrownBy(() -> new Bridge(0)).isInstanceOf(InvalidInputException.class);
        }

        @DisplayName("Bridge 20보다 클 경우")
        @Test
        void bridgeRangeTest2() {
            assertThatThrownBy(() -> new Bridge(30)).isInstanceOf(InvalidInputException.class);
        }
    }
}
