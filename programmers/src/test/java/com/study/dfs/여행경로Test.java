package com.study.dfs;

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

class 여행경로Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 여행경로_테스트(String[][] tickets, String[] expected) {
        여행경로 solution = new 여행경로();
        AtomicReferenceArray<String> answer = new AtomicReferenceArray<>(expected.length);
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    String[] answers = solution.solution(tickets);
                    for(int i=0; i < answers.length; i++) {
                        answer.set(i, answers[i]);
                    }
                }),
                () -> assertThat(answer).containsAll(Arrays.asList(expected))
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}, new String[]{"ICN", "JFK", "HND", "IAD"}),
                Arguments.of(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}, new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"})
        );
    }
}
