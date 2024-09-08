import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for(int i=0; i<arr.length-1; i++) {
            if(stack.peek() != arr[i+1]) stack.push(arr[i+1]);
        }
        
        int[] answer = new int[stack.size()];
        int i = 0;
        for(int num : stack) {
            answer[i++] = num;
        }
        return answer;
    }
}