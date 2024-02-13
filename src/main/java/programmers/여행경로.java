package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  공항 수가 10000개 매번 비교를 하게 된다면 문제가 생길 수도 있을 것 같다.
 *  일단 기본 구현에 충실하자.
 */
public class 여행경로 {
    static boolean[] visited;
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN", 1);
        Collections.sort(list);
        return list.get(0).split(" ");

    }

    public void dfs(String[][] tickets, String current, String sequence, int depth) {
        if (depth == tickets.length + 1) {
            list.add(sequence);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(current) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], sequence + " " + tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}
