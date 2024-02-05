package programmers;

import java.util.*;

/**
 bfs 탐색
 */
class 게임맵최단거리 {
    int[] dr = new int[]{1, -1, 0, 0};
    int[] dc = new int[]{0, 0, 1, -1};
    int[][] visited;
    int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        int cnt = 1;
        while(!queue.isEmpty()) {
            cnt++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int[] point = queue.poll();
                for(int d = 0; d < 4; d++) {
                    int r = point[0] + dr[d];
                    int c = point[1] + dc[d];

                    if(!isAvailable(maps, r, c)) {
                        continue;
                    }

                    if((r == n - 1) && (c == m - 1)) {
                        return cnt;
                    }

                    queue.offer(new int[]{r, c});
                    visited[r][c] = 1;
                }
            }
        }

        return -1;
    }

    private boolean isAvailable(int[][] maps, int r,int c) {
        if(r < 0 || n <= r || c < 0 || m <= c) {
            return false;
        }

        if(visited[r][c] == 1) {
            return false;
        }

        if(maps[r][c] == 0) {
            return false;
        }

        return true;
    }
}