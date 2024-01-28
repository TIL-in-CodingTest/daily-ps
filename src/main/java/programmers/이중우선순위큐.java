package programmers;

import java.util.*;

/**
 * 해당 문제는 수를 넣고 빼는 동작이 있고 정렬을 계속 진행시켜야하기 때문에 우선순위 큐를 사용해야한다.
 * 하지만 최솟값, 최댓값이 모두 필요하기 때문에 최솟값 우선순위큐와 최댓값 우선순위큐를 동시에 이용한다.
 */
public class 이중우선순위큐 {

    Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> minQ = new PriorityQueue<>();

    public int[] solution(String[] operations) {
        for(String operation : operations) {
            String[] inputs = operation.split(" ");
            int num = Integer.parseInt(inputs[1]);
            if(inputs[0].equals("I")) {
                insert(num);
            } else {
                if(inputs[1].equals("1")) {
                    removeMax();
                } else {
                    removeMin();
                }
            }
        }

        if(minQ.size() == 0) {
            return new int[]{0, 0};
        }

        int[] answer = new int[]{maxQ.peek(), minQ.peek()};
        return answer;
    }

    private void removeMax() {
        if(maxQ.size() == 0) {
            return;
        }
        int max = maxQ.poll();
        minQ.remove(max);
    }

    private void removeMin() {
        if(minQ.size() == 0) {
            return;
        }
        int min = minQ.poll();
        maxQ.remove(min);
    }

    private void insert(int number) {
        maxQ.add(number);
        minQ.add(number);
    }
}