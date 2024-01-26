package programmers;

import java.util.*;

/**
 하나의 작업이 끝날 때마다 해당 시간동안 밀려있었던 작업들을 보고
 가장 짧은 시간 내에 해결할 수 있는 작업을 선택하면 된다.
 만약 작업이 밀려있지 않았다면 가장 빨리 시작하는 작업을 선택하면 된다.
 */
public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        int sec = 0;
        int idx = 0;
        int cnt = 0;
        int time = 0;

        while(cnt < jobs.length) {
            //해당 시간까지 쌓여있는 작업들 큐에 담는다.
            while(idx < jobs.length && jobs[idx][0] <= sec) {
                q.offer(jobs[idx]);
                idx++;
            }

            //만약 해당 시간까지 쌓인 큐가 없다면 최초 시작하는 시간으로 맞춰준다.
            if(q.size() == 0) {
                sec = jobs[idx][0];
                continue;
            }

            //큐 중에 가장 빠르게 끝낼 수 있는 작업을 끝낸다.
            int[] job = q.poll();
            sec += job[1];
            time += (sec - job[0]);
            cnt++;
        }

        return time / jobs.length;
    }
}
