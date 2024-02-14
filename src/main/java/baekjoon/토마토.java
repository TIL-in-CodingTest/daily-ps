package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 익은 토마토가 들어있는 곳들에 대한 정보들을 큐에 담아두고 하나씩 늘려가면서 주면 토마토들을 익힌다.
 * 큐가 빌 때까지 확인하고 모두 익었다면 적절한 값을 입력해주고 만약 모두 익지는 못한다면 -1을 출력한다.
 * 삼중배열이 헷갈린다.
 */

public class 토마토 {
    static int M, N, H;
    static int cnt = 0;
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static boolean[][][] visited;
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[H][N][M];
        map = new int[H][N][M];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if(map[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            cnt = node[3];

            for(int d = 0; d < 6; d++) {
                int nh = node[0] + dh[d];
                int nr = node[1] + dr[d];
                int nc = node[2] + dc[d];

                if(!isAvailable(nh, nr, nc) || visited[nh][nr][nc]) {
                    continue;
                }

                if(map[nh][nr][nc] == 0) {
                    queue.offer(new int[]{nh, nr, nc, node[3] + 1});
                    visited[nh][nr][nc] = true;
                }
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if((map[i][j][k] == 0) && (!visited[i][j][k])) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean isAvailable(int h, int r, int c) {
        if(h < 0 || h >= H || r < 0 || r >= N || c < 0 || c >= M) {
            return false;
        }

        return true;
    }
}
