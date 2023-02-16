package com.study.unknown;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 표병합 {

    private int[] parent = new int[2501];
    private String[] value = new String[2501];

    public String[] solution(String[] commands) {
        init();
        List<String> result = new ArrayList<>();

        for (String commandValues : commands) {
            StringTokenizer st = new StringTokenizer(commandValues);
            String op = st.nextToken();

            switch (op) {
                case "UPDATE":
                    if(st.countTokens() == 2) {
                        String before = st.nextToken();
                        String after = st.nextToken();
                        cellUpdate(before, after);
                    } else {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        String after = st.nextToken();
                        cellUpdate(x, y, after);
                    }
                    break;
                case "MERGE":
                    cellMerge(st);
                    break;
                case "UNMERGE":
                    cellUnMerge(st);
                    break;
                case "PRINT":
                    cellAddResult(st, result);
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }

        return result.toArray(String[]::new);
    }

    private void cellUpdate(String before, String after) {
        for (int i = 1; i <= 2500; i++) {
            if (before.equals(value[i]))
                value[i] = after;
        }
    }

    private void cellUpdate(int x, int y, String after) {
        int num = convertNum(x, y);
        value[find(num)] = after;
    }

    private void cellMerge(StringTokenizer st) {
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int n1 = convertNum(x1, y1);
        int n2 = convertNum(x2, y2);
        int root1 = find(n1);
        int root2 = find(n2);

        if (root1 == root2) return;

        String rootString = value[root1].isBlank() ? value[root2] : value[root1];
        value[root1] = "";
        value[root2] = "";
        union(root1, root2);
        value[root1] = rootString;
    }

    private void cellUnMerge(StringTokenizer st) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int num = convertNum(x, y);
        int root = find(num);
        String rootString = value[root];
        value[root] = "";
        value[num] = rootString;

        List<Integer> deleteList = new ArrayList<>();

        for (int i = 1; i <= 2500; i++) {
            if (find(i) == root)
                deleteList.add(i);
        }

        for (Integer t : deleteList)
            parent[t] = t;
    }

    private void cellAddResult(StringTokenizer st, List<String> result) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int num = convertNum(x, y);
        int root = find(num);
        if (value[root].isBlank())
            result.add("EMPTY");
        else
            result.add(value[root]);
    }

    private void init() {
        for(int i=1; i < parent.length; i++) {
            parent[i] = i;
            value[i] = "";
        }
    }

    public int convertNum(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }

    public int find(int num) {
        if(parent[num] == num) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }
}
