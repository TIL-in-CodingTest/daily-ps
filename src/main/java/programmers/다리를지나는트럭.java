package programmers;

import java.util.*;

/**
 큐에 무게와 다리에서 소요한 시간을 동시에 넣어주고
 1초가 지날 때마다 갱신해준다.
 다리를 지나거나 건너기 시작할 때 무게를 따로 확인해준다.

 다리를 건너던 트럭들의 소요 시간을 1씩 늘려주고 다리 길이(최대 댓수)보다 커졌을 때
 대기 트럭이 들어갈 수 있니? -> 최대 댓수, 최대 무게 확인 후 출발
 */
public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<int[]> bridgeQ = new LinkedList<>();
        Queue<Integer> waitingQ = new LinkedList<>();

        for(int i = 0; i < truck_weights.length; i++) {
            waitingQ.offer(truck_weights[i]);
        }

        bridgeQ.offer(new int[]{waitingQ.poll(), 1});
        int sum = truck_weights[0];
        int time = 1;

        while(!bridgeQ.isEmpty()) {
            time++;

            Queue<int[]> temp = new LinkedList<>();
            // 1초가 지나면서 다리 위에 있는 트럭들 최신화
            while(!bridgeQ.isEmpty()) {

                int[] truck = bridgeQ.poll();
                truck[1]++;
                if(truck[1] > bridge_length) {
                    sum -= truck[0];
                    continue;
                }

                temp.offer(truck);
            }
            bridgeQ = temp;

            // 새로 올라타는 트럭
            if(!waitingQ.isEmpty() && sum + waitingQ.peek() <= weight) {
                sum += waitingQ.peek();
                bridgeQ.offer(new int[]{waitingQ.poll(), 1});
            }
        }

        return time;
    }
}