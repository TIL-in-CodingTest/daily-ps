package programmers;

/**
 던전이 최대 8개이니까 모든 경우의 수를 계산해도 괜찮겠다.
 순열, 완전탐색
 */

class 피로도 {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int[][] output = new int[dungeons.length][dungeons[0].length];
        boolean[] visited = new boolean[dungeons.length];
        int n = dungeons.length;
        int r = dungeons.length;
        permutation(dungeons, output, visited, 0, n, r, k);
        return max;
    }

    private void permutation(int[][] arr, int[][] output, boolean[] visited, int depth, int n, int r, int k) {
        if(depth == r) {
            max = Math.max(max, check(output, k));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r, k);
                visited[i] = false;
            }
        }
    }

    private int check(int[][] output, int k) {
        int num = 0;

        for(int i = 0; i < output.length; i++) {
            if(k < output[i][0]) {
                return num;
            }

            k -= output[i][1];
            num++;
        }

        return num;
    }
}