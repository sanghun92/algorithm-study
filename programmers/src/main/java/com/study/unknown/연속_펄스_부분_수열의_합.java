package com.study.unknown;

public class 연속_펄스_부분_수열의_합 {

    public static void main(String[] args) {
        연속_펄스_부분_수열의_합 solution = new 연속_펄스_부분_수열의_합();
        solution.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4});
    }

    public long solution(int[] sequence) {
        long[] preSumPlus = new long[sequence.length + 1];
        long[] preSumMinus = new long[sequence.length + 1];

        int pm = 1, plusSum = 0, minusSum = 0;
        for(int i=0; i < sequence.length; i++) {
            plusSum += sequence[i] * pm;
            preSumPlus[i + 1] = plusSum;
            pm *= -1;
            minusSum += sequence[i] * pm;
            preSumMinus[i + 1] = minusSum;
        }

        Long result = Long.MIN_VALUE;
        result = getResult(sequence, preSumPlus, result);
        result = getResult(sequence, preSumMinus, result);
        return result;
    }

    private Long getResult(int[] sequence, long[] preSum, long result) {
        int low = 0;
        int high = 1;
        while(high <= sequence.length) {
            long sum = preSum[high] - preSum[low];
            if(sum >= 0L) {
                result = Math.max(result, sum);
                high++;
            } else {
                low = high;
                high++;
            }
        }

        return result;
    }
}
