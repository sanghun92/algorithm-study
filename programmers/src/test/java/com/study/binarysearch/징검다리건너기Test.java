package com.study.binarysearch;

import com.study.binarysearch.징검다리건너기;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 징검다리건너기Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 징검다리건너기_테스트(int[] stones, int k, int expected) {
        징검다리건너기 solution = new 징검다리건너기();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(stones, k));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3, 3)
        );
    }
}
