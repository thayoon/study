import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);    // 접두사 비교기 때문에 정렬하여 인접한 번호들끼리 비교
        
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                // 문자열이 값으로 시작되는지 여부 확인
                return false;
            }
        }
        
        return true;
    }
}