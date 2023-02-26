package com.study.unknown;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class 억억단을_외우자Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 억억단을_외우자_test(int e, int[] starts, int[] expected) {
        억억단을_외우자 solution = new 억억단을_외우자();
        AtomicReferenceArray<Integer> answer = new AtomicReferenceArray<>(expected.length);
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    int[] result = solution.solution(e, starts);
                    for(int i=0; i < result.length; i++) {
                        answer.set(i, result[i]);
                    }
                }),
                () -> assertThat(answer).containsAll(Arrays.stream(expected).boxed().toList())
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(8, new int[]{1,3,7}, new int[]{6,6,8})
        );
    }
}
