class Solution {
    static int answer = -1;
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
    
    private void dfs(int n, int number, int sum, int cnt) {
        if(cnt > 8) return;
        
        if(sum == number){
            if(answer == -1 || cnt < answer) {
                answer = cnt;
            }
            return;
        }
        
        int now = 0;
        for(int i=1; i<9; i++) {
            now = now*10 + n;
            dfs(n, number, sum+now, cnt+i);
            dfs(n, number, sum-now, cnt+i);
            dfs(n, number, sum/now, cnt+i);
            dfs(n, number, sum*now, cnt+i);
        }
    }
}