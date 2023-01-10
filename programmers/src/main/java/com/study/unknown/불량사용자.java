package com.study.unknown;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class 불량사용자 {

    private Set<Set<String>> resultSet;
    private String[] user_id;
    private String[] regex;
    private boolean[] visited;


    public int solution(String[] user_id, String[] banned_id) {
        this.resultSet = new HashSet<>();
        this.user_id = user_id;
        this.regex = toRegex(banned_id);
        this.visited = new boolean[user_id.length];

        getPermutation(0, new LinkedHashSet<>());
        return resultSet.size();
    }

    private String[] toRegex(String[] banned_id) {
        String[] regexs = new String[banned_id.length];
        for(int i=0; i < banned_id.length; i++) {
            regexs[i] = "^" + banned_id[i].replace("*", ".") + "$";
        }

        return regexs;
    }

    private void getPermutation(int index, Set<String> set) {
        if(index == regex.length) {
            if(set.size() == regex.length) {
                resultSet.add(set);
            }
            return;
        }

        for(int i=0; i < user_id.length; i++) {
            if(Pattern.matches(regex[index], user_id[i]) && !visited[i]) {
                visited[i] = true;
                set.add(user_id[i]);
                getPermutation(index + 1, new LinkedHashSet<>(set));
                visited[i] = false;
                set.remove(user_id[i]);
            }
        }
    }
}
