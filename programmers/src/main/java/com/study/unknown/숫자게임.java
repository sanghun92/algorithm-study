package com.study.unknown;

import java.util.*;
import java.util.stream.Collectors;

public class 숫자게임 {

    public int solution(int[] A, int[] B) {
        int answer=0, bPointer = 0;
        List<Integer> aList = arrayToList(A);
        List<Integer> bList = arrayToList(B);
        for(int i=0; i < aList.size(); i++) {
            if(aList.get(i) < bList.get(bPointer)) {
                answer++;
                bPointer++;
            }
        }

        return answer;
    }

    private List<Integer> arrayToList(int[] A) {
        return Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }
}
