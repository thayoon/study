import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(")");
            }
        }
        
        // if(!stack.isEmpty()) answer = false;
        if(stack.size() > 0) answer = false;

        return answer;
    }
}