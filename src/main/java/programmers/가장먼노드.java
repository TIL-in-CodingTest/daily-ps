package programmers;

import java.util.*;

/**
 bfs나 dfs로 돌면서 최댓값과 비교해서 더 큰 값일때 최댓값을 갱신하고 갯수를 1로 바꿔준다.
 최댓값이랑 같을 때는 cnt를 올려준다.
 -> 또는 queue로 한바퀴 돌때마다 answer=0 으로 갱신하고 다시 체크하는 방법도 있다.
 */
class 가장먼노드 {
    private boolean[] visited;
    private List<List<Integer>> list = new ArrayList<>();
    private Queue<Integer> queue = new LinkedList<>();
    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] arr : edge) {
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }

        queue.offer(1);
        visited[1] = true;

        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            answer = size;

            for(int i = 0; i < size; i++) {
                int node = queue.poll();

                for(Integer num : list.get(node)) {
                    if(visited[num]) {
                        continue;
                    }

                    queue.offer(num);
                    visited[num] = true;
                }
            }
        }

        return answer;
    }
}