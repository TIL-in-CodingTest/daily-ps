package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {
    static int I, T;
    static boolean[][] visited;
    static int[] dr = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dc = {1, -1, 2, -2, 2, -2, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            test();
        }
    }

    static void test() throws IOException {
        queue = new LinkedList<>();
        I = Integer.parseInt(br.readLine());
        visited = new boolean[I][I];
        st = new StringTokenizer(br.readLine());
        int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            if(node[0] == end[0] && node[1] == end[1]) {
                System.out.println(node[2]);
                return;
            }

            for(int d = 0; d < 8; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if(nr < 0 || nr >= I || nc < 0 || nc >= I || visited[nr][nc]) {
                    continue;
                }

                queue.offer(new int[]{nr, nc, node[2] + 1});
                visited[nr][nc] = true;
            }
        }
    }

}
