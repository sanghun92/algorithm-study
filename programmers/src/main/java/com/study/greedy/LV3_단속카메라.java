package com.study.greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LV3_단속카메라 {

    public int solution(int[][] routes) {
        List<Section> sections = getSections(routes);
        int answer = 0;
        int lastCamera = Integer.MIN_VALUE;
        for (Section section : sections) {
            if(section.matchCamera(lastCamera)) {
                continue;
            }
            lastCamera = section.out;
            answer++;
        }
        return answer;
    }

    private List<Section> getSections(int[][] routes) {
        List<Section> sections = new LinkedList<>();

        for(int i = 0; i < routes.length; i++) {
            sections.add(new Section(routes[i][0], routes[i][1]));
        }

        Collections.sort(sections);
        return sections;
    }

    private static class Section implements Comparable<Section> {
        private final int in;
        private final int out;

        public Section(int in, int out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public int compareTo(Section o) {
            return this.out - o.out;
        }

        @Override
        public String toString() {
            return "Section{" +
                    "in=" + in +
                    ", out=" + out +
                    '}';
        }

        public boolean matchCamera(int lastCamera) {
            return lastCamera >= this.in;
        }
    }
}
