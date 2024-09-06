class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int i=0; i<numbers.length; i++) {
            if(answer > n) break;
            else answer+=numbers[i];
        }
        // for(int i=0; answer<=n; i++) {
        //   answer += numabers[i];
        // }
        return answer;
    }
}