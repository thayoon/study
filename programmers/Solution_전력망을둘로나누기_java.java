import java.util.*;

class Solution {
    static boolean[][] map;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        map = new boolean[n+1][n+1];
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }
        
        for(int i=0; i<wires.length; i++) {
            visited = new boolean[n+1];
            
            map[wires[i][0]][wires[i][1]] = false;
            map[wires[i][1]][wires[i][0]] = false;
            
            int cnt = dfs(1, 1, n);
            min = Math.min(min, Math.abs((n-cnt) - cnt));
            
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }
        
        return min;
    }
    
    /**
    * 연결된 송전탑 개수
    * @parms v: 현재 탐색 정점
    * @parms cnt: 탐색한 정점
    * @parms n: 송전탑 개수
    * @return cnt
    */
    private static int dfs(int v, int cnt, int n) {
        visited[v] = true;
        
        for(int i=1; i<=n; i++) {
            if(!visited[i] && map[v][i]) {
                cnt = dfs(i, cnt+1, n);
            }
        }
        return cnt;
    }
}