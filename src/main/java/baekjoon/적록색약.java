package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class 적록색약 {
    static int N;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Node> queue = new LinkedList<>();
    static char[][] input;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        input = new char[N][N];
        for(int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray();
        }

        int first_ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (visited[i][j] == true) {
                    continue;
                }

                first_ans++;
                visited[i][j] = true;
                queue.offer(new Node(i, j));
                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    for(int d = 0; d < 4; d++) {
                        int nr = node.r + dr[d];
                        int nc = node.c + dc[d];

                        if(!isAvailable(nr, nc) || visited[nr][nc]) {
                            continue;
                        }

                        if(input[node.r][node.c] == input[nr][nc]) {
                            queue.offer(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }

        visited = new boolean[N][N];
        int second_ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (visited[i][j] == true) {
                    continue;
                }

                second_ans++;
                visited[i][j] = true;
                queue.offer(new Node(i, j));
                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    for(int d = 0; d < 4; d++) {
                        int nr = node.r + dr[d];
                        int nc = node.c + dc[d];

                        if (!isAvailable(nr, nc) || visited[nr][nc]) {
                            continue;
                        }

                        if (input[node.r][node.c] == 'B') {
                            if (input[nr][nc] == 'B') {
                                queue.offer(new Node(nr, nc));
                                visited[nr][nc] = true;
                            }
                        } else {
                            if (input[nr][nc] != 'B') {
                                queue.offer(new Node(nr, nc));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.printf("%d %d", first_ans, second_ans);
    }

    static boolean isAvailable(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N) {
            return false;
        }
        return true;
    }
}
