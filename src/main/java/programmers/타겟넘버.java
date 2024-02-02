import java.util.*;

/**
    모든 경우의 수를 확인해야한다.
    2^20 = 10^6 번 확인이라 시간복잡도는 괜찮다.
    0 ~ 2^(numbers.length) - 1 까지 확인하자.
*/

class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        for(int i = 0; i < Math.pow(2, numbers.length); i++) {
            int sum = 0;
            for(int j = 0; j < numbers.length; j++) {
                if((i & (1 << j)) == 0) {
                    sum += numbers[j];
                } else {
                    sum -= numbers[j];
                }
            }
            
            if(sum == target) {
                answer++;
            }
        }
        
        return answer;
    }
}