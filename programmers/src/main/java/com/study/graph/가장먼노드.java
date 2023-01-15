package com.study.graph;

import java.util.*;

public class 가장먼노드 {

    public int solution(int n, int[][] edge) {
        Graph graph = new Graph(n, edge);
        return graph.getPath(0);
    }

    private static class Graph {
        private final List<List<Integer>> connect;

        public Graph(int n, int[][] edge) {
            this.connect = initEdge(n, edge);
        }

        public int getPath(int start) {
            int[] distance = new int[connect.size()];
            int maxDistance = 0;
            boolean[] checked = new boolean[connect.size()];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            checked[start] = true;

            while(!queue.isEmpty()) {
                int currentNode = queue.poll();
                List<Integer> node = connect.get(currentNode);

                for (Integer nodeValue : node) {
                    if(checked[nodeValue]) {
                        continue;
                    }

                    checked[nodeValue] = true;
                    distance[nodeValue] = distance[currentNode] + 1;
                    maxDistance = Math.max(maxDistance, distance[nodeValue]);
                    queue.offer(nodeValue);
                }
            }
            int finalMaxDistance = maxDistance;
            return (int) Arrays.stream(distance)
                    .filter(d -> d == finalMaxDistance)
                    .count();
        }

        private List<List<Integer>> initEdge(int n, int[][] edge) {
            List<List<Integer>> linkedEdge = new ArrayList<>();
            for(int i=0; i < n; i++) {
                linkedEdge.add(new ArrayList<>());
            }
            for (int[] edgeArray : edge) {
                linkedEdge.get(edgeArray[0] - 1).add(edgeArray[1] - 1);
                linkedEdge.get(edgeArray[1] - 1).add(edgeArray[0] - 1);
            }
            return linkedEdge;
        }
    }
}
