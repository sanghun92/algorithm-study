package com.study.greedy;

import java.util.*;

public class 섬연결하기 {

    public int solution(int n, int[][] costs) {
        List<BridgeEdge> edges = makeBridgeEdge(costs);
        Collections.sort(edges);
        int[] set = new int[n];
        for(int i=0; i < n; i++) {
            set[i] = i;
        }

        int answer = 0;
        for(int i=0; i < edges.size(); i++) {
            BridgeEdge bridgeEdge = edges.get(i);
            if(!find(set, bridgeEdge)) {
                answer += bridgeEdge.cost;
                unionParent(set, bridgeEdge);
            }
        }
        return answer;
    }

    private boolean find(int[] set, BridgeEdge bridgeEdge) {
        return getParent(set, bridgeEdge.source) == getParent(set, bridgeEdge.dest);
    }

    private int getParent(int[] set, int source) {
        if(set[source] == source) return source;
        return set[source] = getParent(set, set[source]);
    }

    private void unionParent(int[] set, BridgeEdge bridgeEdge) {
        int sourceParent = getParent(set, bridgeEdge.source);
        int destParent = getParent(set, bridgeEdge.dest);

        if(sourceParent < destParent) set[destParent] = sourceParent;
        else set[sourceParent] = destParent;
    }

    private List<BridgeEdge> makeBridgeEdge(int[][] costs) {
        List<BridgeEdge> edges = new ArrayList<>(costs.length);
        for (int[] cost : costs) {
            edges.add(new BridgeEdge(cost[0], cost[1], cost[2]));
        }

        return edges;
    }

    private static class BridgeEdge implements Comparable<BridgeEdge> {
        private final int source;
        private final int dest;
        private final int cost;

        public BridgeEdge(int source, int dest, int cost) {
            this.source = source;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(BridgeEdge o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "BridgeEdge{" +
                    "source=" + source +
                    ", dest=" + dest +
                    ", cost=" + cost +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BridgeEdge that = (BridgeEdge) o;

            if (source != that.source) return false;
            if (dest != that.dest) return false;
            return cost == that.cost;
        }

        @Override
        public int hashCode() {
            int result = source;
            result = 31 * result + dest;
            result = 31 * result + cost;
            return result;
        }
    }
}
