package com.study.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class 가장먼노드Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 가장먼노드_테스트(int n, int[][] edge, int expected) {
        가장먼노드 solution = new 가장먼노드();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(n, edge));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}, 3)
        );
    }
}
