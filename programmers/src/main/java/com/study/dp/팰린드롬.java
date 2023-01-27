package com.study.dp;

public class 팰린드롬 {

    public int solution(String s) {
        int answer = -1;

        char[] texts = s.toCharArray();
        for(int i = texts.length; i >= 0; i--) {
            for(int j=0; j + i < texts.length; j++) {
                boolean isPel = true;
                int front = j;
                int back = j + i;

                while(front < back) {
                    if(texts[front] != texts[back]) {
                        isPel = false;
                        break;
                    }

                    front++;
                    back--;
                }

                if(isPel) {
                    return i + 1;
                }
            }
        }

        return answer;
    }
}
