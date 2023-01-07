package com.study.unknown;

import com.study.greedy.LV3_단속카메라;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 숫자게임Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 숫자게임_테스트(int[] a, int[] b, int expected) {
        숫자게임 solution = new 숫자게임();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(a, b));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{5,1,3,7}, new int[]{2,2,6,8}, 3),
                Arguments.of(new int[]{2,2,2,2}, new int[]{1,1,1,1}, 0)
        );
    }
}
