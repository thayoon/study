import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> st = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && st.peek()[1] > prices[i]) {
                int[] now = st.pop();
                answer[now[0]] = i - now[0];
            }
            st.push(new int[] {i, prices[i]});
        }
        
        while (!st.isEmpty()) {
            int[] now = st.pop();
            answer[now[0]] = prices.length - now[0] - 1;
        }
        
        return answer;
    }
}