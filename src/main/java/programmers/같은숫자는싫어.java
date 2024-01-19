import java.util.*;

/**
    큐에 하나씩 넣으면서 마지막 큐에 같은 값이면 넣지 않는다.
    만들어진 큐를 리스트로 만들어서 반환
*/
public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        q.offer(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(q.peekLast() == arr[i]) {
                continue;
            }
            
            q.offer(arr[i]);
        }
        
        int[] answer = new int[q.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        
        return answer;
    }
}
