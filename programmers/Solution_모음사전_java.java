import java.util.*;

class Solution {
    static int answer, seq;
    static String[] vow;
    
    public int solution(String word) {
        seq = 0;
        answer = 0; 
        vow = new String[]{"A", "E", "I", "O", "U"};
        combi(0, word, "");
        return answer;
    }
    
    /**
     * 조합으로 사전 순서대로 탐색하고 단어와 같으면 인덱스 반환
     * @parms cnt: 현재 단어 길이
     * @parms w: 찾는 단어
     * @parms num: 현재 순서 단어 
     */
    private static void combi(int cnt, String w, String num) {
        if(answer != 0) return;
        if(w.equals(num)) {
            answer = seq;
            return;
        }
        if(cnt == 5) {
            return;
        }
        for(int i=0; i<5; i++) {
            seq++;
            combi(cnt+1, w, num+vow[i]);
        }
    }
}