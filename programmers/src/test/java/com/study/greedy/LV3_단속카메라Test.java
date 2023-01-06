package com.study.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class LV3_단속카메라Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 단속카메라_테스트(int[][] routes, int expected) {
        LV3_단속카메라 solution = new LV3_단속카메라();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(routes));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    //print(solution({{-2,-1}, {1,2},{-3,0}})) #2
    //print(solution({{0,0},})) #1
    //print(solution({{0,1}, {0,1}, {1,2}})) #1
    //print(solution({{0,1}, {2,3}, {4,5}, {6,7}})) #4
    //print(solution({{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}})) #2
    //print(solution({{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}})) #2
    //print(solution({{-20,15}, {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}})) #2
    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}, 2),
                Arguments.of(new int[][]{{-2,-1}, {1,2},{-3,0}}, 2),
                Arguments.of(new int[][]{{0,0}}, 1),
                Arguments.of(new int[][]{{0,1}, {2,3}, {4,5}, {6,7}}, 4),
                Arguments.of(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}, 2),
                Arguments.of(new int[][]{{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}, 2),
                Arguments.of(new int[][]{{-20,15}, {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}, 2),
                Arguments.of(new int[][]{{-191, -107}, {-184, -151}, {-150, -102}, {-171, -124}, {-120, -114}}, 2),
                Arguments.of(new int[][]{{-30000, -107}, {-184, -151}, {-150, -102}, {-171, -124}, {-120, -30000}}, 3)
        );
    }
}
