import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        int X = 0;
        int[][] arr = new int[N][2];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N][2];
        dp[0][0] = (arr[0][0] <= arr[0][1]) ? 1 : 0; // 만난 경우
        dp[0][1] = 0; // 만나지 않은 경우
        for(int i=1; i<N; i++) {
            int mx = (Math.abs(arr[i][0]-dp[i-1][0]) <= arr[i][1]) ? dp[i-1][0]+1 : dp[i-1][0];
            int nx = (Math.abs(arr[i][0]-dp[i-1][1]) <= arr[i][1]) ? dp[i-1][1]+1 : dp[i-1][1];

            dp[i][0] = Math.max(mx, nx);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        
        X = Math.max(dp[N-1][0], dp[N-1][1]);        
        System.out.println(X);
    }
}
