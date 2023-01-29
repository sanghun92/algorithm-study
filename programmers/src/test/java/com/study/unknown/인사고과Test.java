package com.study.unknown;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 인사고과Test {

    @ParameterizedTest
    @MethodSource(value = "source")
    void 인사고과_test(int[][] scores, int expected) {
        인사고과 인사고과 = new 인사고과();

        int answer = 인사고과.solution(scores);

        assertThat(answer).isEqualTo(expected);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}, 4),
                Arguments.of(new int[][]{{1, 1}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}, -1),
                Arguments.of(new int[][]{{4, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}, 1)
        );
    }
}
