package util;

import bridge.domain.generator.BridgeNumberGenerator;
import java.util.List;

public class FakeNumberGenerator implements BridgeNumberGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public FakeNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        if (index >= numbers.size()) {
            index = 0;
        }
        return numbers.get(index++);
    }
}
