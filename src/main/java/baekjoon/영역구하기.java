package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 영역구하기 {
    static int M, N, K;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static List<Integer> list = new ArrayList<>();
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        for(int i = 0; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            for(int j = start[0]; j < end[0]; j++) {
                for(int k = start[1]; k < end[1]; k++) {
                    visited[j][k] = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] == true) {
                    continue;
                }

                int size = 0;
                queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                visited[i][j] = true;

                while(!queue.isEmpty()) {
                    int[] node = queue.poll();
                    size++;

                    for(int d = 0; d < 4; d++) {
                        int nr = node[0] + dr[d];
                        int nc = node[1] + dc[d];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
                            continue;
                        }

                        if(visited[nr][nc]) {
                            continue;
                        }

                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }

                list.add(size);
            }
        }

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        sb.append(list.size() + "\n");
        for(int element : list) {
            sb.append(element + " ");
        }
        System.out.println(sb);

    }

}
