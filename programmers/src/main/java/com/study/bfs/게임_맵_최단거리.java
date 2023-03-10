package com.study.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    private boolean[][] visited;
    private int X;
    private int Y;
    public int solution(int[][] maps) {
        this.X = maps.length;
        this.Y = maps[0].length;
        this.visited = new boolean[X][Y];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(X-1, Y-1));

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int row = current.x;
            int col = current.y;

            if(row == 0 && col == 0) {
                return maps[0][0];
            }

            if(visited[row][col]) {
                continue;
            }
            visited[row][col] = true;

            int nextRow = row;
            int nextCol = col - 1;
            // 왼쪽 추가
            addPoint(maps, queue, row, col, nextRow, nextCol);

            // 오른쪽 추가
            nextRow = row;
            nextCol = col + 1;
            addPoint(maps, queue, row, col, nextRow, nextCol);

            // 위쪽 추가
            nextRow = row - 1;
            nextCol = col;
            addPoint(maps, queue, row, col, nextRow, nextCol);

            // 아래쪽 추가
            nextRow = row + 1;
            nextCol = col;
            addPoint(maps, queue, row, col, nextRow, nextCol);
        }

        return -1;
    }

    private void addPoint(int[][] maps, Queue<Point> queue, int row, int col, int nextRow, int nextCol) {
        if(nextRow < 0 || nextRow >= X) {
            return;
        }

        if(nextCol < 0 || nextCol >= Y) {
            return;
        }

        if(maps[nextRow][nextCol] == 1) {
            queue.offer(new Point(nextRow, nextCol));
            maps[nextRow][nextCol] = maps[row][col] + 1;
        }
    }

    private final static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
