package com.study.dfs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 단어_변환 {

    private boolean[] used;
    private List<String> words;
    private String target;
    private int answer;

    public int solution(String begin, String target, String[] words) {
        this.used = new boolean[words.length];
        this.target = target;
        this.answer = Integer.MAX_VALUE;
        this.words = Arrays.stream(words)
                .collect(Collectors.toList());

        if(!this.words.contains(target)) {
            return 0;
        }

        dfs(begin, 0);

        return answer;
    }

    private void dfs(String word, int count) {
        if(word.equals(target)) {
            answer = Math.min(answer, count);
            System.out.println("FIND : " + word);
            return;
        }

        for(int i=0; i < words.size(); i++) {
            String nextWord = words.get(i);
            if(used[i]) {
                continue;
            }

            if(isMatched(word, nextWord)) {
//                System.out.println("DFS " + word + " -> " + nextWord);
                used[i] = true;
                dfs(nextWord, count + 1);
                used[i] = false;
            }
        }
    }

    private boolean isMatched(String source, String target) {
        int matchCount = 0;
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        for(int i=0; i < sourceArray.length; i++) {
            if(sourceArray[i] == targetArray[i]) {
                matchCount++;
            }
        }
        return matchCount >= targetArray.length - 1;
    }
}
