package com.study.binarysearch;

public class 징검다리건너기 {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1, max = Integer.MAX_VALUE;

        while(min <= max) {
            int mid = (min + max) / 2;
            if(isCrossable(stones, k, mid)) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }

    private boolean isCrossable(int[] stones, int k, int mid) {
        int skip = 0;
        for (int stone : stones) {
            if(stone - mid < 0) {
                skip++;
            } else {
                skip = 0;
            }

            if(skip == k) {
                return false;
            }
        }

        return true;
    }
}
