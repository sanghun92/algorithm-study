package com.study.unknown;

import java.util.Arrays;

public class 인사고과 {

    public int solution(int[][] scores) {
        int answer = 1;
        int[] source = scores[0];
        int sourceSum = source[0] + source[1];
        int maxScore = 0;
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (int[] score : scores) {
            if (score[1] < maxScore) {
                if (score == source) {
                    return -1;
                }
            } else {
                maxScore = Math.max(maxScore, score[1]);

                if (score[0] + score[1] > sourceSum) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
