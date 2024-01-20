package programmers;

/**
 여는 괄호가 나오면 스택에 넣어놓고 닫는 괄호가 나오면 스택에서 하나를 뺀다.
 만약 스택이 비어있다면 false,
 만약 끝까지 확인한 이후 스택에 남아있다면 false.
 여기서는 여는 괄호만 들어가니까 int로 대체하겠다.
 */

public class 올바른괄호 {
    boolean solution(String s) {
        int num = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                num++;
            } else {
                if(num <= 0) {
                    return false;
                }
                num--;
            }
        }

        if(num > 0) {
            return false;
        }

        return true;
    }
}
