package com.study.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 팰린드롬Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 팰린드롬_테스트(String text, int expected) {
        팰린드롬 solution = new 팰린드롬();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(text));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("abcdcba", 7),
                Arguments.of("abacde", 3)
        );
    }
}
