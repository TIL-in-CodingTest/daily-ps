package programmers;

import java.util.*;

/**
 한 점에서 모든 정점까지의 최단거리 => 다익스트라
 */

class Node {
    int index;
    int cost;

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}

class 배달 {
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    ArrayList<Node>[] graph;
    int[] dist;
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] arr : road) {
            graph[arr[0]].add(new Node(arr[1], arr[2]));

        }

        dijkstra(N, 1);

        int answer = 0;

        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private void dijkstra(int N, int start) {
        boolean[] visited = new boolean[N + 1];
        dist = new int[N + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int currentIdx = pq.poll().index;

            if(visited[currentIdx]) {
                continue;
            }

            visited[currentIdx] = true;

            for(Node next : graph[currentIdx]) {
                if(dist[next.index] > dist[currentIdx] + next.cost) {
                    dist[next.index] = dist[currentIdx] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}