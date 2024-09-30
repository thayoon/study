import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];
        
        for(int i=2; i<N; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j == triangle[i].length-1) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else {
                    int now = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                    dp[i][j] = Math.max(dp[i][j], now);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<triangle[N-1].length; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }
        return answer;
    }
}