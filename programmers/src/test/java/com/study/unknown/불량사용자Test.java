package com.study.unknown;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 불량사용자Test {

    @ParameterizedTest
    @MethodSource(value = "arguments")
    void 불량사용자_테스트(String[] user_id, String[] banned_id, int expected) {
        불량사용자 solution = new 불량사용자();
        AtomicInteger answer = new AtomicInteger();
        assertAll(
                () -> assertTimeout(Duration.ofMillis(3000), () -> {
                    answer.set(solution.solution(user_id, banned_id));
                }),
                () -> assertThat(answer.get()).isEqualTo(expected)
        );
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
//                Arguments.of(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}, 2),
//                Arguments.of(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}, 2),
                Arguments.of(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}, 3)
//                Arguments.of(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"**", "", "", "", "***"}, 1)
//                Arguments.of(new String[]{"abcde", "accde", "adcde", "aecde"}, new String[]{"ace", "ace", "***de"}, 4)
        );
    }
}
