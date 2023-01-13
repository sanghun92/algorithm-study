package com.study.dp;

import com.study.greedy.LV3_단속카메라;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 스티커모으기2Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 단속카메라_테스트(int sticker[], int expected) {
        스티커모으기2 solution = new 스티커모으기2();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(sticker));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[] {14, 6, 5, 11, 3, 9, 2, 10}, 36),
                Arguments.of(new int[] {1, 3, 2, 5, 4}, 8)
        );
    }
}
