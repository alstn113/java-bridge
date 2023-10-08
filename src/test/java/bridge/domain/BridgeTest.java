package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bridge 클래스")
class BridgeTest {

    @Test
    @DisplayName("Bridge 인스턴스 생성 여부 테스트")
    void createBridge() {
        // given
        int length = 5;

        // when
        Bridge bridge = new Bridge(length);

        // then
        System.out.println(bridge);
    }
}
