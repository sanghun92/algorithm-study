package com.study.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {

    private int xLength;
    private int yLength;
    private char[][] maps;
    private boolean[][] visited;
    private int[] startInx;
    private int[] leverInx;
    private int[] endInx;
    private int[] dx = new int[]{ 0, 0, -1, 1 };
    private int[] dy = new int[]{ -1, 1, 0, 0 };

    public static void main(String[] args) {
        미로_탈출 solution = new 미로_탈출();
//        solution.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
        solution.solution(new String[]{"SOOOO","XXXXX","LOOOO","XXXXX","EOOOO"});

        // dx :  0, 0, -1, 1
        // dy : -1, 1,  0, 0

        /**
         * [0, 0] [0, 1] [0, 2] [0, 3]
         * [1, 0] [1, 1] [1, 2] [1, 3]
         * [2, 0] [2, 1] [2, 2] [2, 3]
         * [3, 0] [3, 1] [3, 2] [3, 3]
         */

        // [1, 1]
        // Left   : [1, 0] == [x + 0, y - 1]
        // Right  : [1, 2] == [x + 0, y + 1]
        // Bottom : [2, 1] == [x + 1, y + 0]
        // Top    : [0, 1] == [x - 1, y + 0]

    }

    public int solution(String[] maps) {
        drawMaps(maps);
        int leverCount = numberOfMinPath(this.startInx, this.leverInx);
        if(leverCount < 0) {
            return leverCount;
        }

        visited = new boolean[xLength][yLength];
        int endCount = numberOfMinPath(this.leverInx, this.endInx);
        if(endCount < 0) {
            return endCount;
        } else {
            return leverCount + endCount;
        }
    }

    private static class Node {
        private final int x;
        private final int y;
        private final int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private void drawMaps(String[] maps) {
        this.xLength = maps.length;
        this.yLength = maps[0].length();
        this.maps = new char[xLength][yLength];
        this.visited = new boolean[xLength][yLength];

        for(int i=0; i < xLength; i++) {
            for(int j=0; j < yLength; j++) {
                this.maps[i] = maps[i].toCharArray();

                if('S' == this.maps[i][j]) {
                    this.startInx = new int[]{i,j};
                } else if('L' == this.maps[i][j]) {
                    this.leverInx = new int[]{i,j};
                } else if('E' == this.maps[i][j]) {
                    this.endInx = new int[]{i,j};
                }
            }
        }
    }

    private int numberOfMinPath(int[] start, int[] target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode.x == target[0] && currentNode.y == target[1]) {
                return currentNode.cnt;
            }

            for(int i=0; i < 4; i++) {
                int nextX = currentNode.x + dx[i];
                int nextY = currentNode.y + dy[i];

                if(nextX < 0 || nextX >= xLength) {
                    continue;
                }

                if(nextY < 0 || nextY >= yLength) {
                    continue;
                }

                if(maps[nextX][nextY] == 'X' || visited[nextX][nextY]) {
                    continue;
                }

                queue.offer(new Node(nextX, nextY, currentNode.cnt + 1));
                visited[nextX][nextY] = true;
            }
        }

        return -1;
    }
}
