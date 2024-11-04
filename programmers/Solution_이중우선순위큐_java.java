import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++) {
            String[] now = operations[i].split(" ");
            String oper = now[0];
            int num = Integer.parseInt(now[1]);
            
            if(oper.equals("I")) {
                pqMin.offer(num);
                pqMax.offer(num);
            } else if(!pqMin.isEmpty()) {
                if(num == -1) {
                    int min = pqMin.poll();
                    pqMax.remove(min);
                } else {
                    int max = pqMax.poll();
                    pqMin.remove(max);
                }
            }
        }
        
        if(!pqMin.isEmpty()) {
            answer[0] = pqMax.peek();
            answer[1] = pqMin.peek();
        }
        
        return answer;
    }
}