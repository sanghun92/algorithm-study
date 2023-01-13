package com.study.dp;

public class 스티커모으기2 {

    public int solution(int sticker[]) {
        int length = sticker.length;
        if(length == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[length];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for(int i=2; i < length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        int[] dp2 = new int[length];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i=2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        return Math.max(dp1[length - 2], dp2[length - 1]);
    }
}
