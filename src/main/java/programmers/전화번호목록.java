import java.util.*;

/**
모든 경우의 수를 하나씩 판단해도 시간이 충분하겠다. O(n^2) -> 최악의 경우 10^12 1000초?
HashSet을 이용하면 O(1)으로 검색이 가능하다. 하나의 전화번호를 길이 1 ~ (크기-1) 로 잘라 해당 키를 갖고있는 번호가 있는지 확인. 최악의 경우, 번호가 총 10^6개 번호당 20번 확인. 
더 효율적인 것으로 확인 
*/
class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String phone_number : phone_book) {
            set.add(phone_number);
        }
        
        for(String phone_number : phone_book) {
            for(int i = 0; i < phone_number.length(); i++) {
                String prefix = phone_number.substring(0, i);
                if(set.contains(prefix)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
