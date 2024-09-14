class Solution {
    static int number = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return number;
    }
    
    static void dfs(int[] num, int cnt, int target, int sum) {
        if(cnt == num.length) {
            if(sum == target) number++;
            return;
        }
        
        dfs(num, cnt+1, target, sum+num[cnt]);
        dfs(num, cnt+1, target, sum-num[cnt]);
    }
}