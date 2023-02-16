package com.study.unknown;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 표병합Test {

    @ParameterizedTest
    @MethodSource(value = "source")
    void 표병합_test(String[] commands, String[] expected) {
        표병합 solution = new 표병합();

        String[] answer = solution.solution(commands);

        assertThat(answer.length).isEqualTo(expected.length);
        for(int i=0; i < answer.length; i++) {
            assertThat(answer[i]).isEqualTo(expected[i]);
        }
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"}, new String[]{"EMPTY", "group"}),
                Arguments.of(new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"}, new String[]{"d", "EMPTY"})
        );
    }
}
