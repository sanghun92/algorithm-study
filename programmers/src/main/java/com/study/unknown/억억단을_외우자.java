package com.study.unknown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 억억단을_외우자 {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[][] store = new int[e+1][2];
        store[e][0] = getPrimeCount(e);
        store[e][1] = e;

        for(int i=e-1; i>=1; i--) {
            int cnt = getPrimeCount(i);

            // 최대 약수 갱신
            if(cnt >= store[i+1][0]){
                store[i][0] = cnt;
                store[i][1] = i;
            }else{
                store[i][0] = store[i+1][0];
                store[i][1] = store[i+1][1];
            }
        }

        for (int i = 0; i < starts.length; i++) {
            int star = starts[i];
            answer[i] = store[star][1];
        }

        return answer;
    }

    public int getPrimeCount(int n) {
        Map<Integer, Integer> primes = new HashMap<>();

        for(int i=2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                primes.put(i, primes.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        if(n != 1) {
            primes.put(n, primes.getOrDefault(n, 0) + 1);
        }

        int count = 1;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(primes.entrySet());
        for (Map.Entry<Integer, Integer> entry : list) {
            count *= (entry.getValue() + 1);
        }
        return count;
    }
}
