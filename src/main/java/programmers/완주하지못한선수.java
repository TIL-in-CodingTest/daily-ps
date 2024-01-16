package programmers;

import java.util.Arrays;

/**
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 * participant 배열에서 한 사람만 빠진 것이니까 두 배열을 각각 정렬한 후에 하나하나씩 비교해서, completion에 없는 사람이 정답.
 */
public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }
}
