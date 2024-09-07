import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] ans = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == num1[i%5]) ans[0]++;
            if(answers[i] == num2[i%8]) ans[1]++;
            if(answers[i] == num3[i%10]) ans[2]++;
        }
        
        int max = Math.max(ans[0], Math.max(ans[1], ans[2]));
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<3; i++) {
            if(ans[i] == max) {
                result.add(i + 1);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}