package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 큐에 불의 위치들을 넣어놓고 상근이의 위치를 넣어놓는다.
 * 불이나 벽을 모두 방문 처리 해버리고 다음 인덱스가 건물 밖으로 넘어간다면 결과를 출력하고 종료한다.
 * 불안한 것은 상근이가 있는 위치도 방문처리가 돼서 불이 따라오는 것은 문제가 없나? 최소 거리로 간다면 괜찮다.
 * 큐 안의 int[] 의 0, 1 인덱스에는 위치를 표현하고 2 인덱스에 0이 오면 불, 1이 오면 사람으로 한다.
 * 만약 1이라면 3 인덱스도 있는데 3 인덱스에서는 cnt를 센다.
 */
public class 불 {
    static int w, h;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int tc = 0; tc < T; tc++) {
            test();
        }
    }
    static void test() throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[] person = new int[2];
        queue = new LinkedList<>();

        map = new char[h][w];
        visited = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                switch (map[i][j]) {
                    case '#' : visited[i][j] = true; break;
                    case '@' : person = new int[]{i, j}; break;
                    case '*' :
                        queue.offer(new int[]{i, j, 0});
                        visited[i][j] = true;
                        break;
                }
            }
        }

        queue.offer(new int[]{person[0], person[1], 1, 0});
        visited[person[0]][person[1]] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = node[0] + dr[d];
                int nc = node[1] + dc[d];

                if(nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    if(node[2] == 1) {
                        System.out.println(node[3] + 1);
                        return;
                    }
                    continue;
                }

                if(visited[nr][nc]) {
                    continue;
                }

                if(node[2] == 1) {
                    queue.offer(new int[]{nr, nc, 1, node[3] + 1});
                } else {
                    queue.offer(new int[]{nr, nc, 0});
                }

                visited[nr][nc] = true;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}
