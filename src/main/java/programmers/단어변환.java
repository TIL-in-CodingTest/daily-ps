package programmers;

import java.util.*;

/**
 규칙적인 무언가가 없다. -> 완전 탐색
 */

class Node {
    String str;
    int cnt;

    Node(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}

class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.str.equals(target)) {
                return node.cnt;
            }

            flag : for(int i = 0; i < words.length; i++) {
                if(visited[i] == true) {
                    continue;
                }

                int diff = 0;
                for(int j = 0; j < node.str.length(); j++) {
                    if(node.str.charAt(j) != words[i].charAt(j)) {
                        diff++;

                        if(diff >= 2) {
                            continue flag;
                        }
                    }
                }

                queue.offer(new Node(words[i], node.cnt + 1));
                visited[i] = true;
            }

        }

        return 0;
    }
}