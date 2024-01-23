import java.util.*;

/**
    우선순위를 정렬하고 해당 순서에 맞는 공을 찾을 때까지 빼서 돌린다.
    공에는 우선순위와 location을 함께 넣어둔다.
*/
class 프로세스 {
    public int solution(int[] priorities, int location) {
        
        //원래 위치와 우선순위를 큐에 넣는다.
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        
        
        //우선순위를 오름차순 정렬한 뒤에 해당 우선순위의 공이 나올때까지 뽑는다.
        int cnt = 0;
        Arrays.sort(priorities);
        for(int i = priorities.length - 1; i >= 0; i--) {
            while(true) {
                int[] ball = q.poll();
                
                //해당 순위의 공이 맞다면 빼내고 아니라면 다시 넣는다.
                if(ball[0] == priorities[i]) {
                    cnt++;
                    
                    //뺏을 때 우리가 판단하기를 원하는 위치였다면 값을 반환한다.
                    if(ball[1] == location) {
                        return cnt;
                    }
                    break;
                }else {
                    q.offer(ball);
                }
            }
        }
    
        return cnt;
    }
}
