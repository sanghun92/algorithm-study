package com.study.unknown;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 보석쇼핑Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 보석쇼핑_테스트(String[] gems, int[] expected) {
        보석쇼핑 solution = new 보석쇼핑();
        AtomicIntegerArray answer = new AtomicIntegerArray(new int[expected.length]);
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    int[] solution1 = solution.solution(gems);
                    for(int i=0; i < solution1.length; i++) {
                        answer.set(i, solution1[i]);
                    }
                }),
                () ->  {
                    for(int i=0; i < expected.length; i++) {
                        assertThat(answer.get(i)).isEqualTo(expected[i]);
                    }
                }
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}, new int[]{3, 7}),
                Arguments.of(new String[]{"AA", "AB", "AC", "AA", "AC"}, new int[]{1, 3}),
                Arguments.of(new String[]{"XYZ", "XYZ", "XYZ"}, new int[]{1, 1}),
                Arguments.of(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}, new int[]{1, 5})
        );
    }
}
