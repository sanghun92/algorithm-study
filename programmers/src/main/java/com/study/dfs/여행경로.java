package com.study.dfs;

import java.util.*;

public class 여행경로 {

    public Queue<String> pq = new PriorityQueue<>();
    public String[][] tickets;
    public boolean[] visited;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length];
        dfs("ICN", "ICN", 0);
        return pq.poll().split(",");
    }

    private void dfs(String currentPath, String path, int count) {
        if(count == this.tickets.length) {
            pq.offer(path);
            return;
        }

        for(int i=0; i < tickets.length; i++) {
            if(visited[i]) continue;
            if(!tickets[i][0].equals(currentPath)) continue;

            visited[i] = true;
            dfs(tickets[i][1], path + "," + tickets[i][1], count + 1);
            visited[i] = false;
        }
    }
}
