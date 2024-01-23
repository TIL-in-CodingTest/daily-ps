package programmers;

import java.util.*;

/**
 *  차량번호를 key, 입차시간(분)을 value로 갖고있는 inMap 하나와
 *  차량번호를 key, 총 입차시간을 value로 갖고있는 sumMap 하나를 선언한다.
 *  기록을 한 줄씩 읽고 IN 이라면 inMap에 넣어주고, out 이라면 inMap에서 입차시간을 가져와서 계산해서 sumMap에 추가해준다.
 *  sumMap을 차량번호(key) 순으로 정렬하고 주차 요금을 계산해서 반환해준다.
 */

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();

        for(String record : records) {
            String[] inputs = record.split(" ");
            String[] times = inputs[0].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

            if(inputs[2].equals("IN")) {
                inMap.put(inputs[1], time);
            } else {
                int diff = time - inMap.get(inputs[1]);
                sumMap.put(inputs[1], sumMap.getOrDefault(inputs[1], 0) + diff);
                inMap.remove(inputs[1]);
            }
        }

        //끝나고 남은 inMap 처리
        for(String number : inMap.keySet()) {
            int diff = 23 * 60 + 59 - inMap.get(number);
            sumMap.put(number, sumMap.getOrDefault(number, 0) + diff);
        }

        List<String> keyList = new ArrayList<>(sumMap.keySet());
        Collections.sort(keyList);

        int[] answer = new int[keyList.size()];
        for(int i = 0; i < answer.length; i++) {

            int sum = sumMap.get(keyList.get(i));
            int cost = fees[1];
            if(sum <= fees[0]) {
                answer[i] = cost;
                continue;
            }

            cost += ((sum - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
            answer[i] = cost;
        }
        return answer;
    }
}