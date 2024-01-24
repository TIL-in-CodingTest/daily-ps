package programmers;

import java.util.*;

/**
    우선순위 큐를 활용해 순서가 유지되도록 한다.
    빠르게 최소 값을 확인할 수 있어서 시간효율성이 좋아진다.
    우선순위 큐 삽입시 O(logN), 추출시 O(logN)
 */

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int num : scoville) {
            q.offer(num);
        }

        int cnt = 0;
        while(q.size() >= 2 && q.peek() < K) {
            int first = q.poll();
            int second = q.poll();
            q.offer(first + (second * 2));
            cnt++;
        }

        if(q.peek() < K) {
            return -1;
        }

        return cnt;
    }
}
