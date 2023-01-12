package com.study.unknown;

import java.util.*;
import java.util.stream.Collectors;

public class 보석쇼핑 {

    public int[] solution(String[] gems) {
        Set<String> gemSet = Arrays.stream(gems).collect(Collectors.toSet());
        int kind = gemSet.size();
        Map<String, Integer> gemCounter = new HashMap<>();
        Queue<String> gemQueue = new LinkedList<>();

        int distance = Integer.MAX_VALUE, start = 0, inx = 0;
        for(int i=0; i < gems.length; i++) {
            int count = gemCounter.getOrDefault(gems[i], 0);
            gemCounter.put(gems[i], count + 1);
            gemQueue.offer(gems[i]);

            while(gemCounter.get(gemQueue.peek()) > 1) {
                gemCounter.put(gemQueue.peek(), gemCounter.get(gemQueue.poll()) - 1);
                inx++;
            }

            if(gemCounter.size() == kind && distance > (i - inx)) {
                distance = i - inx;
                start = inx + 1;
            }
        }
        return new int[]{start, start + distance};
    }
}
