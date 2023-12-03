package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.generator.BridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.FakeNumberGenerator;

class BridgeMakerTest {
    @Test
    void 길이에_따른_다리를_생성한다() {
        BridgeNumberGenerator fakeNumberGenerator = new FakeNumberGenerator(List.of(0, 0, 1, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(fakeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).isEqualTo(List.of("D", "D", "U", "U", "D"));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 15, 19})
    void 길이가_3이상_20이하인_경우_다리를_생성한다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker();
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge).hasSize(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 21, 100})
    void 길이가_3미만_20초과인_경우_예외를_발생한다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker();
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}