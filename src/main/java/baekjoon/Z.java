package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

    static int N, r, c;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recursion((int)Math.pow(2, N), 0, 0, 0);
    }

    static void recursion(int N, int pivotR, int pivotC, int cnt) {
        if(N == 1) {
            System.out.println(cnt);
            return;
        }

        int unitSize = N * N / 4;
        if(r < pivotR + N / 2) {
            if(c < pivotC + N / 2) {
                recursion(N / 2, pivotR, pivotC, cnt);
            } else {
                recursion(N / 2, pivotR, pivotC + N / 2, cnt + unitSize);
            }
        } else {
            if(c < pivotC + N / 2) {
                recursion(N / 2, pivotR + N / 2, pivotC, cnt + 2 * unitSize);
            } else {
                recursion(N / 2, pivotR + N / 2, pivotC + N / 2, cnt + 3 * unitSize);
            }
        }
    }

}
