package programmers;

import java.util.*;

/**
 필요한 일수에 맞는 진행률을 구하고 인덱스를 하나씩 증가시키면서 빠지는 수를 계산하면됨.
 */
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while(idx < progresses.length) {
            //맨 처음 기능이 배포될 때까지 걸리는 기간을 결정하고 작업 진행률을 맞춘다.
            int day = ((100 - progresses[idx]) + (speeds[idx] - 1)) / speeds[idx];
            for(int i = idx; i < progresses.length; i++) {
                progresses[i] += (speeds[i] * day);
            }

            //진행률이 100이상인 것들을 배포한다.
            int num = 0;
            while(idx < progresses.length && progresses[idx] >= 100) {
                num++;
                idx++;
            }
            list.add(num);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}