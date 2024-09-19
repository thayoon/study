class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        
        for(int i=3; i*i<=area; i++) {
            if(i*i == area || area%i == 0) {
                int n = area/i;
                if(yellow == (n-2)*(i-2)) {
                    answer[0] = Math.max(n, i);
                    answer[1] = Math.min(n, i);
                    break;
                }
            }
        }
        
        return answer;
    }
}