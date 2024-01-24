package programmers;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        flag : for(int i = 0; i < answer.length; i++) {
            int sum = 0;
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j - i;
                    continue flag;
                }
            }

            answer[i] = prices.length - 1 - i;
        }

        return answer;
    }
}