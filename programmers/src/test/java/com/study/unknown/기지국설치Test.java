package com.study.unknown;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 기지국설치Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 기지국설치_테스트(int N, int[] stations, int W, int expected) {
        기지국설치 solution = new 기지국설치();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(N, stations, W));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(11, new int[]{4, 11}, 1, 3),
                Arguments.of(16, new int[]{9}, 2, 3)
        );
    }
}
