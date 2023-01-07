package com.study.unknown;

public class 기지국설치 {

    public int solution(int n, int[] stations, int w) {
        int answer=0;
        int index = 1;
        int range = 2 * w + 1;

        for (int station : stations) {
            if(index < station - w) {
                int end = station - w;
                int length = end - index;
                int count = length / range;
                if(length % range != 0) {
                    count++;
                }
                answer += count;
            }
            index = station + w + 1;
        }

        // 마지막으로 설치되어있는 기지국의 오른편 계산
        if(stations[stations.length-1] + w + 1 <= n){
            index = stations[stations.length-1] + w + 1;
            int end = n + 1;
            int length = end - index;
            int count = length / (w * 2 + 1);
            if (length % (w * 2 + 1) != 0)
                count++;

            answer += count;
        }

        return answer;
    }
}
