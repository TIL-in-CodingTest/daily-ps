package programmers;

import java.util.*;

/**
 단방향 그래프를 만들고 지는 것이 확정이거나 이기는 것이 확정인 것들을 모아서 모든 노드가 모이면 확정
 */
class 순위 {

    private List<List<Integer>> list = new ArrayList<>();
    private List<List<Integer>> reversedList = new ArrayList<>();
    private List<Set<Integer>> checkedList = new ArrayList<>();
    public int solution(int n, int[][] results) {
        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
            reversedList.add(new ArrayList<>());
            checkedList.add(new HashSet<>());
        }

        //단방향 그래프 만들고
        for(int[] result : results) {
            list.get(result[0]).add(result[1]);
            reversedList.get(result[1]).add(result[0]);
        }

        //각각의 노드마다 체크
        for(int i = 1; i <= n; i++) {
            check(list, i, i);
            check(reversedList, i, i);
        }


        int answer = 0;
        //checkedSet 사이즈 확인 후 n - 1 이면 answer++
        for(int i = 1; i <= n; i++) {
            if(checkedList.get(i).size() == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    private void check(List<List<Integer>> list, int i, int origin) {
        for(Integer num : list.get(i)) {
            checkedList.get(origin).add(num);
            check(list, num, origin);
        }
    }
}
