package bridge.domain;


import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("BridgeGame 클래스 테스트")
class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        BridgeNumberGenerator numberGenerator = new BridgeTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = new Bridge(3, bridgeMaker);
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    @DisplayName("move 메서드 테스트")
    void move() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        List<String> history = bridgeGame.getHistory();
        assertEquals("U", history.get(0));
        assertEquals("D", history.get(1));
        assertEquals("D", history.get(2));
    }

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
    @DisplayName("isFailed 메서드 테스트")
    class IsFailedMethodTest {


        @Test
        @DisplayName("isFailed 메서드 테스트 - not failed")
        void failed() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");

            assertEquals(false, bridgeGame.isFailed());
        }

        @Test
        @DisplayName("isFailed 메서드 테스트 - failed")
        void notFailed() {
            bridgeGame.move("D");

            assertEquals(true, bridgeGame.isFailed());
        }
    }

    @Nested
    @DisplayName("getTotalAttempts 메서드 테스트")
    class GetTotalAttemptsMethodTest {

        @Test
        @DisplayName("첫 시도로 클리어")
        void firstAttempt() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");

            assertEquals(1, bridgeGame.getTotalAttempts());
        }

        @Test
        @DisplayName("여러 시도로 클리어")
        void multipleAttempts() {
            bridgeGame.isRetry("R");
            bridgeGame.isRetry("R");

            assertEquals(3, bridgeGame.getTotalAttempts());
        }
    }

    @Nested
    @DisplayName("retry 메서드 테스트")
    class RetryMethodTest {

        @Test
        @DisplayName("retry 메서드 테스트")
        void retry() {
            bridgeGame.move("D");

            bridgeGame.retry();

            assertEquals(0, bridgeGame.getHistory().size());
            assertEquals(2, bridgeGame.getTotalAttempts());
            assertEquals(false, bridgeGame.isFailed());
        }

    }

}
