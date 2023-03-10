package com.study.dfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 단어_변환Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 단어_변환_테스트(String begin, String target, String[] words, int expected) {
        단어_변환 solution = new 단어_변환();
        int answer = solution.solution(begin, target, words);
        assertThat(answer).isEqualTo(expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}, 4)
        );
    }
}
