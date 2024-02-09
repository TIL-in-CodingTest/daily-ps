package programmers;

import java.util.*;

/**
 연결상태를 그래프로 표현하고 모든 모드를 돌면서 확인 (bfs, dfs)
 */
class 네트워크 {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }

            answer++;
            queue.offer(i);
            visited[i] = true;

            while(!queue.isEmpty()) {
                int num = queue.poll();
                for(int j = 0; j < n; j++) {
                    if(visited[j] || computers[num][j] == 0) {
                        continue;
                    }

                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }

        return answer;
    }
}