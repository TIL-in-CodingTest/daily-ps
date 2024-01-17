import java.util.*;

/**
*   모든 경우의 수를 하나씩 판단해도 시간이 충분하겠다.
*/
class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length - 1; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(isInAWord(phone_book[i], phone_book[j])) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isInAWord(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        for(int i = 0; i < len; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

