package com.study.dfs;

import java.util.*;

public class 여행경로 {

    public Queue<String> pq = new PriorityQueue<>();
    public boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0, "ICN");
        String[] answer = pq.peek().split(",");
        return answer;
    }

    public void dfs(String[][] tickets, String currentCity, int cnt, String path){
        if(cnt == tickets.length) {
            pq.offer(path);
            return;
        }

        for(int i=0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(currentCity)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt + 1, path + "," + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
