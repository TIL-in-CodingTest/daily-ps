import java.util.*;

/**
*   종류를 세서 n/2 와 비교해서 더 적은 값이 정답이다.
*/
class 폰켓몬 {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return Math.min(set.size(), nums.length / 2);
    }
}

