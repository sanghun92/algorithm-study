package com.study.datastructure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class 표현_가능한_이진트리Test {

    @Test
    void 표현_가능한_이진트리_Test() {
        long[] numbers = {63, 111, 95, 96};
        int[] expected = {1, 1, 0, 0};
        표현_가능한_이진트리 solution = new 표현_가능한_이진트리();

        int[] answer = solution.solution(numbers);

        assertThat(answer).isEqualTo(expected);
    }
}
