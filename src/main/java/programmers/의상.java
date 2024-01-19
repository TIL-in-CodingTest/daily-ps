package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    (종류 : 갯수)를 먼저 파악한다.
    종류별로 선택할 수 있는 경우의 수를 구하고 곱해서 총 경우의 수를 구한다.
*/
public class 의상 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth: clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        Iterator<Integer> iterator = map.values().iterator();
        int answer = 1;
        while (iterator.hasNext()) {
            answer *= (iterator.next() + 1);
        }

        answer -= 1;
        return answer;
    }
}