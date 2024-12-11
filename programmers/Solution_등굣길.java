import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        for(int[] puddle:puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(i==1 && j==1) {
                    map[i][j] = 1;
                } else if(map[i][j] == -1) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                }
            }
        }
        
        return map[n][m];
    }
}