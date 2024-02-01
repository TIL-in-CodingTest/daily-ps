package programmers;

import java.util.*;

/**
 전선의 최대 갯수는 약 10^4 개 -> 모든 경우의 수 확인 가능하다.
 하나의 트리로 연결되어 있고 하나를 끊는데 두 전력망이 생긴다는 것은 두 그룹 사이에 다른 연결이 없다는 뜻
 끊기 전에 판단하기는 어려울 것 같고 끊고 나서 판단 가능할 것 같다.
 과정 1. 끊어서 전력망이 2개 인지 확인
 과정 2. 각각의 전력망 갯수를 확인하고 차이를 확인해 정답을 갱신한다. (만약 차이가 0이면 리턴)
 */
class 전력망을둘로나누기 {

    int answer = 100;
    int cnt = 0;
    public int solution(int n, int[][] wires) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] wire: wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        for(int i = 0; i < wires.length; i++) {
            list.get(wires[i][0]).remove((Integer)wires[i][1]);
            list.get(wires[i][1]).remove((Integer)wires[i][0]);

            boolean[] visited = new boolean[n + 1];
            cnt = 0;
            count(1, visited, list);

            answer = Math.min(answer, Math.abs(n - 2 * cnt));

            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }

        return answer;
    }

    private void count(int i, boolean[] visited, List<List<Integer>> list) {
        if(visited[i] == true) {
            return;
        }

        cnt++;
        visited[i] = true;

        for(Integer num : list.get(i)) {
            count(num, visited, list);
        }
    }
}