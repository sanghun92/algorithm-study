package com.study.bfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 게임_맵_최단거리Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 게임_맵_최단거리_테스트(int[][] maps, int expected) {
        게임_맵_최단거리 solution = new 게임_맵_최단거리();
        int answer = solution.solution(maps);
        assertEquals(answer, expected);
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}, 11),
                Arguments.of(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}, -1)
        );
    }
}

